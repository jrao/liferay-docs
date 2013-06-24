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

import com.liferay.portlet.simpleblog.model.Author;

/**
 * The persistence interface for the author service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jbloggs
 * @see AuthorPersistenceImpl
 * @see AuthorUtil
 * @generated
 */
public interface AuthorPersistence extends BasePersistence<Author> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AuthorUtil} to access the author persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the author in the entity cache if it is enabled.
	*
	* @param author the author
	*/
	public void cacheResult(com.liferay.portlet.simpleblog.model.Author author);

	/**
	* Caches the authors in the entity cache if it is enabled.
	*
	* @param authors the authors
	*/
	public void cacheResult(
		java.util.List<com.liferay.portlet.simpleblog.model.Author> authors);

	/**
	* Creates a new author with the primary key. Does not add the author to the database.
	*
	* @param authorId the primary key for the new author
	* @return the new author
	*/
	public com.liferay.portlet.simpleblog.model.Author create(long authorId);

	/**
	* Removes the author with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param authorId the primary key of the author
	* @return the author that was removed
	* @throws com.liferay.portlet.simpleblog.NoSuchAuthorException if a author with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.simpleblog.model.Author remove(long authorId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.simpleblog.NoSuchAuthorException;

	public com.liferay.portlet.simpleblog.model.Author updateImpl(
		com.liferay.portlet.simpleblog.model.Author author, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the author with the primary key or throws a {@link com.liferay.portlet.simpleblog.NoSuchAuthorException} if it could not be found.
	*
	* @param authorId the primary key of the author
	* @return the author
	* @throws com.liferay.portlet.simpleblog.NoSuchAuthorException if a author with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.simpleblog.model.Author findByPrimaryKey(
		long authorId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.simpleblog.NoSuchAuthorException;

	/**
	* Returns the author with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param authorId the primary key of the author
	* @return the author, or <code>null</code> if a author with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.simpleblog.model.Author fetchByPrimaryKey(
		long authorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the authors where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching authors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.simpleblog.model.Author> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.portlet.simpleblog.model.Author> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.portlet.simpleblog.model.Author> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first author in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching author
	* @throws com.liferay.portlet.simpleblog.NoSuchAuthorException if a matching author could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.simpleblog.model.Author findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.simpleblog.NoSuchAuthorException;

	/**
	* Returns the first author in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching author, or <code>null</code> if a matching author could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.simpleblog.model.Author fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last author in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching author
	* @throws com.liferay.portlet.simpleblog.NoSuchAuthorException if a matching author could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.simpleblog.model.Author findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.simpleblog.NoSuchAuthorException;

	/**
	* Returns the last author in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching author, or <code>null</code> if a matching author could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.simpleblog.model.Author fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.portlet.simpleblog.model.Author[] findByGroupId_PrevAndNext(
		long authorId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.simpleblog.NoSuchAuthorException;

	/**
	* Returns all the authors.
	*
	* @return the authors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.simpleblog.model.Author> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.portlet.simpleblog.model.Author> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.portlet.simpleblog.model.Author> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the authors where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the authors from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of authors where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching authors
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of authors.
	*
	* @return the number of authors
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the posts associated with the author.
	*
	* @param pk the primary key of the author
	* @return the posts associated with the author
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.simpleblog.model.Post> getPosts(
		long pk) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.portlet.simpleblog.model.Post> getPosts(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.portlet.simpleblog.model.Post> getPosts(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of posts associated with the author.
	*
	* @param pk the primary key of the author
	* @return the number of posts associated with the author
	* @throws SystemException if a system exception occurred
	*/
	public int getPostsSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the post is associated with the author.
	*
	* @param pk the primary key of the author
	* @param postPK the primary key of the post
	* @return <code>true</code> if the post is associated with the author; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsPost(long pk, long postPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the author has any posts associated with it.
	*
	* @param pk the primary key of the author to check for associations with posts
	* @return <code>true</code> if the author has any posts associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsPosts(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;
}