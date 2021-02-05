package com.rntbci.conig;
 import javax.ws.rs.ApplicationPath;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

import com.rntbci.dao.EmployeeDaoImpl;
import com.rntbci.dao.IEmployeeDao;
import com.rntbci.service.EmployeeServiceImpl;
import com.rntbci.service.IEmployeeService;


@ApplicationPath("/rest")
public class AppConfig extends ResourceConfig {

	public AppConfig() {
		this.packages("com.rntbci");
		this.register(new AbstractBinder() {
			
			@Override
			protected void configure() {
				bind(EmployeeDaoImpl.class).to(IEmployeeDao.class);
				bind(EmployeeServiceImpl.class).to(IEmployeeService.class);
			}
		});
	}
}
