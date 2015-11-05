package com.liferay.docs.guestbook.web;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.docs.guestbook.service.GuestbookLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language"
	},
	service = Portlet.class
)
public class GuestbookPortlet extends MVCPortlet {
	
	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws IOException, PortletException {
		
		GuestbookLocalService guestbookLocalService = getGuestbookLocalService();
		
		int guestbooksCount = guestbookLocalService.getGuestbooksCount();

		//set service bean
		request.setAttribute("GUESTBOOKS_COUNT", guestbooksCount);

		super.render(request, response);
	}
	
	
	public GuestbookLocalService getGuestbookLocalService() {

		return _guestbookLocalService;
	}

	@Reference
	public void setGuestbookLocalService(GuestbookLocalService guestbookLocalService) {

		this._guestbookLocalService = guestbookLocalService;
	}
	
	private GuestbookLocalService _guestbookLocalService;

}