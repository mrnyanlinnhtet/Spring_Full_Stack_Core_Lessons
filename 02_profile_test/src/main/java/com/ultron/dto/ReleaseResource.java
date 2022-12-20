package com.ultron.dto;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.ultron.services.Resources;

@Component
@Profile("release")
public class ReleaseResource implements Resources {

	@Override
	public String data() {
		return "System Using Release Resources";
	}

}
