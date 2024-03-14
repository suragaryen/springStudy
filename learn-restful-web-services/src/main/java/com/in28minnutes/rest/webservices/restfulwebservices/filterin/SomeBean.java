package com.in28minnutes.rest.webservices.restfulwebservices.filterin;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonIgnoreProperties({"field1","field2"})
@JsonFilter("SomeBeanFilter")
public class SomeBean {
	
	private String field;
	//@JsonIgnore
	private String field2;
	private String field3;
	
	public String getField() {
		return field;
	}
	public String getField2() {
		return field2;
	}
	public String getField3() {
		return field3;
	}
	
	
	public SomeBean(String field, String field2, String field3) {
		super();
		this.field = field;
		this.field2 = field2;
		this.field3 = field3;
	}
	
	@Override
	public String toString() {
		return "SomeBean [field=" + field + ", field2=" + field2 + ", field3=" + field3 + "]";
	}


}
