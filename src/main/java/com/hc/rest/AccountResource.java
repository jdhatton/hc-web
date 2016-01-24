package com.hc.rest;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.hc.rest.dto.Account;
import com.hc.services.UserServiceImpl;
import com.hrt.data.db.beans.User;

@RestController
@Component
public class AccountResource {

	@Autowired
	UserServiceImpl userService;

	@RequestMapping(value = "/createAccount", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON})
    public ResponseEntity<User> createAccount(@RequestBody final String account){  
    	User authUser =null;
    	try {
			System.out.println(">>>  RECEIVED DATA  :  "+ account.toString());
			ObjectMapper mapper = new ObjectMapper();
			//String jsonValue = "{\"role\":\"YOUKNOW\", \"token\":\"reerrrr\", \"firstName\":\"testing123\", \"lastName\":\"hhgbvccccccc\", \"email\":\"test@test.com\", \"password\":\"testpass\",\"rememberMe\":\"true\" }";
			
			//String jsonValue = account.get("newAccount").toString();
			ObjectNode node = mapper.readValue(account, ObjectNode.class);
			JsonNode jsonNode = node.get("newAccount");
			
			Account newAccount = new Account();
			newAccount.setRole(jsonNode.get("role").textValue());
			newAccount.setToken(jsonNode.get("token").textValue());
			newAccount.setEmail(jsonNode.get("email").textValue());
			newAccount.setFirstName(jsonNode.get("firstName").textValue());
			newAccount.setLastName(jsonNode.get("lastName").textValue());
			newAccount.setPassword(jsonNode.get("password").textValue());
			newAccount.setRememberMe(jsonNode.get("rememberMe").textValue());
			
			System.out.println("newAccount  =  " + newAccount.toString());

			long userId = userService.addUser(newAccount.getUser());
			authUser =userService.getUserById(userId);
			System.out.println("New User  =  " + authUser.toString());
			return new ResponseEntity<>(authUser, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(authUser, HttpStatus.BAD_REQUEST);
		}
    }

    @RequestMapping(value = "/logon", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON})
    public ResponseEntity<Account> authenticate(@RequestBody final String account){  
    	
    	Account user = null;
    	try {
			System.out.println(">>>  RECEIVED DATA  :  "+ account.toString());
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode node = mapper.readValue(account, ObjectNode.class);
			JsonNode jsonNode = node.get("user");
			
			user = new Account();
			user.setEmail(jsonNode.get("email").textValue());
			user.setPassword(jsonNode.get("password").textValue());
			user.setRememberMe(jsonNode.get("rememberMe").textValue());
			
			User authUser = userService.getUser(user.getEmail(), user.getPassword());
 
			if( null != authUser && authUser.getId() > 0) {
				if(authUser.getPassword().equals(user.getPassword())){
					user.setAuthenticated("YES");
					user.setRole(new Integer(authUser.getRole()).toString());
					user.setUserId( new Long(authUser.getId()).toString()); 
				} else{
					System.out.println("Logon FAILED :  Bad Password  " + user.getPassword());
					user.setAuthenticated("NO");
					user.setRole("");
					user.setUserId("0");
					return new ResponseEntity<>(user, HttpStatus.NON_AUTHORITATIVE_INFORMATION);
				}
			}
			
			System.out.println("Logon Account  =  " + user.toString());
			return new ResponseEntity<>(user, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
		}
    }
     
}
