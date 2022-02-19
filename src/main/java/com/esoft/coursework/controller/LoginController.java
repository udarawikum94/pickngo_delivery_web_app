package com.esoft.coursework.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.esoft.coursework.domain.OperationalCenter;
import com.esoft.coursework.domain.User;
import com.esoft.coursework.serviceimpl.LoginServiceImpl;
import com.esoft.coursework.serviceimpl.UserServiceImpl;
import com.esoft.coursework.util.UserSessionUtil;

@Controller
@SessionAttributes("user")
public class LoginController {
	
	@Autowired
	private LoginServiceImpl loginServiceImpl;
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	public LoginServiceImpl getLoginServiceImpl() {
		return loginServiceImpl;
	}
	public void setLoginServiceImpl(LoginServiceImpl loginServiceImpl) {
		this.loginServiceImpl = loginServiceImpl;
	}

	public UserServiceImpl getUserServiceImpl() {
		return userServiceImpl;
	}
	public void setUserServiceImpl(UserServiceImpl userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}
	
	@SuppressWarnings("unused")
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ModelAttribute("user")
	@ResponseBody
    public JSONObject validateUsr(@RequestParam("username")String username, @RequestParam("password")String password, HttpServletRequest request) {
        String msg = "";
        JSONObject obj = new JSONObject();
        User user = getLoginServiceImpl().getUserLogin(username, password);
        
        if (user!= null) {
        	OperationalCenter operationalCenter = new OperationalCenter();
			obj.put("userId", user.getId()); 
			obj.put("userName", user.getUsername());
			obj.put("designation", user.getDesignation());
			obj.put("userCode", user.getCode());
			
			if (operationalCenter!=null)
				obj.put("collectionCenter", operationalCenter);
			else {
				obj = new JSONObject();
				obj.put("msg", "Collection center not mapped");
				return obj;
			}
			
        	UserSessionUtil sessionUtil = new UserSessionUtil();
        	sessionUtil.setUserId(user.getId());
        	sessionUtil.setUserName(user.getUsername());
        	sessionUtil.setDesignation(user.getDesignation());
        	sessionUtil.setUserCode(user.getCode());
        	sessionUtil.setCollectionCenter(operationalCenter);
        	
        	HttpSession httpSession = request.getSession();
        	httpSession.setAttribute("userSession", sessionUtil);
        	
        	msg = "Welcome " + username + "!";
        	obj.put("msg", msg);
		} else {
			msg = "Invalid credentials";
			obj.put("msg", msg);
		}
        return obj;
    }
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String goodbye(SessionStatus status, HttpSession httpSession) {
		httpSession.invalidate();
		
		String msg = "Logged out successfully!";
		status.setComplete();
		
		return msg;
	}

}
