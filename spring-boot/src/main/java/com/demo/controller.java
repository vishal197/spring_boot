package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class controller {

	@RequestMapping(value="/",method=RequestMethod.GET)
	  public ModelAndView Loadpage()
	   {
		return new ModelAndView("hello");
		}
}
