package com.esoft.coursework.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esoft.coursework.domain.OperationalCenter;
import com.esoft.coursework.enumeration.RecordStatusEnum;
import com.esoft.coursework.serviceimpl.CollectionCenterServiceImpl;
import com.esoft.coursework.util.UserSessionUtil;

/**
 * @author Udara Wikum
 * @since 23/11/2021 6.35PM
 * @version 1.0.0
 * @developde Intellige_idea
 */

@Controller
public class CollectionCenterController {
	@Autowired
	private CollectionCenterServiceImpl collectionCenterServiceImpl;

	public CollectionCenterServiceImpl getCollectionCenterServiceImpl() {
		return collectionCenterServiceImpl;
	}
	public void setCollectionCenterServiceImpl(CollectionCenterServiceImpl collectionCenterServiceImpl) {
		this.collectionCenterServiceImpl = collectionCenterServiceImpl;
	}

	@RequestMapping(value = "/collection-center", method = RequestMethod.GET)
	@ResponseBody
    public String allCollectionCenters() {
        JSONObject obj = new JSONObject();
        
        List<OperationalCenter> collectionCenterList = getCollectionCenterServiceImpl().getAllCollectionCenter();
        obj.put("collectionCenterList", collectionCenterList);
        
        return obj.toString();
    }
	
	@RequestMapping(value = "/collection-center/id/{recordId}", method = RequestMethod.GET)
	@ResponseBody
    public String getCollectionCenterById(@PathVariable(value = "recordId", required = true) Long recordId) {
        JSONObject obj = new JSONObject();
        
        OperationalCenter operationalCenter = getCollectionCenterServiceImpl().getCollectionCenterById(recordId);
        obj.put("collectionCenterId", operationalCenter.getId());
        obj.put("collectionCenterCode", operationalCenter.getCode());
        obj.put("collectionCenterName", operationalCenter.getName());
        
        return obj.toString();
    }
	
	@RequestMapping(value = "/collection-center", method = RequestMethod.POST)
	@ResponseBody
    public String createCollectionCenter(@RequestBody String formBody, HttpServletRequest httpServletRequest) {
        String msg = "";
        JSONObject obj = new JSONObject();
        JSONObject paramObject = new JSONObject(formBody);
        JSONObject formObject = (JSONObject) paramObject.get("params");
        try {
        	UserSessionUtil userSessionUtil = UserSessionUtil.getUserSessionUtil(httpServletRequest);
        	if (userSessionUtil!=null) {
        		boolean status = getCollectionCenterServiceImpl().isExistCollectionCenterByCode(formObject.getString("code"));
            	if (!status) {
            		OperationalCenter operationalCenter = new OperationalCenter();
                    
            		operationalCenter.setCode(formObject.getString("code"));
            		operationalCenter.setAddress(formObject.getString("address"));
            		operationalCenter.setName(formObject.getString("name"));
					/*
					 * operationalCenter.setCollectionLimit(formObject.getBigDecimal(
					 * "collectionLimit"));
					 * operationalCenter.setCapacity(formObject.getBigDecimal("capacity"));
					 * operationalCenter.setContactNo1(formObject.getString("contactNo1"));
					 * operationalCenter.setContactNo2(formObject.getString("contactNo2"));
					 */
            		operationalCenter.setStatus(RecordStatusEnum.ACTIVE.getDescription());
            		operationalCenter.setDescription(formObject.getString("description"));
            		operationalCenter.setCreatedUser(userSessionUtil.getUserName());
            		operationalCenter.setCreatedDate(new Date());
                	
                	getCollectionCenterServiceImpl().saveCollectionCenter(operationalCenter);
                    msg = "Record created successfully.!";
        		} else
        			msg = "Collection center data already exists.!";
        	} else 
        		msg = "Invalid user session";
		} catch (Exception e) {
			msg = "Error occured. Process did not completed successfully.";
		}
        
        obj.put("msg", msg);
        return obj.toString();
    }
	
	@RequestMapping(value = "/collection-center", method = RequestMethod.PUT)
	@ResponseBody
    public String updateClient(@RequestBody String formBody, HttpServletRequest httpServletRequest) {
        String msg = "";
        JSONObject obj = new JSONObject();
        JSONObject paramObject = new JSONObject(formBody);
        JSONObject formObject = (JSONObject) paramObject.get("params");
        
        try {
        	UserSessionUtil userSessionUtil = UserSessionUtil.getUserSessionUtil(httpServletRequest);
        	if (userSessionUtil!=null) {
        		OperationalCenter operationalCenter = getCollectionCenterServiceImpl().getCollectionCenterById(formObject.getLong("userId"));
            	if (operationalCenter!=null) {
            		if (formObject.getString("type").equals("update")) {
                    	if (formObject.getString("code")!=null && formObject.getString("code")!="")
                    		operationalCenter.setCode(formObject.getString("code"));
                		
                    	if (formObject.getString("address")!=null && formObject.getString("address")!="")
                    		operationalCenter.setAddress(formObject.getString("address"));
                		
                    	if (formObject.getString("name")!=null && formObject.getString("name")!="")
                    		operationalCenter.setName(formObject.getString("name"));
                		/*
                    	if (formObject.getString("collectionLimit")!=null && formObject.getString("collectionLimit")!="")
                    		operationalCenter.setCollectionLimit(formObject.getBigDecimal("collectionLimit"));
                		
                    	if (formObject.getString("capacity")!=null && formObject.getString("capacity")!="")
                    		operationalCenter.setCapacity(formObject.getBigDecimal("capacity"));
                		
                    	if (formObject.getString("contactNo1")!=null && formObject.getString("contactNo1")!="")
                    		operationalCenter.setContactNo1(formObject.getString("contactNo1"));
                		
                    	if (formObject.getString("contactNo2")!=null && formObject.getString("contactNo2")!="")
                    		operationalCenter.setContactNo2(formObject.getString("contactNo2"));*/
                		
                    	if (formObject.getString("status")!=null && formObject.getString("status")!="")
                    		operationalCenter.setStatus(RecordStatusEnum.ACTIVE.getDescription());
                		
                    	if (formObject.getString("description")!=null && formObject.getString("description")!="")
                    		operationalCenter.setDescription(formObject.getString("description"));
                    	
                    	operationalCenter.setModifiedUser(userSessionUtil.getUserName());
                    	operationalCenter.setModifiedDate(new Date());
                    	
                    	getCollectionCenterServiceImpl().updateCollectionCenter(operationalCenter);
                        msg = "Record updated successfully.!";
    				} else {
    					getCollectionCenterServiceImpl().deleteCollectionCenter(operationalCenter);
    	                msg = "Record deleted successfully.!";
    				}
        		} else
        			msg = "Collection Center not found.!";
        	} else 
        		msg = "Invalid user session";
		} catch (Exception e) {
			msg = "Error occured. Process did not completed successfully.";
		}
        
        obj.put("msg", msg);
        return obj.toString();
    }
}
