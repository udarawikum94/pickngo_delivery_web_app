package com.esoft.coursework.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esoft.coursework.domain.CollectionCenter;
import com.esoft.coursework.domain.User;
import com.esoft.coursework.serviceimpl.UserServiceImpl;
import com.esoft.coursework.util.UserSessionUtil;

/**
 * @author Udara Wikum
 * @since 22/11/2021 6.11PM
 * @version 1.0.0
 * @developde Intellige_idea
 */

@Controller
public class UserController {
	@Autowired
	private UserServiceImpl userServiceImpl;

	public UserServiceImpl getUserServiceImpl() {
		return userServiceImpl;
	}
	public void setUserServiceImpl(UserServiceImpl userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	@ResponseBody
    public String allUsers() {
        JSONObject obj = new JSONObject();
        
        List<User> userList = getUserServiceImpl().getAllUser();
        obj.put("userList", userList);
        
        return obj.toString();
    }
	
	@SuppressWarnings("unused")
	@RequestMapping(value = "/user/username/{username}", method = RequestMethod.GET)
	@ResponseBody
    public String userByUsername(@PathVariable(value = "username", required = true) String username) {
        JSONObject obj = new JSONObject();
        
        Optional<User> user = getUserServiceImpl().getUserByUsername(username);
        if (user.isPresent()) {
        	CollectionCenter collectionCenter = new CollectionCenter();
        	obj.put("userId", user.get().getId()); 
			obj.put("userName", user.get().getUsername());
			obj.put("designation", user.get().getDesignation());
			obj.put("userCode", user.get().getCode());
			
			//if (collectionCenter!=null)
				//obj.put("collectionCenter", collectionCenter);
			//else {
				//obj = new JSONObject();
				//obj.put("msg", "Collection center not mapped");
				//return obj;
			//}
        }
        return obj.toString();
    }
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	@ResponseBody
    public String createUser(@RequestBody String formBody, HttpServletRequest httpServletRequest) {
        String msg = "";
        JSONObject obj = new JSONObject();
        JSONObject paramObject = new JSONObject(formBody);
        JSONObject formObject = (JSONObject) paramObject.get("params");
        try {
        	UserSessionUtil userSessionUtil = UserSessionUtil.getUserSessionUtil(httpServletRequest);
        	if (userSessionUtil!=null) {
        		boolean status = getUserServiceImpl().isExistUserByCode(formObject.getString("code"));
            	if (!status) {
            		User user = new User();
                    
                	user.setCode(formObject.getString("code"));
                	user.setDesignation(formObject.getString("designation"));
                	user.setName(formObject.getString("name"));
                	//user.setCollectionCenterId(formObject.getLong("collectionCenterId"));
                	user.setUsername(formObject.getString("username"));
                	user.setPassword(formObject.getString("password"));
                	user.setCreatedUser(userSessionUtil.getUserName());
                	user.setCreatedDate(new Date());
                	
                	getUserServiceImpl().saveUser(user);
                    msg = "Record created successfully.!";
        		} else
        			msg = "User already exists.!";
        	} else 
        		msg = "Invalid user session";
		} catch (Exception e) {
			msg = "Error occured. Process did not completed successfully.";
		}
        
        obj.put("msg", msg);
        return obj.toString();
    }
	
	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	@ResponseBody
    public String updateOrDeleteUser(@RequestBody String formBody, HttpServletRequest httpServletRequest) {
        String msg = "";
        JSONObject obj = new JSONObject();
        JSONObject paramObject = new JSONObject(formBody);
        JSONObject formObject = (JSONObject) paramObject.get("params");
        
        try {
        	UserSessionUtil userSessionUtil = UserSessionUtil.getUserSessionUtil(httpServletRequest);
        	if (userSessionUtil!=null) {
        		User user = getUserServiceImpl().getUserById(formObject.getLong("userId"));
            	if (user!=null) {
            		if (formObject.getString("type").equals("update")) {
                    	if (formObject.getString("code")!=null && formObject.getString("code")!="") 
                    		user.setCode(formObject.getString("code"));
                    	
                    	if (formObject.getString("designation")!=null && formObject.getString("designation")!="") 
                    		user.setDesignation(formObject.getString("designation"));
                    	
                    	if (formObject.getString("name")!=null && formObject.getString("name")!="") 
                    		user.setName(formObject.getString("name"));
                    	
                    	//if (formObject.getString("collectionCenterId")!=null && formObject.getString("collectionCenterId")!="") 
                    		//user.setCollectionCenterId(formObject.getLong("collectionCenterId"));
                    	
                    	if (formObject.getString("username")!=null && formObject.getString("username")!="") 
                    		user.setUsername(formObject.getString("username"));
                    	
                    	if (formObject.getString("password")!=null && formObject.getString("password")!="") 
                    		user.setPassword(formObject.getString("password"));
                    	
                    	user.setModifiedUser(userSessionUtil.getUserName());
                    	user.setModifiedDate(new Date());
                    	
                    	getUserServiceImpl().updateUser(user);
                        msg = "Record updated successfully.!";
    				} else {
    					getUserServiceImpl().deleteUser(user);
    	                msg = "Record deleted successfully.!";
    				}
        		} else
        			msg = "User not found.!";
        	} else 
        		msg = "Invalid user session";
		} catch (Exception e) {
			msg = "Error occured. Process did not completed successfully.";
		}
        
        obj.put("msg", msg);
        return obj.toString();
    }
}
