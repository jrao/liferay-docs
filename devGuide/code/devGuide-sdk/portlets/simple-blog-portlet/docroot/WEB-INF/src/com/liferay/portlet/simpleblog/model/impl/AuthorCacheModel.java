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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.liferay.portlet.simpleblog.model.Author;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Author in entity cache.
 *
 * @author jbloggs
 * @see Author
 * @generated
 */
public class AuthorCacheModel implements CacheModel<Author>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{authorId=");
		sb.append(authorId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	public Author toEntityModel() {
		AuthorImpl authorImpl = new AuthorImpl();

		authorImpl.setAuthorId(authorId);
		authorImpl.setCompanyId(companyId);
		authorImpl.setGroupId(groupId);
		authorImpl.setUserId(userId);

		if (userName == null) {
			authorImpl.setUserName(StringPool.BLANK);
		}
		else {
			authorImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			authorImpl.setCreateDate(null);
		}
		else {
			authorImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			authorImpl.setModifiedDate(null);
		}
		else {
			authorImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			authorImpl.setName(StringPool.BLANK);
		}
		else {
			authorImpl.setName(name);
		}

		authorImpl.resetOriginalValues();

		return authorImpl;
	}

	public long authorId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
}