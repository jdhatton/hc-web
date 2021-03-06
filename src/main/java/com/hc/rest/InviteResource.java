package com.hc.rest;

import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.hc.rest.dto.Account;
import com.hc.rest.dto.SmsSendDTO;
import com.hc.services.util.EmailServiceHelper;
import com.hc.services.util.SmsServiceHelper;
import com.hrt.data.db.beans.User;

@RestController
@Component
public class InviteResource {
	
	@Autowired
	EmailServiceHelper emailHelper;
	
	@Autowired
	SmsServiceHelper smsHelper;
	
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
	
	

	@RequestMapping(value = "/testEmailInvite", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON })
	public ResponseEntity<String> testInvite() {
		try {
			System.out.println("  \n >>> TESTING Send Email");
			//
			// Test sending an email
			//
			User user = new User();
			user.setEmail("jdhatton@gmail.com");
			user.setFirstName("EmailTester");
			user.setLastName("Test");
			user.setId(0);

			emailHelper.register(user);

			return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("FAILURE", HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/testSmsInvite", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON })
	public ResponseEntity<String> testSmsInvite() {
		try {
			System.out.println("  \n >>> TESTING Send SMS Text Message");
			//
			// Test sending an SMS
			//
			User user = new User();
			user.setEmail("jdhatton@gmail.com");
			user.setFirstName("EmailTester");
			user.setLastName("Test");
			user.setPhone("9137074459");
			user.setId(0);
			
			String to =user.getPhone();
			String content =" Testing SMS";

			// send the SMS
			smsHelper.sendMessage("9137074459", "Dummy Test");

			return new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("failure", HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@RequestMapping(value = "/sendSmsTextMessage", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON})
    public ResponseEntity<SmsSendDTO> sendSmsMessage(@RequestBody final String json){  
    	 
		SmsSendDTO dto = null;
    	try {
			System.out.println(">>>  RECEIVED DATA  :  "+ json);
			ObjectMapper mapper = new ObjectMapper();
			dto = mapper.readValue(json, SmsSendDTO.class);
			String sendTo = dto.getPhoneNumber();
			String content =" Testing SMS";
			smsHelper.sendMessage(sendTo, content);
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
		}
    }

}
