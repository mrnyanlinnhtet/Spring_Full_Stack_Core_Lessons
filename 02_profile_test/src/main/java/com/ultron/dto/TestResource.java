package com.ultron.dto;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.ultron.services.Resources;

@Component
@Profile("test")
public class TestResource implements Resources {

	@Override
	public String data() {
		return "System Using TestResourse";
	}

}
