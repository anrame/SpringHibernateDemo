package com.wipro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wipro.dao.CustomerDAO;
import com.wipro.model.Customer;
import com.wipro.service.CustomerService;

@Controller
@RequestMapping("customers")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping("list")
	public ModelAndView showAll()
	{
		List<Customer> list=customerService.getCustomers();
		System.out.println(list.size());
		ModelAndView mv=new ModelAndView();
		mv.addObject("customer",list);
		mv.setViewName("list-customers");
		return mv;
	}

	@RequestMapping("addCustomer")
	public String addCustomer(Model model)
	{
		Customer theCustomer=new Customer();
		model.addAttribute("customer",theCustomer);
		return "customerForm";
	}
	
	@RequestMapping("saveCustomer")
	public String saveCustomer(@ModelAttribute("customer")Customer theCustomer)
	{
		
		customerService.saveCustomer(theCustomer);
		return "redirect:/customers/list";
	}
	@RequestMapping("updateCustomer")
	public String updateCustomer(@RequestParam("customerId") int id,Model model)
	{
		//get customer details based on customerID
		Customer theCustomer=customerService.getCustomer(id);
		
		//populate Model
		model.addAttribute("customer",theCustomer);
		//Show View
		
		return "customerForm";
	}
	
	@RequestMapping("deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId")int id)
	{
		//invoke service class delete method
		customerService.deleteCustomer(id);
   return "redirect:/customers/list";
   }
}
