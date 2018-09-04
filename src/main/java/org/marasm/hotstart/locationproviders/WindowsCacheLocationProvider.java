package org.marasm.hotstart.locationproviders;

import org.marasm.hotstart.CacheLocationProvider;
import org.marasm.hotstart.Utils;

import java.io.File;

public class WindowsCacheLocationProvider implements CacheLocationProvider {

    @Override
    public String cacheDirectory() {
        String appdata = System.getenv("APPDATA");
        return new File(appdata, Utils.FOLDER).getAbsolutePath();
    }
}
