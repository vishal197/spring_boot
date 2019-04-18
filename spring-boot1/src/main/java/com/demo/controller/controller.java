package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.modal.insVO;
import com.demo.service.insService;



@Controller
public class controller {

	@Autowired
	insService INSService;

	/*@RequestMapping(value = "/insert.html", method = RequestMethod.GET)
	public ModelAndView dataInsert() {

		List<Customer> listOfCustomers = customerService.getAllCustomers();
		model.addAttribute("customer", new Customer());
		model.addAttribute("listOfCustomers", listOfCustomers);
		return "Admin/Index";
	}
	
	
/*	@RequestMapping(value = "/getAllCustomers", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getAllCustomers(Model model) {

		List<Customer> listOfCustomers = customerService.getAllCustomers();
		model.addAttribute("customer", new Customer());
		model.addAttribute("listOfCustomers", listOfCustomers);
		return "customerDetails";
	}*/
	
	@RequestMapping(value = "/loadsearch", method = RequestMethod.GET)
	public ModelAndView gotosearch() {
	
		return new ModelAndView("search","x",new insVO()) ;
	}
	@RequestMapping(value = "/loaddelete", method = RequestMethod.GET)
	public ModelAndView gotodelete() {
	
		return new ModelAndView("delete","x",new insVO()) ;
	}
	@RequestMapping(value = "/loadinsert", method = RequestMethod.GET)
	public ModelAndView goToHomePage() {
	
		return new ModelAndView("index","x",new insVO()) ;
	}
	
/*	@RequestMapping(value = "/getCustomer/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Customer getCustomerById(@PathVariable int id) {
		return customerService.getCustomer(id);
	}*/
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST, headers = "Accept=application/json")
	public ModelAndView addCustomer(@ModelAttribute("x") insVO customer) {	
		
		{
			INSService.insun(customer);
		}
		
		return new ModelAndView("login","x",new insVO());
	}
	/*@RequestMapping(value = "/delete", method = RequestMethod.POST, headers = "Accept=application/json")
	public String deleteuser(@ModelAttribute("x") insVO customer) {	
		
		{
			INSService.deleteuser(customer);
		}
		
		return "redirect:/delete";
	}*/
	@RequestMapping(value = "/search", method = RequestMethod.POST, headers = "Accept=application/json")
	public ModelAndView searchuser(@ModelAttribute("x") insVO customer) {	
		
		
			List ls=INSService.searchuser(customer);

		return new ModelAndView("search","x",new insVO()).addObject("ls", ls);
	}
	
	@RequestMapping(value = "/verify", method = RequestMethod.POST, headers = "Accept=application/json")
	public ModelAndView verifyuser(@ModelAttribute("x") insVO customer) {	
		
		
			List ls=INSService.searchuser(customer);
			
			if(ls.size()==0){
		return new ModelAndView("login","x",new insVO()).addObject("message", "invalid username and password");
			}
			else
				return new ModelAndView("welcome","x",ls);
	}
	
	@RequestMapping(value="deleteData.html",method=RequestMethod.GET)
	public ModelAndView deleteData(@RequestParam("id") int id,insVO regVO)
	{	
		regVO.setId(id);
		INSService.deleteuser(regVO);
		return new ModelAndView("search","x",new insVO());
	}
	/*@RequestMapping(value="editData.html",method=RequestMethod.GET)
	public ModelAndView editData(@RequestParam("id") int id1,insVO regVO)
	{	
		regVO.setId(id1);
		List ls = INSService.search_edit(regVO);
		return new ModelAndView("edit","data",(insVO)(ls.get(0)));
		
	}*/
	/*@RequestMapping(value="updateData.html",method=RequestMethod.POST)
	public ModelAndView updateData(@ModelAttribute("data") insVO regVO){
		INSService.updateData(regVO);
		return new ModelAndView("search");
	}*/
	/*@RequestMapping(value = "/updateCustomer/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateCustomer(@PathVariable("id") int id,Model model) {
		model.addAttribute("customer", this.customerService.getCustomer(id));
		model.addAttribute("listOfCustomers", this.customerService.getAllCustomers());
		return "customerDetails";
	}

	@RequestMapping(value = "/deleteCustomer/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteCustomer(@PathVariable("id") int id) {
		customerService.deleteCustomer(id);
		return "redirect:/getAllCustomers";

	}*/
	
}