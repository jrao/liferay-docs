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

package com.liferay.portlet.simpleblog.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.portlet.simpleblog.service.http.PostServiceSoap}.
 *
 * @author    jbloggs
 * @see       com.liferay.portlet.simpleblog.service.http.PostServiceSoap
 * @generated
 */
public class PostSoap implements Serializable {
	public static PostSoap toSoapModel(Post model) {
		PostSoap soapModel = new PostSoap();

		soapModel.setPostId(model.getPostId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTitle(model.getTitle());
		soapModel.setContent(model.getContent());
		soapModel.setAuthorId(model.getAuthorId());

		return soapModel;
	}

	public static PostSoap[] toSoapModels(Post[] models) {
		PostSoap[] soapModels = new PostSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PostSoap[][] toSoapModels(Post[][] models) {
		PostSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PostSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PostSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PostSoap[] toSoapModels(List<Post> models) {
		List<PostSoap> soapModels = new ArrayList<PostSoap>(models.size());

		for (Post model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PostSoap[soapModels.size()]);
	}

	public PostSoap() {
	}

	public long getPrimaryKey() {
		return _postId;
	}

	public void setPrimaryKey(long pk) {
		setPostId(pk);
	}

	public long getPostId() {
		return _postId;
	}

	public void setPostId(long postId) {
		_postId = postId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	public long getAuthorId() {
		return _authorId;
	}

	public void setAuthorId(long authorId) {
		_authorId = authorId;
	}

	private long _postId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _title;
	private String _content;
	private long _authorId;
}