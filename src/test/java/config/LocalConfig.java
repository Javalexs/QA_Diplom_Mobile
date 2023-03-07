package config;

import org.aeonbits.owner.Config;
//@LocalConfig.LoadPolicy(LocalConfig.LoadType.MERGE)
@Config.Sources(
        {"system:properties",
                "classpath:emulator.properties",
        })
public interface LocalConfig extends Config {

    @Key("appPackage")
    String getAppPackage();

    @Key("appActivity")
    String getAppActivity();

    @Key("device")
    String device();

    @Key("os_version")
    String osVersion();
}