package org.marasm.hotstart;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public interface CacheLocationProvider {

    String cacheDirectory();

    default File cacheFile(Class aClass) throws IOException {
        File cacheFile = new File(cacheDirectory(), aClass.getCanonicalName() + ".properties");
        Files.createDirectories(Paths.get(cacheFile.getParentFile().getAbsolutePath()));
        return cacheFile;
    }

}
