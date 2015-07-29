package com.liferay.docs.exampleconfigurationportlet.configuration;

import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(id = "com.liferay.docs.exampleconfigurationportlet.configuration.ExampleConfiguration")
public interface ExampleConfiguration {
	
	@Meta.AD(deflt = "es")
	public String defaultLanguage();
	
	@Meta.AD(
		deflt = "en|es|pt",
		required = true
    )
	public String[] validLanguages();
	
	@Meta.AD(required = false)
	public int itemsPerPage();
	
	@Meta.AD(
        deflt = "abcd",
		required = true
    )
	public String abc();

}
