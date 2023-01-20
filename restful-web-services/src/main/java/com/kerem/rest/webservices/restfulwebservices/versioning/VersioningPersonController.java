package com.kerem.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

	@GetMapping(path = "v1/person")
	public PersonV1 getPersonV1() {
		return new PersonV1("Bob Marley");
	}
	
	@GetMapping(path = "v2/person")
	public PersonV2 getPersonV2() {
		return new PersonV2("Bob", "Marley");
	}
	
	@GetMapping(path = "/person", params = "version=1")
	public PersonV1 getPersonV1RequestParams() {
		return new PersonV1("Bob Marley");
	}
	
	@GetMapping(path = "/person", params = "version=2")
	public PersonV2 getPersonV2RequestParams() {
		return new PersonV2("Bob","Marley");
	}
	
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
	public PersonV1 getPersonV1Header() {
		return new PersonV1("Bob Marley");
	}
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
	public PersonV2 getPersonV2Header() {
		return new PersonV2("Bob","Marley");
	}
}
