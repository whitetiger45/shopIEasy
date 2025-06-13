package com.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.Customer;
import com.model.Queries;
import com.service.CustomerService;
import com.service.QueriesService;

@Controller
public class HomeController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping({ "/index", "/index1" })
	public String sayIndex() {
		return "index1";
	}

	@RequestMapping("/hello")
	public ModelAndView sayHello() {
		return new ModelAndView("hello", "hello", "Hello World");
	}

	@RequestMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {
		if (error != null)
			model.addAttribute("error", "Invalid username and Password");
		if (logout != null)
			model.addAttribute("logout", "You have logged out successfully");
		return "login";
	}

	@RequestMapping("/aboutus")
	public String sayAbout() {
		return "aboutUs";
	}
	
	@RequestMapping("/userProfile")
	public ModelAndView getUserProfile(ModelAndView model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String emailId = user.getUsername();
		Customer customer = customerService.getCustomerByemailId(emailId);
		model.addObject("customer", customer);
		model.setViewName("userProfile");
		return model;
	}

	@Autowired
	private QueriesService queryService;

	@RequestMapping(value = "/contactus")
	public ModelAndView getQuery() {
		Queries query = new Queries();
		return new ModelAndView("contactUs", "contact", query);
	}

	@RequestMapping(value = "/contactus", method = RequestMethod.POST)
	public String addQuery(@Valid @ModelAttribute(value = "contact") Queries query, Model model, BindingResult result) {
		String successMessage = "Thank you, we have received your message and will be in touch soon!";
		String errorMessage = "There was an error saving your query, please try again. We apologize for the inconvenience!";
		
		if (result.hasErrors())
			return "contactUs";
		
		if(queryService != null) {
			queryService.addQuery(query);
			model.addAttribute("querySuccess",successMessage);
		} else {
			model.addAttribute("querySuccess",errorMessage);
		}
		return "login";

	}
}
