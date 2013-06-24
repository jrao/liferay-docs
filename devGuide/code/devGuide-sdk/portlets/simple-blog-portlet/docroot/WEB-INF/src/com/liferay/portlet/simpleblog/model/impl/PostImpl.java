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

package com.liferay.portlet.simpleblog.model.impl;

import com.liferay.portlet.simpleblog.model.Author;
import com.liferay.portlet.simpleblog.service.AuthorLocalServiceUtil;

/**
 * The extended model implementation for the Post service. Represents a row in
 * the &quot;SimpleBlog_Post&quot; database table, with each column mapped to a
 * property of this class.
 * 
 * <p>
 * Helper methods and all application logic should be put in this class.
 * Whenever methods are added, rerun ServiceBuilder to copy their definitions
 * into the {@link com.liferay.portlet.simpleblog.model.Post} interface.
 * </p>
 * 
 * @author jbloggs
 */
public class PostImpl extends PostBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this class directly. All methods that expect a post model
	 * instance should use the {@link com.liferay.portlet.simpleblog.model.Post}
	 * interface instead.
	 */
	public PostImpl() {

	}

	public Author getAuthor() {

		try {
			return AuthorLocalServiceUtil.getAuthor(getAuthorId());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}