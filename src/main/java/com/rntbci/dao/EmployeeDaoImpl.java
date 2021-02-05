package com.rntbci.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rntbci.db.DbConn;
import com.rntbci.model.Employee;

public class EmployeeDaoImpl implements IEmployeeDao {

	public Integer saveEmployee(Employee e) {
		// TODO Auto-generated method stub
		String sql=" INSERT INTO EMPLOYEES VALUES(?,?,?,?,?) ";
		int count=0;
		try {
			PreparedStatement pstmt=DbConn.getConn().prepareStatement(sql);

			pstmt.setInt(1, e.getEid());
			pstmt.setString(2, e.getEname());
			pstmt.setString(3, e.getDesignation());
		

			count=pstmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();

	}
		return count;
	}

	public List<Employee> getAllEmployees() {
		String sql=" SELECT * FROM EMPLOYEES ";
		List<Employee> list=null;
		try {
			PreparedStatement pstmt=DbConn.getConn().prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			list=new ArrayList<>();
			while(rs.next()) {
				list.add(new Employee(
						rs.getInt("eid"), 
						rs.getString("ename"), 
						rs.getString("edesignation"))
						);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
