package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:${env}.properties"
})

public interface ProjectConfig extends Config {
        @Key("login")
        String getLogin();

        @Key("password")
        String getPassword();

        @Key("project")
        String getProjectName();

        @Key("build")
        String getBuildName();

        @Key("test_name")
        String getTestName();

        @Key("remoteDriverUrl")
        String getDriverUrl();

        @Key("app")
        String getApp();

        @Key("device")
        String getDevice();

        @Key("os_version")
        String getOsVersion();

        @Key("platformName")
        String getPlatformName();

        @Key("localDriverUrl")
        String getLocalDriverUrl();

        @Key("apppackage")
        String getAppPackage();

        @Key("appactivity")
        String getAppActivity();

        @Key("appPath")
        String getAppPath();

        @Key("appUrl")
        String getAppUrl();


}