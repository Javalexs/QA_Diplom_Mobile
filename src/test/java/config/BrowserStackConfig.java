package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:remote.properties"
})

public interface BrowserStackConfig extends Config {

    String userName();
    String passWord();

    @DefaultValue("bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c")
    String app();

    @DefaultValue("Google Pixel 4")
    String device();

    @DefaultValue("11.0")
    String osVersion();

}
