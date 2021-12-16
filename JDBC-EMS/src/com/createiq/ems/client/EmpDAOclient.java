package com.createiq.ems.client;

import java.util.List;

import com.createiq.ems.dao.EmpDAO;
import com.createiq.ems.model.Employee;

public class EmpDAOclient {
public static void main(String[] args) {
	EmpDAO ed = new EmpDAO();
	Employee emp= new Employee();
	emp.setEid(514);
	emp.setEname("Rahul");
	emp.setEsal(18000);
	ed.insert(emp);
//	List<Employee> employees= ed.findAll();
//	for (Employee employee : employees) {
//		System.out.println(employee);
//	}
	System.out.println("success inserted : "+emp);
	
	}
}
