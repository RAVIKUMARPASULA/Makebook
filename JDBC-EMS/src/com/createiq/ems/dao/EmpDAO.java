package com.createiq.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.createiq.ems.model.Employee;
import com.createiq.ems.queries.EmployeeQueries;
import com.createiq.ems.util.ConnectionUtil;

public class EmpDAO {
	public void insert(Employee employee) {
		Connection con= null;
		PreparedStatement ps= null;
		try {
			con=ConnectionUtil.getConnection();
			ps=con.prepareStatement(EmployeeQueries.EMPLOYEES_INSERT_QUERY);
			ps.setInt(1, employee.getEid());
			ps.setString(2, employee.getEname());
			ps.setDouble(3, employee.getEsal());
//			ps.setInt(1, 513);
//			ps.setString(2, "Ashwin");
//			ps.setDouble(3, 15000);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtil.close(ps, con);
			
		}
	}
	public void update(Employee employee) {
		Connection con= null;
		PreparedStatement ps= null;
		try {
			con=ConnectionUtil.getConnection();
			ps=con.prepareStatement(EmployeeQueries.EMPLOYEES_UPDATE_QUERY);
			ps.setString(1, employee.getEname());
			ps.setDouble(2, employee.getEsal());
			ps.setInt(3, employee.getEid());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtil.close(ps, con);
			
		}
	}
	public void delete(int eid) {
		Connection con= null;
		PreparedStatement ps= null;
		try {
			con=ConnectionUtil.getConnection();
			ps=con.prepareStatement(EmployeeQueries.EMPLOYEES_DELETE_QUERY);
			ps.setInt(1, eid);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtil.close(ps, con);
			
		}
	}
	public Employee findById(int eid) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Employee emp=null;
		try {
			con=ConnectionUtil.getConnection();
			ps=con.prepareStatement(EmployeeQueries.EMPLOYEES_FIND_BY_ID_QUERY);
			ps.setInt(1, eid);
			rs= ps.executeQuery();
			if(rs.next()) {
			emp=new Employee();
			emp.setEid(rs.getInt("eid"));
			emp.setEname(rs.getString("ename"));
			emp.setEsal(rs.getDouble("esal"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtil.close(rs, ps, con);
		}
		return emp;
	
		
	}
	public Employee findByEname(String ename) {
		Connection con= null;
		PreparedStatement ps= null;
		ResultSet rs=null;
		Employee emp=null;
		try {
			con=ConnectionUtil.getConnection();
			ps=con.prepareStatement(EmployeeQueries.EMPLOYEES_FIND_BY_NAME_QUERY);
			ps.setString(1, ename);
			rs=ps.executeQuery();
			while(rs.next()) {
				emp=new Employee();
				emp.setEid(rs.getInt("eid"));
				emp.setEname(rs.getString("ename"));
				emp.setEsal(rs.getDouble("esal"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
		
		
	}
	public  List<Employee> findAll(){
		Connection con= null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Employee> employees=null;

		try {
			con=ConnectionUtil.getConnection();
			ps=con.prepareStatement(EmployeeQueries.EMPLOYEES_FINDALL_QUERY);
			rs=ps.executeQuery();
			employees= new ArrayList<Employee>();
			while(rs.next()) {
				Employee emp=new Employee();
				emp.setEid(rs.getInt("eid"));
				emp.setEname(rs.getString("ename"));
				emp.setEsal(rs.getDouble("esal"));
				employees.add(emp);
			}
		}
			catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtil.close(rs, ps, con);
		}
		return employees;
		
	}
}
