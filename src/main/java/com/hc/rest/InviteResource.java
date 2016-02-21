package com.hc.rest;

import javax.ws.rs.core.MediaType;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class InviteResource {
	
	public InviteResource() { }
	
	@RequestMapping(value = "/inviteParent", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON})
    public ResponseEntity<String> inviteParent(@RequestBody final String data){  
		try {
			System.out.println(">>>  RECEIVED DATA  :  "+ data);
				
			//
			// Parse and Validate input.
			//
			
			//
			// Get all neccessary data to send email and join data
			//
			
			//
			// Get or generate token
			//
			
			//
			// Associate the data.
			//
			
			//
			// Send the email to the parent
			//
//			emailDriver.testEmailSending();
			
			//
			// FUTURE: send notification to the teacher app that invitation was sent. 
			//
			
			return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("FAILURE", HttpStatus.BAD_REQUEST);
		}
		
	}
	
}
