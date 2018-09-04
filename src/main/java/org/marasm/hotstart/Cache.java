package org.marasm.hotstart;

import lombok.Setter;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;

public class Cache {

    @Setter
    private CacheLocationProvider locationProvider = Utils.getCacheLocationProvider();

    private Class cachedClass;
    private Properties properties = new Properties();

    @SneakyThrows
    public Cache(Class cachedClass) {
        this.cachedClass = cachedClass;
        load();
    }

    @SneakyThrows
    private void load() {
        properties = new Properties();
        File cacheFile = locationProvider.cacheFile(cachedClass);
        if (cacheFile.exists()) {
            properties.load(new FileReader(cacheFile));
        }
    }

    @SneakyThrows
    public void save() {
        properties.store(new FileWriter(locationProvider.cacheFile(cachedClass)), "Just some pre-cached stuff to speed up startup, feel free to remove");
    }

    @SneakyThrows
    public void invalidateAll() {
        properties = new Properties();
        save();
    }

    public String get(String key, PropertySupplier supplier) {
        if (properties.containsKey(key)) {
            return properties.getProperty(key);
        }
        String value = supplier.get();
        properties.setProperty(key, value);
        save();
        return value;
    }

    public String get(String key, String defaultValue) {
        return get(key, () -> defaultValue);
    }

    public interface PropertySupplier {
        String get();
    }
}
