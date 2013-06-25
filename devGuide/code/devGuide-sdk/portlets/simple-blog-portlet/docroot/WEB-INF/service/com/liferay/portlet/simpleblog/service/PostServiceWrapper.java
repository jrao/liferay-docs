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

package com.liferay.portlet.simpleblog.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link PostService}.
 * </p>
 *
 * @author    jbloggs
 * @see       PostService
 * @generated
 */
public class PostServiceWrapper implements PostService,
	ServiceWrapper<PostService> {
	public PostServiceWrapper(PostService postService) {
		_postService = postService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _postService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_postService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _postService.invokeMethod(name, parameterTypes, arguments);
	}

	public com.liferay.portlet.simpleblog.model.Post addPost() {
		return _postService.addPost();
	}

	public com.liferay.portlet.simpleblog.model.Post updatePost(long postId,
		java.lang.String title, java.lang.String content, long authorId) {
		return _postService.updatePost(postId, title, content, authorId);
	}

	public com.liferay.portlet.simpleblog.model.Post deletePost(long postId) {
		return _postService.deletePost(postId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public PostService getWrappedPostService() {
		return _postService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedPostService(PostService postService) {
		_postService = postService;
	}

	public PostService getWrappedService() {
		return _postService;
	}

	public void setWrappedService(PostService postService) {
		_postService = postService;
	}

	private PostService _postService;
}