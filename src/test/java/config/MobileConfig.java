package config;

import org.aeonbits.owner.Config;


@Config.Sources({
        "classpath:remote.properties"})
public interface MobileConfig extends Config {
    @Key("userName")
    String browserstackLogin();
    @Key("passWord")
    String browserstackPassword();
    @Key("deviceName")
    String deviceName();

    @Key("platformName")
    String platformName();

    @Key("platformVersion")
    String platformVersion();

    @Key("browserstackUrl")
//    @DefaultValue("http://hub.browserstack.com/wd/hub")
    String browserstackUrl();

    @Key("app")
//    @DefaultValue("bs://b3329f44da140f8046974f5ecdba6c1d950fb9e9")
    String app();

    @Key("host")
    @DefaultValue("remote")
    String deviceHost();



}