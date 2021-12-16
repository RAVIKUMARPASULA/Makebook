package com.createiq.ems.queries;

public interface EmployeeQueries {
	String EMPLOYEES_INSERT_QUERY ="INSERT INTO EMPLOYEES(EID, ENAME,ESAL)VALUES(?,?,?)";
	String EMPLOYEES_UPDATE_QUERY ="UPDATE EMPLOYEES SET ENAME=?, ESAL=? WHERE EID=?";
	String EMPLOYEES_DELETE_QUERY ="DELETE FROM EMPLOYEES WHERE EID=?";
	String EMPLOYEES_FIND_BY_ID_QUERY="SELECT * FROM EMPLOYEES WHERE EID=?";
	String EMPLOYEES_FIND_BY_NAME_QUERY="SELECT * FROM EMPLOYEES WHERE ENAME=?";
	String EMPLOYEES_FINDALL_QUERY ="SELECT * FROM EMPLOYEES";
	
}
	