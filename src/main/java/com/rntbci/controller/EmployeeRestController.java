package com.rntbci.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.rntbci.model.Employee;
import com.rntbci.service.IEmployeeService;

@Path("/employee")
public class EmployeeRestController {
	@Inject
	private IEmployeeService service;
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response saveEmployee(Employee employee) {
		Response resp=null;

		try {
			//call service layer to save
			Integer count=service.saveEmployee(employee);
			if(count>0) {
				resp = Response.status(Status.CREATED) //201 -success
						.entity("employee Saved!")
						.build();
			}else {
				resp = Response.status(Status.BAD_REQUEST) //400-wrong input
						.entity("employee not saved!")
						.build();
			}
		} catch (Exception e) {
			resp = Response.status(Status.INTERNAL_SERVER_ERROR)//500-exception
					.entity("employee not saved!")
					.build();
			e.printStackTrace();
		}

		return resp;
	}

	//2. Fetching data from Database
	@GET
	@Produces("application/json")
	public Response getAllEmployees() {
		Response resp=null;
		try {
			List<Employee> list=service.getAllEmployees();
					resp =  Response
					.status(Status.OK)
					.entity(list)
					.build();

		} catch (Exception e) {
			resp = Response.status(Status.INTERNAL_SERVER_ERROR)//500-exception
					.entity("Unable to Fetch Data!!")
					.build();

			e.printStackTrace();
		}
		return resp;
	}

}
