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
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.simpleblog.model.Post;
import com.liferay.portlet.simpleblog.service.PostLocalServiceUtil;
import com.liferay.portlet.simpleblog.service.base.PostLocalServiceBaseImpl;
import com.liferay.portlet.simpleblog.service.persistence.PostFinderUtil;

/**
 * The implementation of the post local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.portlet.simpleblog.service.PostLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jbloggs
 * @see com.liferay.portlet.simpleblog.service.base.PostLocalServiceBaseImpl
 * @see com.liferay.portlet.simpleblog.service.PostLocalServiceUtil
 */
public class PostLocalServiceImpl extends PostLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.portlet.simpleblog.service.PostLocalServiceUtil} to access the post local service.
	 */
	
	public Post addPost(String title, String content, long authorId, ServiceContext serviceContext) {
		
		long postId = 0;
		
		try {
			postId = counterLocalService.increment(Post.class.getName());
		} catch (SystemException se) {
			se.printStackTrace();
		}
		
		Post post = super.createPost(postId);
		
		post.setTitle(title);
		
		post.setContent(content);
		
		post.setAuthorId(authorId);
		
		long companyId = serviceContext.getCompanyId();
		
		post.setCompanyId(companyId);
		
		long groupId = serviceContext.getScopeGroupId();
		
		post.setGroupId(groupId);
		
		long userId = 0;
		
		try {
			userId = serviceContext.getGuestOrUserId();
		} catch (PortalException pe) {
			pe.printStackTrace();
		} catch (SystemException se) {
			se.printStackTrace();
		}
		
		post.setUserId(userId);
		
		Date now = new Date();
		
		post.setCreateDate(now);
		
		post.setModifiedDate(now);
		
		try {
			PostLocalServiceUtil.addPost(post);
		} catch (SystemException se) {
			se.printStackTrace();
		}
		
		return post;
	}
	
	public Post updatePost(long postId, String title, String content, long authorId) {
		
		Post post = null;
		
		try {
			post = super.fetchPost(postId);
		} catch (SystemException se) {
			se.printStackTrace();
		}
		
		post.setTitle(title);
		
		post.setContent(content);
		
		post.setAuthorId(authorId);
		
		try {
			return PostLocalServiceUtil.updatePost(post);
		} catch (SystemException se) {
			se.printStackTrace();
		}
		
		return post;
	}
	
	public Post deletePost (long postId) {
		
		Post post = null;
		
		try {
			post = super.fetchPost(postId);
		} catch (SystemException se) {
			se.printStackTrace();
		}
		
		try {
			return super.deletePost(post);
		} catch (SystemException se) {
			se.printStackTrace();
		}
		
		return post;
	}
	
	public List<Post> findByTitleContentAuthor(String title, String content, String author, 
	        int begin, int end) throws SystemException {
		
	    return PostFinderUtil.findByTitleContentAuthor(title, content, author, begin, end);
	}	
	
}