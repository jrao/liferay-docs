package com.liferay.docs.exampleconfigurationportlet.configuration;

import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(id = "com.liferay.docs.exampleconfigurationportlet.configuration.ExampleConfiguration")
public interface ExampleConfiguration {
	
	@Meta.AD(deflt = "abcd", required = true)
	public String abc();

}
