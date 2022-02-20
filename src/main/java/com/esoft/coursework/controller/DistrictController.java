package com.esoft.coursework.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esoft.coursework.domain.District;
import com.esoft.coursework.serviceimpl.DistrictServiceImpl;
import com.esoft.coursework.util.UserSessionUtil;

/**
 * @author Udara Wikum
 * @since 19/02/2022 6.11PM
 * @version 1.0.0
 * @developde Intellige_idea
 */

@Controller
public class DistrictController {
	@Autowired
	private DistrictServiceImpl districtServiceImpl;

	public DistrictServiceImpl getDistrictServiceImpl() {
		return districtServiceImpl;
	}
	public void setDistrictServiceImpl(DistrictServiceImpl districtServiceImpl) {
		this.districtServiceImpl = districtServiceImpl;
	}

	@RequestMapping(value = "/district", method = RequestMethod.GET)
	@ResponseBody
    public String allUsers() {
        JSONObject obj = new JSONObject();
        
        List<District> districtList = getDistrictServiceImpl().getAll();
        obj.put("districtList", districtList);
        
        return obj.toString();
    }
	
	@RequestMapping(value = "/district", method = RequestMethod.POST)
	@ResponseBody
    public String createUser(@RequestBody String formBody, HttpServletRequest httpServletRequest) {
        String msg = "";
        JSONObject obj = new JSONObject();
        JSONObject paramObject = new JSONObject(formBody);
        JSONObject formObject = (JSONObject) paramObject.get("params");
        try {
        	UserSessionUtil userSessionUtil = UserSessionUtil.getUserSessionUtil(httpServletRequest);
        	if (userSessionUtil!=null) {
        		boolean status = getDistrictServiceImpl().isExistByCode(formObject.getString("code"));
            	if (!status) {
            		District district = new District();
                    
                	district.setCode(formObject.getString("code"));
                	district.setName(formObject.getString("name"));
                	district.setStatus(formObject.getString("status"));
                	district.setCreatedUser(userSessionUtil.getUserName());
                	district.setCreatedDate(new Date());
                	
                	getDistrictServiceImpl().save(district);
                    msg = "Record created successfully.!";
        		} else
        			msg = "District already exists.!";
        	} else 
        		msg = "Invalid district session";
		} catch (Exception e) {
			msg = "Error occured. Process did not completed successfully.";
		}
        
        obj.put("msg", msg);
        return obj.toString();
    }
	
	@RequestMapping(value = "/district", method = RequestMethod.PUT)
	@ResponseBody
    public String updateOrDeleteUser(@RequestBody String formBody, HttpServletRequest httpServletRequest) {
        String msg = "";
        JSONObject obj = new JSONObject();
        JSONObject paramObject = new JSONObject(formBody);
        JSONObject formObject = (JSONObject) paramObject.get("params");
        
        try {
        	UserSessionUtil userSessionUtil = UserSessionUtil.getUserSessionUtil(httpServletRequest);
        	if (userSessionUtil!=null) {
        		District district = getDistrictServiceImpl().getById(formObject.getLong("userId"));
            	if (district!=null) {
            		if (formObject.getString("type").equals("update")) {
                    	if (formObject.getString("code")!=null && formObject.getString("code")!="") 
                    		district.setCode(formObject.getString("code"));
                    	
                    	if (formObject.getString("name")!=null && formObject.getString("name")!="") 
                    		district.setName(formObject.getString("name"));
                    	
                    	if (formObject.getString("status")!=null && formObject.getString("status")!="") 
                    		district.setStatus(formObject.getString("status"));
                    	
                    	district.setModifiedUser(userSessionUtil.getUserName());
                    	district.setModifiedDate(new Date());
                    	
                    	getDistrictServiceImpl().update(district);
                        msg = "Record updated successfully.!";
    				} else {
    					getDistrictServiceImpl().delete(district);
    	                msg = "Record deleted successfully.!";
    				}
        		} else
        			msg = "District not found.!";
        	} else 
        		msg = "Invalid district session";
		} catch (Exception e) {
			msg = "Error occured. Process did not completed successfully.";
		}
        
        obj.put("msg", msg);
        return obj.toString();
    }
}
