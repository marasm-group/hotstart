package org.marasm.hotstart.locationproviders;

import org.marasm.hotstart.CacheLocationProvider;
import org.marasm.hotstart.Utils;

import java.io.File;

public class UnixCacheLocationProvider implements CacheLocationProvider {

    @Override
    public String cacheDirectory() {
        String home = System.getProperty("user.home");
        return new File(home, "." + Utils.FOLDER).getAbsolutePath();
    }
}
