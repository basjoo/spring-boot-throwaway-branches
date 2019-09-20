package com.izeye.throwaway;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Home {@link RestController}.
 *
 * @author Johnny Lim
 */
@RestController
@RequestMapping(path = "/")
public class HomeController {

	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello, world!";
	}

	@GetMapping("/httpServletRequest")
	public String httpServletRequest(HttpServletRequest request) {
		StringBuffer requestURL = request.getRequestURL();
		System.out.println("requestURL: " + requestURL);
		requestURL.append("?a=b");
		System.out.println("requestURL: " + requestURL);
		System.out.println("request.getRequestURL(): " + request.getRequestURL());
		return request.toString();
	}

	@GetMapping("/throwException")
	public String throwException() {
		throw new RuntimeException("Expected.");
	}

	@GetMapping("/echo")
	public String echo(@RequestParam String value) {
		return value;
	}

}