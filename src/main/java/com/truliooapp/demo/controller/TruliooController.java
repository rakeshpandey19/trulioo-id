package com.truliooapp.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trulioo.normalizedapi.ApiException;
import com.trulioo.normalizedapi.model.VerifyResult;
import com.truliooapp.demo.service.TruliooService;
/**
 * Created by rpandey3 on 4/1/20.
 */
@RestController
@RequestMapping("/api")
public class TruliooController {

	@Autowired
	TruliooService truliooService;
	
	@GetMapping("/authenticate")
	public String authenticate() throws ApiException {
		return truliooService.authenticate();
	}
	
	@GetMapping("/countries")
	public List<String> getCountries() throws ApiException {
		return truliooService.getCountries();
	}
	
	@GetMapping("/verify")
	public VerifyResult verify() throws ApiException {
		return truliooService.verify();
	}
	
	@GetMapping("/verifyrest")
	public String verifyrest() throws ApiException {
		return truliooService.verifyUsingREST();
	}
}
