package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:local.properties"
})

public interface LocalConfig extends Config {

    @DefaultValue("android")
    String platformName();

    @DefaultValue("Nexus 5 API 33")
    String deviceName();

    @DefaultValue("11.0")
    String osVersion();

}