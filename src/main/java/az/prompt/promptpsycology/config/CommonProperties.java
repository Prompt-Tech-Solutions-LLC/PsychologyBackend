package az.prompt.promptpsycology.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "prompt.psychology.common")
public class CommonProperties {
    private String jwtSigningKey;
    private boolean isDevMode;
}
