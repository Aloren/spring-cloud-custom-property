package org.github;

import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.Collections;
import java.util.Map;

public class Application {

    public static void main(String[] args) {
        Map<String, Object> properties = Collections.singletonMap(
                "my.custom.property", "custom.value"
        );
        new SpringApplicationBuilder(Application.class)
                .web(false)
                .properties(properties)
                .run();
    }
}
