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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.simpleblog.model.Post;
import com.liferay.portlet.simpleblog.service.PostLocalServiceUtil;
import com.liferay.portlet.simpleblog.service.base.PostServiceBaseImpl;

/**
 * The implementation of the post remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.portlet.simpleblog.service.PostService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author jbloggs
 * @see com.liferay.portlet.simpleblog.service.base.PostServiceBaseImpl
 * @see com.liferay.portlet.simpleblog.service.PostServiceUtil
 */
public class PostServiceImpl extends PostServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.portlet.simpleblog.service.PostServiceUtil} to access the post remote service.
	 */
	
	public Post addPost() {
		
		long postId = 0;
		
		try {
			postId = CounterLocalServiceUtil.increment(Post.class.getName());
		} catch (SystemException se) {
			se.printStackTrace();
		}
		
		Post post = PostLocalServiceUtil.createPost(postId);
		
		Date now = new Date();
		
		post.setCreateDate(now);
		
		post.setModifiedDate(now);
		
		try {
			return PostLocalServiceUtil.addPost(post);
		} catch (SystemException se) {
			se.printStackTrace();
		}
		
		return null;
	}
	
	public Post updatePost(long postId, String title, String content, long authorId) {
		
		Post post = null;
		
		try {
			post = PostLocalServiceUtil.fetchPost(postId);
		} catch (SystemException se) {
			se.printStackTrace();
		}
		
		post.setTitle(title);
		
		post.setContent(content);
		
		post.setAuthorId(authorId);
		
		Date now = new Date();
		
		post.setModifiedDate(now);
		
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
			post = PostLocalServiceUtil.fetchPost(postId);
		} catch (SystemException se) {
			se.printStackTrace();
		}
		
		try {
			return PostLocalServiceUtil.deletePost(post);
		} catch (SystemException se) {
			se.printStackTrace();
		}
		
		return post;
	}
}