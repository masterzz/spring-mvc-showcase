package org.springframework.ioc.enjoy.cap9.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ioc.enjoy.cap9.service.TestService;
import org.springframework.stereotype.Controller;

@Controller
public class TestController {
	@Autowired
	private TestService testService;
}
