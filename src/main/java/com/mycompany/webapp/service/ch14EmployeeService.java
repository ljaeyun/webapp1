package com.mycompany.webapp.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.ch14EmployeeDao;
import com.mycompany.webapp.dto.ch14Employee;

@Service
public class ch14EmployeeService {
	private static Logger logger =
			LoggerFactory.getLogger(ch14EmployeeService.class);

	@Resource
	private ch14EmployeeDao employeeDao;
	
	public ch14Employee getEmployee(int employee_id) {
		
		ch14Employee  emp = employeeDao.selectByPk(employee_id);
		/*logger.info("employee_id " + emp.getEmployee_id());
		logger.info("first_name " + emp.getFirst_name());
		logger.info("last_name " + emp.getLast_name()) ;*/
		return emp;
	}
		
}
