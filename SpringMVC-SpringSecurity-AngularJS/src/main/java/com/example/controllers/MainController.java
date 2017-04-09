package com.example.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.repository.UserRepository;


@Controller
public class MainController {
	
	private static final String ISACTIVE = "1";
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value = "/") // , method = RequestMethod.GET
	public String index() {
		return "index";
	}

	@RequestMapping("/403")
	public String accessDenied() {
		return "login";
	}

	@RequestMapping("/404")
	public String pageNotFound() {
		return "index";
	}

	@ExceptionHandler(Exception.class)
	public String globalExceptionHandler(Exception e) {		
		return "index";
	}

	@RequestMapping("/login")
	public String getLogin() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		
		if (username != "anonymousUser") {
			String role = userRepository.findByUsername(username).getActive();
			
			if (role.equals(ISACTIVE)) {
				
				return "/";
			}
		}
		return "login";
	}  
	  // Login form with error
	  @RequestMapping("/login-error.html")
	  public String loginError(Model model) {
		  model.addAttribute("loginError", true);
		  return "login";
	  }

	@RequestMapping("/logout")
	public String getLogout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {			
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}

	@RequestMapping(value = "/home") // , method = RequestMethod.GET
	public String home() {
		return "index";
	}

	@RequestMapping("/404.html")
	public String render404() {
		// Add model attributes
		return "login";
	}

}
