package com.esoft.coursework.controller;

import java.text.DecimalFormat;
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

import com.esoft.coursework.domain.OperationalCenter;
import com.esoft.coursework.domain.Customer;
import com.esoft.coursework.serviceimpl.CustomerServiceImpl;
import com.esoft.coursework.util.UserSessionUtil;

/**
 * @author Udara Wikum
 * @since 19/02/2022 4.01PM
 * @version 1.0.0
 * @developde Intellige_idea
 */

@Controller
public class CustomerController {
	@Autowired
	private CustomerServiceImpl customerServiceImpl;

	public CustomerServiceImpl getCustomerServiceImpl() {
		return customerServiceImpl;
	}
	public void setCustomerServiceImpl(CustomerServiceImpl customerServiceImpl) {
		this.customerServiceImpl = customerServiceImpl;
	}

	private String recordCannotBeBlank = "Record cannot be blank";
	
	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	@ResponseBody
    public String allCustomer() {
        JSONObject obj = new JSONObject();
        
        List<Customer> farmerList = getCustomerServiceImpl().getAll();
        obj.put("customerList", farmerList);
        
        return obj.toString();
    }
	
	@SuppressWarnings("unused")
	@RequestMapping(value = "/customer/id/{id}", method = RequestMethod.GET)
	@ResponseBody
    public String CustomerById(@PathVariable(value = "id", required = true) Long id) {
        JSONObject obj = new JSONObject();
        
        Optional<Customer> Customer = getCustomerServiceImpl().getById(id);
        if (Customer.isPresent()) {
        	OperationalCenter operationalCenter = new OperationalCenter();
        	obj.put("customerId", Customer.get().getId()); 
			obj.put("customerName", Customer.get().getName());
			obj.put("customerCode", Customer.get().getCode());
			
        }
        return obj.toString();
    }
	
	@RequestMapping(value = "/customer", method = RequestMethod.POST)
	@ResponseBody
    public String createCustomer(@RequestBody String formBody, HttpServletRequest httpServletRequest) {
        String msg = "";
        JSONObject obj = new JSONObject();
        obj.put("error", "N");
        
        JSONObject paramObject = new JSONObject(formBody);
        JSONObject formObject = (JSONObject) paramObject.get("params");
        DecimalFormat df = new DecimalFormat("0000000000");
        
        JSONObject errorObj = validateInputs(formObject);
        if (errorObj.getString("error").equals("Y")) {
            return errorObj.toString();
        }
        
        try {
        	UserSessionUtil userSessionUtil = UserSessionUtil.getUserSessionUtil(httpServletRequest);
        	if (userSessionUtil!=null) {
        		boolean status = getCustomerServiceImpl().isExistByNicBr(formObject.getString("nicbr"));
            	if (!status) {
            		Customer customer = new Customer();
                    
            		customer.setCode(df.format(getCustomerServiceImpl().getSequenceNo()));
            		
            		customer.setNicNo(formObject.getString("nicbr"));
            		customer.setName(formObject.getString("name"));
            		customer.setContactNo(formObject.getString("contactNo"));
            		customer.setAddress(formObject.getString("address"));
            		customer.setStatus(formObject.getString("status"));
                	customer.setCreatedUser(userSessionUtil.getUserName());
                	customer.setCreatedDate(new Date());
                	
                	getCustomerServiceImpl().save(customer);
                    msg = "Record created successfully.!";
        		} else
        			msg = "Nic/br already exists.!";
        	} else 
        		msg = "Invalid user session";
		} catch (Exception e) {
			msg = "Error occured. Process did not completed successfully.";
		}
        
        obj.put("msg", msg);
        return obj.toString();
    }
	
	private JSONObject validateInputs(JSONObject inputObj) {
		JSONObject object = new JSONObject();
		object.put("error", "N");
		
		if (inputObj.isNull("nicbr")) {
			object.put("nicbr", recordCannotBeBlank);
			object.put("error", "Y");
		}
		
		if (inputObj.isNull("name")) {
			object.put("nicbr", recordCannotBeBlank);
			object.put("error", "Y");
		}
		
		if (inputObj.isNull("contactNo")) {
			object.put("nicbr", recordCannotBeBlank);
			object.put("error", "Y");
		}
		
		if (inputObj.isNull("address")) {
			object.put("nicbr", recordCannotBeBlank);
			object.put("error", "Y");
		}
		
		if (inputObj.isNull("status")) {
			object.put("nicbr", recordCannotBeBlank);
			object.put("error", "Y");
		}
		return object;
	}
	
	@RequestMapping(value = "/customer", method = RequestMethod.PUT)
	@ResponseBody
    public String updateOrDeleteCustomer(@RequestBody String formBody, HttpServletRequest httpServletRequest) {
        String msg = "";
        JSONObject obj = new JSONObject();
        JSONObject paramObject = new JSONObject(formBody);
        JSONObject formObject = (JSONObject) paramObject.get("params");
        
        try {
        	UserSessionUtil userSessionUtil = UserSessionUtil.getUserSessionUtil(httpServletRequest);
        	if (userSessionUtil!=null) {
        		Optional<Customer> optFarmer = getCustomerServiceImpl().getById(formObject.getLong("id"));
            	if (optFarmer!=null) {
            		Customer customer = optFarmer.get();
            		if (formObject.getString("type").equals("update")) {
                    	if (formObject.getString("name")!=null && formObject.getString("name")!="") 
                    		customer.setName(formObject.getString("name"));
                		
                    	if (formObject.getString("contactNo")!=null && formObject.getString("contactNo")!="") 
                    		customer.setContactNo(formObject.getString("contactNo"));
                		
                    	if (formObject.getString("address")!=null && formObject.getString("address")!="") 
                    		customer.setAddress(formObject.getString("address"));
                		
                    	if (formObject.getString("status")!=null && formObject.getString("status")!="") 
                    		customer.setStatus(formObject.getString("status"));
                    	
                    	customer.setModifiedUser(userSessionUtil.getUserName());
                    	customer.setModifiedDate(new Date());
                    	
                    	getCustomerServiceImpl().update(customer);
                        msg = "Record updated successfully.!";
    				} else {
    					getCustomerServiceImpl().delete(customer);
    	                msg = "Record deleted successfully.!";
    				}
        		} else
        			msg = "Customer not found.!";
        	} else 
        		msg = "Invalid user session";
		} catch (Exception e) {
			msg = "Error occured. Process did not completed successfully.";
		}
        
        obj.put("msg", msg);
        return obj.toString();
    }
}
