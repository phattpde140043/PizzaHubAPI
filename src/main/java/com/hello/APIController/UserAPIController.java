package com.hello.APIController;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hello.Controller.*;
import com.hello.Model.*;


@RestController
@RequestMapping("/user")
public class UserAPIController {
	
	
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping(value = "/account/{username}", method = RequestMethod.GET)
	public ResponseEntity<Account> GetAccountbyUsername(@PathVariable("username") String UserName){
		try {
		String password = userDAO.GetAccountByUserName(UserName);
		if(password==null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Account>(new Account(UserName, password), HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/info/{username}", method = RequestMethod.GET)
	public ResponseEntity<User> GetUserInfobyUsername(@PathVariable("username") String UserName){
		try {
		User result = userDAO.GetUserinfoByUserName(UserName);
		if(result==null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<User>(result, HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/info/", method = RequestMethod.PUT)
	public ResponseEntity<User> saveContact(@Validated @RequestBody User us) {
		return new ResponseEntity<User>(userDAO.UpdateUserInfo(us), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/account/", method = RequestMethod.POST)
	public int createAccount(@Validated @RequestBody Account acc) {
		return userDAO.CreateNewAccount(acc.getUserName(), acc.getPassword());
	}

}
