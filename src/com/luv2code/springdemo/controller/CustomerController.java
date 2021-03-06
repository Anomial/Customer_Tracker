package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
		//inject customer service
		@Autowired
		private CustomerService customerService;
	
		@GetMapping("/list")
		public String listCustomers(Model theModel) {
			
			//get customers from DAO
			List<Customer> theCustomers = customerService.getCustomers();
			
			//add customers to the model
			theModel.addAttribute("customers",theCustomers);
			
			
			return "list-customers";
		}
		
		@GetMapping("/showFormForAdd")
		public String showFormForAdd(Model theModel) {
				
			
			 Customer theCustomer = new Customer();
			 theModel.addAttribute("customer",theCustomer);
			 
				return "customer-form";
		}
		
		@PostMapping("/saveCustomer")
		public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){
			
				//save the customer with the use of service
				customerService.saveCustomer(theCustomer);
			
				return "redirect:/customer/list";
		}
		
		
		
		@GetMapping("/showFormForUpdate")
		public String showFormForUpdate(@RequestParam("customerId") int theId,Model theModel) {
			
			//retrieve customer from database
			Customer theCustomer =  customerService.getCustomer(theId);
			theModel.addAttribute("customer",theCustomer);
			
			//set customer as model attribute
			return "customer-form";
			//send to form
			
		}
		
		@GetMapping("/delete")
		public String deleteCustomer(@RequestParam("customerId") int theId) {
			
			customerService.deleteCustomer(theId);
			return "redirect:/customer/list";
		}

}
