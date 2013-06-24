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

package com.liferay.portlet.simpleblog.service.persistence;

/**
 * @author jbloggs
 */
public interface PostFinder {
	public java.util.List<com.liferay.portlet.simpleblog.model.Post> findByTitleContentAuthor(
		java.lang.String title, java.lang.String content,
		java.lang.String author, int begin, int end);
}