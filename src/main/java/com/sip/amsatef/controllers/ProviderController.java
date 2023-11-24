package com.sip.amsatef.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sip.amsatef.entities.Provider;
import com.sip.amsatef.services.ProviderService;

@Controller
@RequestMapping("/providers")
public class ProviderController {
	@Autowired
	ProviderService service;
	
	@RequestMapping("/add")
	@ResponseBody
	public String add(){
		Provider p1= new Provider("Samsung","korea","215487");
		Provider p2= new Provider("huawei","china","215487");
				Provider p3= new Provider("iphone","usa","365214");
				
				service.addProvider(p1);
				service.addProvider(p2);
				service.addProvider(p3);
		
		return service.addProvider(p1).toString();
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public String list(){
		List<Provider> res = service.listProvider();
		return res.toString();
	}
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(){
		//List<Provider> res = service.listProvider();
		return service.delete(2);
	}
	 @RequestMapping("/update/{id}")
	 @ResponseBody
	    public  String updateProvider(@PathVariable Long id) {
	        Provider existingProvider = service.getProviderById(id);
	        if (existingProvider instanceof Provider) {
	            existingProvider.setName("Malek");
	            return service.addProvider(existingProvider).toString();
	        } else {
	            return "empty"; 
	        }
}
}
