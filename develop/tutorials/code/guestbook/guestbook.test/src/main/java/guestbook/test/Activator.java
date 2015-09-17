package guestbook.test;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.liferay.docs.guestbook.service.GuestbookLocalServiceUtil;

public class Activator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		int guestbooksCount = GuestbookLocalServiceUtil.getGuestbooksCount();
		System.out.println("Guestbooks Count: " + guestbooksCount);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		
	}

}
