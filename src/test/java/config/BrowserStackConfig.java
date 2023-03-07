package config;

import org.aeonbits.owner.Config;
//@BrowserStackConfig.LoadPolicy(BrowserStackConfig.LoadType.MERGE)
@Config.Sources({
                "classpath:${env}.properties"
})
public interface BrowserStackConfig extends Config {
    @Key("login")
    String login();

    @Key("password")
    String password();


    @Key("appURL")
    String appUrl();

    @Key("device")
    String device();

    @Key("os_version")
    String osVersion();

    @Key("project")
    String projectName();

    @Key("build")
    String buildName();

    @Key("name")
    String testName();
}