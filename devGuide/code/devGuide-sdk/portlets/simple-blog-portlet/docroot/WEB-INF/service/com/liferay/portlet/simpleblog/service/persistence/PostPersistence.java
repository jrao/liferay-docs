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

import com.liferay.portal.service.persistence.BasePersistence;

import com.liferay.portlet.simpleblog.model.Post;

/**
 * The persistence interface for the post service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jbloggs
 * @see PostPersistenceImpl
 * @see PostUtil
 * @generated
 */
public interface PostPersistence extends BasePersistence<Post> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PostUtil} to access the post persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the post in the entity cache if it is enabled.
	*
	* @param post the post
	*/
	public void cacheResult(com.liferay.portlet.simpleblog.model.Post post);

	/**
	* Caches the posts in the entity cache if it is enabled.
	*
	* @param posts the posts
	*/
	public void cacheResult(
		java.util.List<com.liferay.portlet.simpleblog.model.Post> posts);

	/**
	* Creates a new post with the primary key. Does not add the post to the database.
	*
	* @param postId the primary key for the new post
	* @return the new post
	*/
	public com.liferay.portlet.simpleblog.model.Post create(long postId);

	/**
	* Removes the post with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param postId the primary key of the post
	* @return the post that was removed
	* @throws com.liferay.portlet.simpleblog.NoSuchPostException if a post with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.simpleblog.model.Post remove(long postId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.simpleblog.NoSuchPostException;

	public com.liferay.portlet.simpleblog.model.Post updateImpl(
		com.liferay.portlet.simpleblog.model.Post post, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the post with the primary key or throws a {@link com.liferay.portlet.simpleblog.NoSuchPostException} if it could not be found.
	*
	* @param postId the primary key of the post
	* @return the post
	* @throws com.liferay.portlet.simpleblog.NoSuchPostException if a post with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.simpleblog.model.Post findByPrimaryKey(
		long postId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.simpleblog.NoSuchPostException;

	/**
	* Returns the post with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param postId the primary key of the post
	* @return the post, or <code>null</code> if a post with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.simpleblog.model.Post fetchByPrimaryKey(
		long postId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the posts where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching posts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.simpleblog.model.Post> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the posts where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of posts
	* @param end the upper bound of the range of posts (not inclusive)
	* @return the range of matching posts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.simpleblog.model.Post> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the posts where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of posts
	* @param end the upper bound of the range of posts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching posts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.simpleblog.model.Post> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first post in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching post
	* @throws com.liferay.portlet.simpleblog.NoSuchPostException if a matching post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.simpleblog.model.Post findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.simpleblog.NoSuchPostException;

	/**
	* Returns the first post in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching post, or <code>null</code> if a matching post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.simpleblog.model.Post fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last post in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching post
	* @throws com.liferay.portlet.simpleblog.NoSuchPostException if a matching post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.simpleblog.model.Post findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.simpleblog.NoSuchPostException;

	/**
	* Returns the last post in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching post, or <code>null</code> if a matching post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.simpleblog.model.Post fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the posts before and after the current post in the ordered set where groupId = &#63;.
	*
	* @param postId the primary key of the current post
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next post
	* @throws com.liferay.portlet.simpleblog.NoSuchPostException if a post with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.simpleblog.model.Post[] findByGroupId_PrevAndNext(
		long postId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.simpleblog.NoSuchPostException;

	/**
	* Returns all the posts.
	*
	* @return the posts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.simpleblog.model.Post> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the posts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of posts
	* @param end the upper bound of the range of posts (not inclusive)
	* @return the range of posts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.simpleblog.model.Post> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the posts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of posts
	* @param end the upper bound of the range of posts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of posts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.simpleblog.model.Post> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the posts where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the posts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of posts where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching posts
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of posts.
	*
	* @return the number of posts
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}