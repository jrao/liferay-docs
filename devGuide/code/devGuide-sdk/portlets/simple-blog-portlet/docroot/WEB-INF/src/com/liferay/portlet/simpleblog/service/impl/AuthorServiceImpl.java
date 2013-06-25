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

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.simpleblog.model.Author;
import com.liferay.portlet.simpleblog.service.AuthorLocalServiceUtil;
import com.liferay.portlet.simpleblog.service.base.AuthorServiceBaseImpl;

/**
 * The implementation of the author remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.portlet.simpleblog.service.AuthorService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author jbloggs
 * @see com.liferay.portlet.simpleblog.service.base.AuthorServiceBaseImpl
 * @see com.liferay.portlet.simpleblog.service.AuthorServiceUtil
 */
public class AuthorServiceImpl extends AuthorServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.portlet.simpleblog.service.AuthorServiceUtil} to access the author remote service.
	 */
	
	public Author addAuthor() {
		
		long authorId = 0;
		
		try {
			authorId = CounterLocalServiceUtil.increment(Author.class.getName());
		} catch (SystemException se) {
			se.printStackTrace();
		}
		
		Author author = AuthorLocalServiceUtil.createAuthor(authorId);
		
		Date now = new Date();
		
		author.setCreateDate(now);
		
		author.setModifiedDate(now);
		
		try {
			return AuthorLocalServiceUtil.addAuthor(author);
		} catch (SystemException se) {
			se.printStackTrace();
		}
		
		return null;
	}
	
	public Author updateAuthor(long authorId, String name) {
		
		Author author = null;
		
		try {
			author = AuthorLocalServiceUtil.fetchAuthor(authorId);
		} catch (SystemException se) {
			se.printStackTrace();
		}
		
		author.setName(name);
		
		Date now = new Date();
		
		author.setModifiedDate(now);
		
		try {
			return AuthorLocalServiceUtil.updateAuthor(author);
		} catch (SystemException se) {
			se.printStackTrace();
		}
		
		return author;
	}
	
	public Author deleteAuthor (long authorId) {
		
		Author author = null;
		
		try {
			author = AuthorLocalServiceUtil.fetchAuthor(authorId);
		} catch (SystemException se) {
			se.printStackTrace();
		}
		
		try {
			return AuthorLocalServiceUtil.deleteAuthor(author);
		} catch (SystemException se) {
			se.printStackTrace();
		}
		
		return author;
	}
	
}