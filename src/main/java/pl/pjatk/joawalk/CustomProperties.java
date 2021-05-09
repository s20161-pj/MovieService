package pl.pjatk.joawalk;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "my.custom")
@ConditionalOnProperty(
        value="my.custom.enabled",
        havingValue = "true",
        matchIfMissing = true)
public class CustomProperties {
    private String property;
    private String random;

    public String getRandom() {
        return random;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public void setRandom(String random) {
        this.random = random;
    }
}
