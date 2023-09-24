package config;

import org.aeonbits.owner.Config;
@Config.Sources({
        "classpath:config/local.properties"
})

public interface LocalConfig extends Config {

    @Key("platformName")
    String platformName();

    @Key("deviceName")
    String deviceName();

    @Key("os_version")
    String osVersion();
}
