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
 * This class is a wrapper for {@link Post}.
 * </p>
 *
 * @author    jbloggs
 * @see       Post
 * @generated
 */
public class PostWrapper implements Post, ModelWrapper<Post> {
	public PostWrapper(Post post) {
		_post = post;
	}

	public Class<?> getModelClass() {
		return Post.class;
	}

	public String getModelClassName() {
		return Post.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("postId", getPostId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("title", getTitle());
		attributes.put("content", getContent());
		attributes.put("authorId", getAuthorId());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long postId = (Long)attributes.get("postId");

		if (postId != null) {
			setPostId(postId);
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

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		Long authorId = (Long)attributes.get("authorId");

		if (authorId != null) {
			setAuthorId(authorId);
		}
	}

	/**
	* Returns the primary key of this post.
	*
	* @return the primary key of this post
	*/
	public long getPrimaryKey() {
		return _post.getPrimaryKey();
	}

	/**
	* Sets the primary key of this post.
	*
	* @param primaryKey the primary key of this post
	*/
	public void setPrimaryKey(long primaryKey) {
		_post.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the post ID of this post.
	*
	* @return the post ID of this post
	*/
	public long getPostId() {
		return _post.getPostId();
	}

	/**
	* Sets the post ID of this post.
	*
	* @param postId the post ID of this post
	*/
	public void setPostId(long postId) {
		_post.setPostId(postId);
	}

	/**
	* Returns the company ID of this post.
	*
	* @return the company ID of this post
	*/
	public long getCompanyId() {
		return _post.getCompanyId();
	}

	/**
	* Sets the company ID of this post.
	*
	* @param companyId the company ID of this post
	*/
	public void setCompanyId(long companyId) {
		_post.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this post.
	*
	* @return the group ID of this post
	*/
	public long getGroupId() {
		return _post.getGroupId();
	}

	/**
	* Sets the group ID of this post.
	*
	* @param groupId the group ID of this post
	*/
	public void setGroupId(long groupId) {
		_post.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this post.
	*
	* @return the user ID of this post
	*/
	public long getUserId() {
		return _post.getUserId();
	}

	/**
	* Sets the user ID of this post.
	*
	* @param userId the user ID of this post
	*/
	public void setUserId(long userId) {
		_post.setUserId(userId);
	}

	/**
	* Returns the user uuid of this post.
	*
	* @return the user uuid of this post
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _post.getUserUuid();
	}

	/**
	* Sets the user uuid of this post.
	*
	* @param userUuid the user uuid of this post
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_post.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this post.
	*
	* @return the user name of this post
	*/
	public java.lang.String getUserName() {
		return _post.getUserName();
	}

	/**
	* Sets the user name of this post.
	*
	* @param userName the user name of this post
	*/
	public void setUserName(java.lang.String userName) {
		_post.setUserName(userName);
	}

	/**
	* Returns the create date of this post.
	*
	* @return the create date of this post
	*/
	public java.util.Date getCreateDate() {
		return _post.getCreateDate();
	}

	/**
	* Sets the create date of this post.
	*
	* @param createDate the create date of this post
	*/
	public void setCreateDate(java.util.Date createDate) {
		_post.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this post.
	*
	* @return the modified date of this post
	*/
	public java.util.Date getModifiedDate() {
		return _post.getModifiedDate();
	}

	/**
	* Sets the modified date of this post.
	*
	* @param modifiedDate the modified date of this post
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_post.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the title of this post.
	*
	* @return the title of this post
	*/
	public java.lang.String getTitle() {
		return _post.getTitle();
	}

	/**
	* Sets the title of this post.
	*
	* @param title the title of this post
	*/
	public void setTitle(java.lang.String title) {
		_post.setTitle(title);
	}

	/**
	* Returns the content of this post.
	*
	* @return the content of this post
	*/
	public java.lang.String getContent() {
		return _post.getContent();
	}

	/**
	* Sets the content of this post.
	*
	* @param content the content of this post
	*/
	public void setContent(java.lang.String content) {
		_post.setContent(content);
	}

	/**
	* Returns the author ID of this post.
	*
	* @return the author ID of this post
	*/
	public long getAuthorId() {
		return _post.getAuthorId();
	}

	/**
	* Sets the author ID of this post.
	*
	* @param authorId the author ID of this post
	*/
	public void setAuthorId(long authorId) {
		_post.setAuthorId(authorId);
	}

	public boolean isNew() {
		return _post.isNew();
	}

	public void setNew(boolean n) {
		_post.setNew(n);
	}

	public boolean isCachedModel() {
		return _post.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_post.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _post.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _post.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_post.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _post.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_post.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PostWrapper((Post)_post.clone());
	}

	public int compareTo(com.liferay.portlet.simpleblog.model.Post post) {
		return _post.compareTo(post);
	}

	@Override
	public int hashCode() {
		return _post.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.liferay.portlet.simpleblog.model.Post> toCacheModel() {
		return _post.toCacheModel();
	}

	public com.liferay.portlet.simpleblog.model.Post toEscapedModel() {
		return new PostWrapper(_post.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _post.toString();
	}

	public java.lang.String toXmlString() {
		return _post.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_post.persist();
	}

	public com.liferay.portlet.simpleblog.model.Author getAuthor() {
		return _post.getAuthor();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Post getWrappedPost() {
		return _post;
	}

	public Post getWrappedModel() {
		return _post;
	}

	public void resetOriginalValues() {
		_post.resetOriginalValues();
	}

	private Post _post;
}