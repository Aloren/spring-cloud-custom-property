package org.github;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;

public class CustomEnvironmentPostProcessor implements EnvironmentPostProcessor {

    private static final String MY_CUSTOM_PROPERTY = "my.custom.property";

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        String value = environment.resolvePlaceholders("${" + MY_CUSTOM_PROPERTY + ":}");

        if (value.isEmpty()) {
            throw new IllegalStateException("Failed to resolve placeholder: " + MY_CUSTOM_PROPERTY);
        }

        System.out.println("Successfully resolved placeholder: " + MY_CUSTOM_PROPERTY + " value: " + value);
    }
}
