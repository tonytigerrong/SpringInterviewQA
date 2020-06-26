package com.spring.interview.configs;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.ImportResource;

@SpringBootConfiguration
@ImportResource({"classpath*:applicationContext.xml"})
public class XmlConfigure {

}
