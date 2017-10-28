package com.shopping.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobleDefaultExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException() {

		ModelAndView mv = new ModelAndView("error");

		mv.addObject("errorTitle", "The Page is not Constructed!");
		mv.addObject("errorDiscrption", "The page you are looking is not available now!");
		mv.addObject("title", "404 Error Page");

		return mv;

	}
	
	
	
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException() {

		ModelAndView mv = new ModelAndView("error");

		mv.addObject("errorTitle", "Product is not available!");
		mv.addObject("errorDiscrption", "The products you are looking is not available right now!");
		mv.addObject("title", "Product unavailable");

		return mv;

	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex) {

		ModelAndView mv = new ModelAndView("error");

		mv.addObject("errorTitle", "Contact you are Administrator!");
		
		/*
		 * only for deugging you are application
		 * */
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);
		
		
		
		mv.addObject("errorDiscrption", sw.toString());
		mv.addObject("title", "Error");

		return mv;

	}
}
