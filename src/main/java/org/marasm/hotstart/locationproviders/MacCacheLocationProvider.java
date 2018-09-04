package org.marasm.hotstart.locationproviders;

import org.marasm.hotstart.CacheLocationProvider;
import org.marasm.hotstart.Utils;

import java.io.File;

public class MacCacheLocationProvider implements CacheLocationProvider {
    @Override
    public String cacheDirectory() {
        String home = System.getenv("HOME");
        File library = new File(home, "Library");
        File caches = new File(library, "Caches");
        File cacheDirectory = new File(caches, Utils.FOLDER);
        return cacheDirectory.getAbsolutePath();
    }
}
