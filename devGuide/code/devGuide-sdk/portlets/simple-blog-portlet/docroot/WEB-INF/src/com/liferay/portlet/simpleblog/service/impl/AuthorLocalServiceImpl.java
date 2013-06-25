/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package com.liferay.portlet.simpleblog.service.impl;

import java.util.Date;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.simpleblog.model.Author;
import com.liferay.portlet.simpleblog.service.AuthorLocalServiceUtil;
import com.liferay.portlet.simpleblog.service.base.AuthorLocalServiceBaseImpl;

/**
 * The implementation of the author local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.portlet.simpleblog.service.AuthorLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jbloggs
 * @see com.liferay.portlet.simpleblog.service.base.AuthorLocalServiceBaseImpl
 * @see com.liferay.portlet.simpleblog.service.AuthorLocalServiceUtil
 */
public class AuthorLocalServiceImpl extends AuthorLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.portlet.simpleblog.service.AuthorLocalServiceUtil} to access the author local service.
	 */
	
	public Author addAuthor(String name, ServiceContext serviceContext) {
		
		long authorId = 0;
		
		try {
			authorId = counterLocalService.increment(Author.class.getName());
		} catch (SystemException se) {
			se.printStackTrace();
		}
		
		Author author = super.createAuthor(authorId);
		
		author.setName(name);
		
		long companyId = serviceContext.getCompanyId();
		
		author.setAuthorId(authorId);
		
		long groupId = serviceContext.getScopeGroupId();
		
		author.setGroupId(groupId);
		
		long userId = 0;
		
		try {
			userId = serviceContext.getGuestOrUserId();
		} catch (PortalException pe) {
			pe.printStackTrace();
		} catch (SystemException se) {
			se.printStackTrace();
		}
		
		author.setUserId(userId);
		
		Date now = new Date();
		
		author.setCreateDate(now);
		
		author.setModifiedDate(now);
		
		try {
			AuthorLocalServiceUtil.addAuthor(author);
		} catch (SystemException se) {
			se.printStackTrace();
		}
		
		return author;
	}
	
	public Author updateAuthor(long authorId, String name) {
		
		Author author = null;
		try {
			author = super.fetchAuthor(authorId);
		} catch (SystemException se) {
			se.printStackTrace();
		}
		
		author.setName(name);
		
		try {
			return AuthorLocalServiceUtil.updateAuthor(author);
		} catch (SystemException se) {
			se.printStackTrace();
		}
		
		return author;
	}
	
	public Author deleteAuthor(long authorId) {
		
		Author author = null;
		
		try {
			author = super.fetchAuthor(authorId);
		} catch (SystemException se) {
			se.printStackTrace();
		}
		
		try {
			return super.deleteAuthor(author);
		} catch (SystemException se) {
			se.printStackTrace();
		}
		
		return author;
	}
	
}