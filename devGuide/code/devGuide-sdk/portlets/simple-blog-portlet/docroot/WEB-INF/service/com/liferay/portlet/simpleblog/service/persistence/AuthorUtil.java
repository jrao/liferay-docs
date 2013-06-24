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

import com.liferay.portlet.simpleblog.model.Author;

import java.util.List;

/**
 * The persistence utility for the author service. This utility wraps {@link AuthorPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jbloggs
 * @see AuthorPersistence
 * @see AuthorPersistenceImpl
 * @generated
 */
public class AuthorUtil {
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
	public static void clearCache(Author author) {
		getPersistence().clearCache(author);
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
	public static List<Author> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Author> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Author> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Author update(Author author, boolean merge)
		throws SystemException {
		return getPersistence().update(author, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Author update(Author author, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(author, merge, serviceContext);
	}

	/**
	* Caches the author in the entity cache if it is enabled.
	*
	* @param author the author
	*/
	public static void cacheResult(
		com.liferay.portlet.simpleblog.model.Author author) {
		getPersistence().cacheResult(author);
	}

	/**
	* Caches the authors in the entity cache if it is enabled.
	*
	* @param authors the authors
	*/
	public static void cacheResult(
		java.util.List<com.liferay.portlet.simpleblog.model.Author> authors) {
		getPersistence().cacheResult(authors);
	}

	/**
	* Creates a new author with the primary key. Does not add the author to the database.
	*
	* @param authorId the primary key for the new author
	* @return the new author
	*/
	public static com.liferay.portlet.simpleblog.model.Author create(
		long authorId) {
		return getPersistence().create(authorId);
	}

	/**
	* Removes the author with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param authorId the primary key of the author
	* @return the author that was removed
	* @throws com.liferay.portlet.simpleblog.NoSuchAuthorException if a author with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.simpleblog.model.Author remove(
		long authorId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.simpleblog.NoSuchAuthorException {
		return getPersistence().remove(authorId);
	}

	public static com.liferay.portlet.simpleblog.model.Author updateImpl(
		com.liferay.portlet.simpleblog.model.Author author, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(author, merge);
	}

	/**
	* Returns the author with the primary key or throws a {@link com.liferay.portlet.simpleblog.NoSuchAuthorException} if it could not be found.
	*
	* @param authorId the primary key of the author
	* @return the author
	* @throws com.liferay.portlet.simpleblog.NoSuchAuthorException if a author with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.simpleblog.model.Author findByPrimaryKey(
		long authorId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.simpleblog.NoSuchAuthorException {
		return getPersistence().findByPrimaryKey(authorId);
	}

	/**
	* Returns the author with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param authorId the primary key of the author
	* @return the author, or <code>null</code> if a author with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.simpleblog.model.Author fetchByPrimaryKey(
		long authorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(authorId);
	}

	/**
	* Returns all the authors where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching authors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.simpleblog.model.Author> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the authors where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of authors
	* @param end the upper bound of the range of authors (not inclusive)
	* @return the range of matching authors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.simpleblog.model.Author> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the authors where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of authors
	* @param end the upper bound of the range of authors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching authors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.simpleblog.model.Author> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first author in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching author
	* @throws com.liferay.portlet.simpleblog.NoSuchAuthorException if a matching author could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.simpleblog.model.Author findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.simpleblog.NoSuchAuthorException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first author in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching author, or <code>null</code> if a matching author could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.simpleblog.model.Author fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last author in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching author
	* @throws com.liferay.portlet.simpleblog.NoSuchAuthorException if a matching author could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.simpleblog.model.Author findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.simpleblog.NoSuchAuthorException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last author in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching author, or <code>null</code> if a matching author could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.simpleblog.model.Author fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the authors before and after the current author in the ordered set where groupId = &#63;.
	*
	* @param authorId the primary key of the current author
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next author
	* @throws com.liferay.portlet.simpleblog.NoSuchAuthorException if a author with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.simpleblog.model.Author[] findByGroupId_PrevAndNext(
		long authorId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.simpleblog.NoSuchAuthorException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(authorId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the authors.
	*
	* @return the authors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.simpleblog.model.Author> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the authors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of authors
	* @param end the upper bound of the range of authors (not inclusive)
	* @return the range of authors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.simpleblog.model.Author> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the authors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of authors
	* @param end the upper bound of the range of authors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of authors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.simpleblog.model.Author> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the authors where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Removes all the authors from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of authors where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching authors
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the number of authors.
	*
	* @return the number of authors
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	/**
	* Returns all the posts associated with the author.
	*
	* @param pk the primary key of the author
	* @return the posts associated with the author
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.simpleblog.model.Post> getPosts(
		long pk) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getPosts(pk);
	}

	/**
	* Returns a range of all the posts associated with the author.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the author
	* @param start the lower bound of the range of authors
	* @param end the upper bound of the range of authors (not inclusive)
	* @return the range of posts associated with the author
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.simpleblog.model.Post> getPosts(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getPosts(pk, start, end);
	}

	/**
	* Returns an ordered range of all the posts associated with the author.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the author
	* @param start the lower bound of the range of authors
	* @param end the upper bound of the range of authors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of posts associated with the author
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.simpleblog.model.Post> getPosts(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getPosts(pk, start, end, orderByComparator);
	}

	/**
	* Returns the number of posts associated with the author.
	*
	* @param pk the primary key of the author
	* @return the number of posts associated with the author
	* @throws SystemException if a system exception occurred
	*/
	public static int getPostsSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getPostsSize(pk);
	}

	/**
	* Returns <code>true</code> if the post is associated with the author.
	*
	* @param pk the primary key of the author
	* @param postPK the primary key of the post
	* @return <code>true</code> if the post is associated with the author; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsPost(long pk, long postPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsPost(pk, postPK);
	}

	/**
	* Returns <code>true</code> if the author has any posts associated with it.
	*
	* @param pk the primary key of the author to check for associations with posts
	* @return <code>true</code> if the author has any posts associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsPosts(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsPosts(pk);
	}

	public static AuthorPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AuthorPersistence)PortletBeanLocatorUtil.locate(com.liferay.portlet.simpleblog.service.ClpSerializer.getServletContextName(),
					AuthorPersistence.class.getName());

			ReferenceRegistry.registerReference(AuthorUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(AuthorPersistence persistence) {
	}

	private static AuthorPersistence _persistence;
}