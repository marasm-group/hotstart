package org.marasm.hotstart;


import org.apache.commons.lang3.SystemUtils;
import org.marasm.hotstart.locationproviders.MacCacheLocationProvider;
import org.marasm.hotstart.locationproviders.UnixCacheLocationProvider;
import org.marasm.hotstart.locationproviders.WindowsCacheLocationProvider;
import sun.jvm.hotspot.utilities.UnsupportedPlatformException;

public class Utils {

    public static final String FOLDER = "org.marasm.hotstart";

    static CacheLocationProvider getCacheLocationProvider() {
        if (SystemUtils.IS_OS_WINDOWS) {
            return new WindowsCacheLocationProvider();
        }
        if (SystemUtils.IS_OS_MAC) {
            return new MacCacheLocationProvider();
        }
        if (SystemUtils.IS_OS_UNIX) {
            return new UnixCacheLocationProvider();
        }
        throw new UnsupportedPlatformException(System.getProperty("os.name") + " is not supported!");
    }
}
