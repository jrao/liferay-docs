/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.docs.guestbook.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link GuestbookService}.
 *
 * @author Jesse Rao
 * @see GuestbookService
 * @generated
 */
@ProviderType
public class GuestbookServiceWrapper implements GuestbookService,
	ServiceWrapper<GuestbookService> {
	public GuestbookServiceWrapper(GuestbookService guestbookService) {
		_guestbookService = guestbookService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _guestbookService.getOSGiServiceIdentifier();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	@Deprecated
	public GuestbookService getWrappedGuestbookService() {
		return _guestbookService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	@Deprecated
	public void setWrappedGuestbookService(GuestbookService guestbookService) {
		_guestbookService = guestbookService;
	}

	@Override
	public GuestbookService getWrappedService() {
		return _guestbookService;
	}

	@Override
	public void setWrappedService(GuestbookService guestbookService) {
		_guestbookService = guestbookService;
	}

	private GuestbookService _guestbookService;
}