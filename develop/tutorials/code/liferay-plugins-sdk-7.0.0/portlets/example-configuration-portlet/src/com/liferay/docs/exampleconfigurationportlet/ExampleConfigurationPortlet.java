package com.liferay.docs.exampleconfigurationportlet;

import java.io.IOException;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import com.liferay.docs.exampleconfigurationportlet.configuration.ExampleConfiguration;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.settings.SettingsException;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.PortletDisplay;
import com.liferay.portal.theme.ThemeDisplay;

import aQute.bnd.annotation.metatype.Configurable;

@Component(
	configurationPid = "com.liferay.docs.exampleconfigurationportlet.configuration.ExampleConfiguration",
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Example Configuration Portlet",
        "javax.portlet.init-param.template-path=/",
        "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ExampleConfigurationPortlet extends MVCPortlet {
	
	public String getDefaultLanguageLabel(Map labels) {
		return (String) labels.get(_configuration.defaultLanguage());
	}
	
	public String getAbc() {
		return _configuration.abc();
	}
	
	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_configuration = Configurable.createConfigurable(
            ExampleConfiguration.class, properties);
	}
	
	@Override
	public void doView(RenderRequest request, RenderResponse response)
		throws PortletException, IOException {

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
		
		ExampleConfiguration configuration = null;
		
		try {
			configuration = portletDisplay.getPortletInstanceConfiguration(
                ExampleConfiguration.class);
		}
		catch (SettingsException se) {
			se.printStackTrace();
		}
		
		String abc = getAbc();
		
        request.setAttribute("ABC", abc);
		
		super.doView(request, response);
	}
	
	private volatile ExampleConfiguration _configuration;

}
