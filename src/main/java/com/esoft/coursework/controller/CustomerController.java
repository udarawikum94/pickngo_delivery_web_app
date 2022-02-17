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

import com.esoft.coursework.domain.CollectionCenter;
import com.esoft.coursework.domain.Customer;
import com.esoft.coursework.serviceimpl.CustomerServiceImpl;
import com.esoft.coursework.util.UserSessionUtil;

/**
 * @author Udara Wikum
 * @since 22/11/2021 6.11PM
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
        	CollectionCenter collectionCenter = new CollectionCenter();
        	obj.put("farmerId", Customer.get().getId()); 
			obj.put("farmerName", Customer.get().getFullName());
			obj.put("farmerCode", Customer.get().getCode());
			
        }
        return obj.toString();
    }
	
	@RequestMapping(value = "/customer", method = RequestMethod.POST)
	@ResponseBody
    public String createCustomer(@RequestBody String formBody, HttpServletRequest httpServletRequest) {
        String msg = "";
        JSONObject obj = new JSONObject();
        JSONObject paramObject = new JSONObject(formBody);
        JSONObject formObject = (JSONObject) paramObject.get("params");
        DecimalFormat df = new DecimalFormat("0000000000");
        try {
        	UserSessionUtil userSessionUtil = UserSessionUtil.getUserSessionUtil(httpServletRequest);
        	if (userSessionUtil!=null) {
        		boolean status = getCustomerServiceImpl().isExistByNicBr(formObject.getString("nicbr"));
            	if (!status) {
            		Customer customer = new Customer();
                    
            		customer.setCode(df.format(getCustomerServiceImpl().getSequenceNo()));
            		customer.setNicNo(formObject.getString("nicbr"));
            		customer.setFullName(formObject.getString("name"));
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
                    		customer.setFullName(formObject.getString("name"));
                		
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
