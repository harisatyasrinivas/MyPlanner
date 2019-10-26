package org.satya.myplanner.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.satya.myplanner.model.User;
import org.satya.myplanner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	public UserController() {
		System.out.println("User Controller accesses");
	}
	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public ModelAndView homePage(ModelAndView model) throws IOException{
//		model.setViewName("home");
//		return model;
//	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView userRegistration(ModelAndView model) throws IOException {
		User user = new User();
		model.addObject("User", user);
		model.setViewName("home");
		return model;

	}

	// if user id is 0 then creating the user other updating the user
	@RequestMapping(value = "/saveProfile", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute User user) {
		if (user.getUserID() == 0) {
			userService.registerUserProfile(user);
		} else {
			userService.updateUserProfile(user.getUserID());
		}
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/deleteProfile", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(HttpServletRequest request) {
		
		int userId = Integer.parseInt(request.getParameter("userID"));
		userService.deleteProfile(userId);
		return new ModelAndView("redirect:/");
	}

}
