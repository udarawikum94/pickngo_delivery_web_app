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

import com.esoft.coursework.domain.Vehicle;
import com.esoft.coursework.enumeration.RecordStatusEnum;
import com.esoft.coursework.serviceimpl.VehicleServiceImpl;
import com.esoft.coursework.util.UserSessionUtil;

/**
 * @author Udara Wikum
 * @since 22/11/2021 9.12PM
 * @version 1.0.0
 * @developde Intellige_idea
 */

@Controller
public class VehicleController {
	@Autowired
	private VehicleServiceImpl vehicleServiceImpl;

	public VehicleServiceImpl getVehicleServiceImpl() {
		return vehicleServiceImpl;
	}
	public void setVehicleServiceImpl(VehicleServiceImpl vehicleServiceImpl) {
		this.vehicleServiceImpl = vehicleServiceImpl;
	}

	@RequestMapping(value = "/vehicle", method = RequestMethod.GET)
	@ResponseBody
    public String allUsers() {
        JSONObject obj = new JSONObject();
        
        List<Vehicle> vehicleList = getVehicleServiceImpl().getAll();
        obj.put("vehicleList", vehicleList);
        
        return obj.toString();
    }
	
	@RequestMapping(value = "/vehicle", method = RequestMethod.POST)
	@ResponseBody
    public String create(@RequestBody String formBody, HttpServletRequest httpServletRequest) {
        String msg = "";
        JSONObject obj = new JSONObject();
        JSONObject paramObject = new JSONObject(formBody);
        JSONObject formObject = (JSONObject) paramObject.get("params");
        
        try {
        	UserSessionUtil userSessionUtil = UserSessionUtil.getUserSessionUtil(httpServletRequest);
        	if (userSessionUtil!=null) {
        		Vehicle existVehicle = getVehicleServiceImpl().getByVehicleNo(formObject.getString("vehicleNo"));
            	if (existVehicle==null) {
            		Vehicle vehicle = new Vehicle();
                    
            		vehicle.setVehicleNo(formObject.getString("vehicleNo"));
            		vehicle.setBrand(formObject.getString("brand"));
            		vehicle.setName(formObject.getString("name"));
            		vehicle.setStatus(RecordStatusEnum.ACTIVE.getDescription());
        			vehicle.setCreatedUser(userSessionUtil.getUserName());
        			vehicle.setCreatedDate(new Date());
                	
        			getVehicleServiceImpl().saveEntity(vehicle);
                	msg = "Record created successfully.!";
        		} else
        			msg = "Vehicle Number already exists.!";        	
        	} else 
        		msg = "Invalid user session";
		} catch (Exception e) {
			msg = "Error occured. Process did not completed successfully.";
		}
        
        obj.put("msg", msg);
        return obj.toString();
    }
	
	@RequestMapping(value = "/vehicle", method = RequestMethod.PUT)
	@ResponseBody
    public String updateOrDelete(@RequestBody String formBody, HttpServletRequest httpServletRequest) {
        String msg = "";
        JSONObject obj = new JSONObject();
        JSONObject paramObject = new JSONObject(formBody);
        JSONObject formObject = (JSONObject) paramObject.get("params");
        
        try {
        	UserSessionUtil userSessionUtil = UserSessionUtil.getUserSessionUtil(httpServletRequest);
        	if (userSessionUtil!=null) {
        		Vehicle vehicle = getVehicleServiceImpl().getById(formObject.getLong("userId"));
            	if (vehicle!=null) {
            		if (formObject.getString("type").equals("update")) {
                    	if (formObject.getString("vehicleNo")!=null && formObject.getString("vehicleNo")!="") 
                    		vehicle.setVehicleNo(formObject.getString("vehicleNo"));
                    	
                    	if (formObject.getString("brand")!=null && formObject.getString("brand")!="") 
                    		vehicle.setBrand(formObject.getString("brand"));
                    	
                    	if (formObject.getString("name")!=null && formObject.getString("name")!="") 
                    		vehicle.setName(formObject.getString("name"));
                    	
                    	vehicle.setModifiedUser(userSessionUtil.getUserName());
                    	vehicle.setModifiedDate(new Date());
                    	
                    	getVehicleServiceImpl().updateEntity(vehicle);
                        msg = "Record updated successfully.!";
    				} else {
    					getVehicleServiceImpl().deleteEntity(vehicle);
    	                msg = "Record deleted successfully.!";
    				}
        		} else
        			msg = "Record not found.!";
        	} else 
        		msg = "Invalid user session";
		} catch (Exception e) {
			msg = "Error occured. Process did not completed successfully.";
		}
        
        obj.put("msg", msg);
        return obj.toString();
    }
}