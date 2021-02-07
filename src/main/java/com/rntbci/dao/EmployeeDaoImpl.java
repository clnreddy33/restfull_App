package com.rntbci.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.rntbci.db.DbConn;
import com.rntbci.model.Employee;

public class EmployeeDaoImpl implements IEmployeeDao {
	MongoCollection<Document> collection=DbConn.getConn();
	ArrayList<Employee> list=null;
	public Integer saveEmployee(Employee e) {


		int count=0;
		try {
			list=new ArrayList<Employee>();

			Employee e1=new Employee();
			e1.setEid(1);
			e1.setEname("Raghu");
			e1.setDesignation("worlker");
			list.add(e1);

			Employee e2=new Employee();
			e2.setEid(2);
			e2.setEname("Raghu1");
			e1.setDesignation("owner");
			list.add(e2);


			Employee e3=new Employee();
			e3.setEid(3);
			e3.setEname("Raghu3");
			e3.setDesignation("worlker2");
			list.add(e3);

		count=	collection.insertOne(list);
		} catch (Exception ex) {
			ex.printStackTrace();

		}
		return count;
	}

	public List<Employee> getAllEmployees() {
		MongoCursor<Document> cur=collection.find().iterator();
		List<Employee> list=null;
		try {
		
			list=new ArrayList<>();
			
				while (cur.hasNext()) {

                    Document doc = cur.next();
                    list = new ArrayList <>(); 

                    System.out.printf("%s: %s%n", list.get(1), list.get(2),list.get(3));
                }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
