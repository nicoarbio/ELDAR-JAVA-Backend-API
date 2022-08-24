package com.challenge.eldar.API.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.eldar.API.models.API.ProcessingFee;

@RestController
public class MainController {

	@GetMapping ("/api/processingfee")
	@ResponseBody
	public ProcessingFee getProcessingFee(@RequestBody ProcessingFee pf){
		return pf;
	}
}
