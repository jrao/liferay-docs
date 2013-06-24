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

import com.liferay.portlet.simpleblog.model.Post;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Post in entity cache.
 *
 * @author jbloggs
 * @see Post
 * @generated
 */
public class PostCacheModel implements CacheModel<Post>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{postId=");
		sb.append(postId);
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
		sb.append(", title=");
		sb.append(title);
		sb.append(", content=");
		sb.append(content);
		sb.append(", authorId=");
		sb.append(authorId);
		sb.append("}");

		return sb.toString();
	}

	public Post toEntityModel() {
		PostImpl postImpl = new PostImpl();

		postImpl.setPostId(postId);
		postImpl.setCompanyId(companyId);
		postImpl.setGroupId(groupId);
		postImpl.setUserId(userId);

		if (userName == null) {
			postImpl.setUserName(StringPool.BLANK);
		}
		else {
			postImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			postImpl.setCreateDate(null);
		}
		else {
			postImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			postImpl.setModifiedDate(null);
		}
		else {
			postImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (title == null) {
			postImpl.setTitle(StringPool.BLANK);
		}
		else {
			postImpl.setTitle(title);
		}

		if (content == null) {
			postImpl.setContent(StringPool.BLANK);
		}
		else {
			postImpl.setContent(content);
		}

		postImpl.setAuthorId(authorId);

		postImpl.resetOriginalValues();

		return postImpl;
	}

	public long postId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String title;
	public String content;
	public long authorId;
}