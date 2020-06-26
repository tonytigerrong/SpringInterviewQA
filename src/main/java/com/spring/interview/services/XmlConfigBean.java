package com.spring.interview.services;

import org.springframework.context.annotation.ImportResource;

/*
 * this bean inject by applicationContext.xml
 * applicationContext.xml inject by @Configure & @ImportResource({"classpath*:applicationContext.xml"})
 */
public class XmlConfigBean {
	public String toString() {
		return "XmlConfigBean";
	}
}
