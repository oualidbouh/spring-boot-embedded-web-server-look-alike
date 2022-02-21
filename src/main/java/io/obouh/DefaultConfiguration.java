package io.obouh;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DefaultConfiguration {

    @Bean
    public TomcatLauncher tomcatLauncher(){
        return new TomcatLauncher();
    }
}
