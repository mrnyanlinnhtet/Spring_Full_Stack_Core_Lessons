package com.ultron.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ultron.annotation.AppServices;
import com.ultron.annotation.AppServices.Type;

@Component
public class ClientService {

	
	private AppService service;

	@Autowired
	public void setService(@AppServices(Type.TWO)AppService service) {
		this.service = service;
	}

	public AppService getService() {
		return service;
	}

}
