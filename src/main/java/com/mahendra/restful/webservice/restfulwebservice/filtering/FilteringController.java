package com.mahendra.restful.webservice.restfulwebservice.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping("/filtering")
	public MappingJacksonValue retrieveSomeBean() {
		SomeBean someBean = new SomeBean("Value 1", "Value 2", "Value3");
		MappingJacksonValue mappingJacksonValue = new  MappingJacksonValue(someBean);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue; 
	}
	
	@GetMapping("/filtering-list")
	public MappingJacksonValue retrieveAllBean() {
		List<SomeBean> list =  Arrays.asList(new SomeBean("Value 1", "Value 2", "Value3"),new SomeBean("Value 11", "Value 22", "Value 33"));
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
		SimpleBeanPropertyFilter filter  = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue; 
	}
}
