package com.berkayderin.starter;

import com.berkayderin.config.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.berkayderin")
@SpringBootTest(classes = AppConfig.class)
class SpringBootRestApiApplicationTests {

    @Test
    void contextLoads() {
    }

}
