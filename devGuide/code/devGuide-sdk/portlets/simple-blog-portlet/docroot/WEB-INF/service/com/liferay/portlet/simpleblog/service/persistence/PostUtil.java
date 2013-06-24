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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.simpleblog.model.Post;

import java.util.List;

/**
 * The persistence utility for the post service. This utility wraps {@link PostPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jbloggs
 * @see PostPersistence
 * @see PostPersistenceImpl
 * @generated
 */
public class PostUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Post post) {
		getPersistence().clearCache(post);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Post> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Post> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Post> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Post update(Post post, boolean merge)
		throws SystemException {
		return getPersistence().update(post, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Post update(Post post, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(post, merge, serviceContext);
	}

	/**
	* Caches the post in the entity cache if it is enabled.
	*
	* @param post the post
	*/
	public static void cacheResult(
		com.liferay.portlet.simpleblog.model.Post post) {
		getPersistence().cacheResult(post);
	}

	/**
	* Caches the posts in the entity cache if it is enabled.
	*
	* @param posts the posts
	*/
	public static void cacheResult(
		java.util.List<com.liferay.portlet.simpleblog.model.Post> posts) {
		getPersistence().cacheResult(posts);
	}

	/**
	* Creates a new post with the primary key. Does not add the post to the database.
	*
	* @param postId the primary key for the new post
	* @return the new post
	*/
	public static com.liferay.portlet.simpleblog.model.Post create(long postId) {
		return getPersistence().create(postId);
	}

	/**
	* Removes the post with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param postId the primary key of the post
	* @return the post that was removed
	* @throws com.liferay.portlet.simpleblog.NoSuchPostException if a post with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.simpleblog.model.Post remove(long postId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.simpleblog.NoSuchPostException {
		return getPersistence().remove(postId);
	}

	public static com.liferay.portlet.simpleblog.model.Post updateImpl(
		com.liferay.portlet.simpleblog.model.Post post, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(post, merge);
	}

	/**
	* Returns the post with the primary key or throws a {@link com.liferay.portlet.simpleblog.NoSuchPostException} if it could not be found.
	*
	* @param postId the primary key of the post
	* @return the post
	* @throws com.liferay.portlet.simpleblog.NoSuchPostException if a post with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.simpleblog.model.Post findByPrimaryKey(
		long postId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.simpleblog.NoSuchPostException {
		return getPersistence().findByPrimaryKey(postId);
	}

	/**
	* Returns the post with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param postId the primary key of the post
	* @return the post, or <code>null</code> if a post with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.simpleblog.model.Post fetchByPrimaryKey(
		long postId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(postId);
	}

	/**
	* Returns all the posts where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching posts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.simpleblog.model.Post> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

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
	public static java.util.List<com.liferay.portlet.simpleblog.model.Post> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

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
	public static java.util.List<com.liferay.portlet.simpleblog.model.Post> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first post in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching post
	* @throws com.liferay.portlet.simpleblog.NoSuchPostException if a matching post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.simpleblog.model.Post findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.simpleblog.NoSuchPostException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first post in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching post, or <code>null</code> if a matching post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.simpleblog.model.Post fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last post in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching post
	* @throws com.liferay.portlet.simpleblog.NoSuchPostException if a matching post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.simpleblog.model.Post findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.simpleblog.NoSuchPostException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last post in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching post, or <code>null</code> if a matching post could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.simpleblog.model.Post fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

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
	public static com.liferay.portlet.simpleblog.model.Post[] findByGroupId_PrevAndNext(
		long postId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.simpleblog.NoSuchPostException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(postId, groupId, orderByComparator);
	}

	/**
	* Returns all the posts.
	*
	* @return the posts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.simpleblog.model.Post> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.liferay.portlet.simpleblog.model.Post> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.liferay.portlet.simpleblog.model.Post> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the posts where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Removes all the posts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of posts where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching posts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the number of posts.
	*
	* @return the number of posts
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PostPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PostPersistence)PortletBeanLocatorUtil.locate(com.liferay.portlet.simpleblog.service.ClpSerializer.getServletContextName(),
					PostPersistence.class.getName());

			ReferenceRegistry.registerReference(PostUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(PostPersistence persistence) {
	}

	private static PostPersistence _persistence;
}