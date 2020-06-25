package com.spring.interview.exceptions.customhandlerexceptionresolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

/***
 * TODO: This class is not finished
 * @author jianzhong.rong
 *
 */
//@Component
public class RestResponseStatusExceptionResolver extends AbstractHandlerExceptionResolver{

	@Override
	protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		System.out.println("_-_-_-_RestResponseStatusExceptionResolver"+request.getRequestURI());
		return new ModelAndView("error.jsp");
	}

}
