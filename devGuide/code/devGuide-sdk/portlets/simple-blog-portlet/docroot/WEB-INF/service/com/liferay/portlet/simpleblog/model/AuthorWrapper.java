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

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Author}.
 * </p>
 *
 * @author    jbloggs
 * @see       Author
 * @generated
 */
public class AuthorWrapper implements Author, ModelWrapper<Author> {
	public AuthorWrapper(Author author) {
		_author = author;
	}

	public Class<?> getModelClass() {
		return Author.class;
	}

	public String getModelClassName() {
		return Author.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("authorId", getAuthorId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long authorId = (Long)attributes.get("authorId");

		if (authorId != null) {
			setAuthorId(authorId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	/**
	* Returns the primary key of this author.
	*
	* @return the primary key of this author
	*/
	public long getPrimaryKey() {
		return _author.getPrimaryKey();
	}

	/**
	* Sets the primary key of this author.
	*
	* @param primaryKey the primary key of this author
	*/
	public void setPrimaryKey(long primaryKey) {
		_author.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the author ID of this author.
	*
	* @return the author ID of this author
	*/
	public long getAuthorId() {
		return _author.getAuthorId();
	}

	/**
	* Sets the author ID of this author.
	*
	* @param authorId the author ID of this author
	*/
	public void setAuthorId(long authorId) {
		_author.setAuthorId(authorId);
	}

	/**
	* Returns the company ID of this author.
	*
	* @return the company ID of this author
	*/
	public long getCompanyId() {
		return _author.getCompanyId();
	}

	/**
	* Sets the company ID of this author.
	*
	* @param companyId the company ID of this author
	*/
	public void setCompanyId(long companyId) {
		_author.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this author.
	*
	* @return the group ID of this author
	*/
	public long getGroupId() {
		return _author.getGroupId();
	}

	/**
	* Sets the group ID of this author.
	*
	* @param groupId the group ID of this author
	*/
	public void setGroupId(long groupId) {
		_author.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this author.
	*
	* @return the user ID of this author
	*/
	public long getUserId() {
		return _author.getUserId();
	}

	/**
	* Sets the user ID of this author.
	*
	* @param userId the user ID of this author
	*/
	public void setUserId(long userId) {
		_author.setUserId(userId);
	}

	/**
	* Returns the user uuid of this author.
	*
	* @return the user uuid of this author
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _author.getUserUuid();
	}

	/**
	* Sets the user uuid of this author.
	*
	* @param userUuid the user uuid of this author
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_author.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this author.
	*
	* @return the user name of this author
	*/
	public java.lang.String getUserName() {
		return _author.getUserName();
	}

	/**
	* Sets the user name of this author.
	*
	* @param userName the user name of this author
	*/
	public void setUserName(java.lang.String userName) {
		_author.setUserName(userName);
	}

	/**
	* Returns the create date of this author.
	*
	* @return the create date of this author
	*/
	public java.util.Date getCreateDate() {
		return _author.getCreateDate();
	}

	/**
	* Sets the create date of this author.
	*
	* @param createDate the create date of this author
	*/
	public void setCreateDate(java.util.Date createDate) {
		_author.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this author.
	*
	* @return the modified date of this author
	*/
	public java.util.Date getModifiedDate() {
		return _author.getModifiedDate();
	}

	/**
	* Sets the modified date of this author.
	*
	* @param modifiedDate the modified date of this author
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_author.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this author.
	*
	* @return the name of this author
	*/
	public java.lang.String getName() {
		return _author.getName();
	}

	/**
	* Sets the name of this author.
	*
	* @param name the name of this author
	*/
	public void setName(java.lang.String name) {
		_author.setName(name);
	}

	public boolean isNew() {
		return _author.isNew();
	}

	public void setNew(boolean n) {
		_author.setNew(n);
	}

	public boolean isCachedModel() {
		return _author.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_author.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _author.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _author.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_author.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _author.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_author.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AuthorWrapper((Author)_author.clone());
	}

	public int compareTo(com.liferay.portlet.simpleblog.model.Author author) {
		return _author.compareTo(author);
	}

	@Override
	public int hashCode() {
		return _author.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.liferay.portlet.simpleblog.model.Author> toCacheModel() {
		return _author.toCacheModel();
	}

	public com.liferay.portlet.simpleblog.model.Author toEscapedModel() {
		return new AuthorWrapper(_author.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _author.toString();
	}

	public java.lang.String toXmlString() {
		return _author.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_author.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Author getWrappedAuthor() {
		return _author;
	}

	public Author getWrappedModel() {
		return _author;
	}

	public void resetOriginalValues() {
		_author.resetOriginalValues();
	}

	private Author _author;
}