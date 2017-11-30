package com.main.controller;
  
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.main.data.EmpDAO;
import com.main.model.Employee;  

@RestController  
public class EmpController {  
   
	@Autowired
    EmpDAO dao;  

    public EmpController(EmpDAO dao) {
		this.dao = dao;
	}


	@RequestMapping(value="/viewemp/{pageid}")  
    public ModelAndView edit(@PathVariable int pageid){  
        int total=5;  
        if(pageid==1){}  
        else{  
            pageid=(pageid-1)*total+1;  
        }  
        List<Employee> list=dao.getEmployeesByPage(pageid,total);  
        
        return new ModelAndView("viewemp","list",list);  
    }  
	

	@RequestMapping(value="/viewemp/{pageid}", method =  RequestMethod.POST)
    public String edit1(@PathVariable int pageid){  
        int total=5;  
        if(pageid==1){}  
        else{  
            pageid=(pageid-1)*total+1;  
        }  
        List<Employee> list=dao.getEmployeesByPage(pageid,total);  
          
        return list.toString();  
    }  
  
}  