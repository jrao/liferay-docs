/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.liferay.docs.guestbook.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;

import com.liferay.docs.guestbook.exception.NoSuchEntryException;
import com.liferay.docs.guestbook.model.Entry;
import com.liferay.docs.guestbook.service.EntryLocalServiceUtil;
import com.liferay.docs.guestbook.service.persistence.EntryPersistence;
import com.liferay.docs.guestbook.service.persistence.EntryUtil;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.TransactionalTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import org.junit.runner.RunWith;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class EntryPersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED));

	@Before
	public void setUp() {
		_persistence = EntryUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Entry> iterator = _entries.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Entry entry = _persistence.create(pk);

		Assert.assertNotNull(entry);

		Assert.assertEquals(entry.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Entry newEntry = addEntry();

		_persistence.remove(newEntry);

		Entry existingEntry = _persistence.fetchByPrimaryKey(newEntry.getPrimaryKey());

		Assert.assertNull(existingEntry);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addEntry();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Entry newEntry = _persistence.create(pk);

		newEntry.setUuid(RandomTestUtil.randomString());

		newEntry.setGroupId(RandomTestUtil.nextLong());

		newEntry.setCompanyId(RandomTestUtil.nextLong());

		newEntry.setUserId(RandomTestUtil.nextLong());

		newEntry.setUserName(RandomTestUtil.randomString());

		newEntry.setCreateDate(RandomTestUtil.nextDate());

		newEntry.setModifiedDate(RandomTestUtil.nextDate());

		newEntry.setName(RandomTestUtil.randomString());

		newEntry.setEmail(RandomTestUtil.randomString());

		newEntry.setMessage(RandomTestUtil.randomString());

		newEntry.setGuestbookId(RandomTestUtil.nextLong());

		newEntry.setStatus(RandomTestUtil.nextInt());

		newEntry.setStatusByUserId(RandomTestUtil.nextLong());

		newEntry.setStatusByUserName(RandomTestUtil.randomString());

		newEntry.setStatusDate(RandomTestUtil.nextDate());

		_entries.add(_persistence.update(newEntry));

		Entry existingEntry = _persistence.findByPrimaryKey(newEntry.getPrimaryKey());

		Assert.assertEquals(existingEntry.getUuid(), newEntry.getUuid());
		Assert.assertEquals(existingEntry.getEntryId(), newEntry.getEntryId());
		Assert.assertEquals(existingEntry.getGroupId(), newEntry.getGroupId());
		Assert.assertEquals(existingEntry.getCompanyId(),
			newEntry.getCompanyId());
		Assert.assertEquals(existingEntry.getUserId(), newEntry.getUserId());
		Assert.assertEquals(existingEntry.getUserName(), newEntry.getUserName());
		Assert.assertEquals(Time.getShortTimestamp(
				existingEntry.getCreateDate()),
			Time.getShortTimestamp(newEntry.getCreateDate()));
		Assert.assertEquals(Time.getShortTimestamp(
				existingEntry.getModifiedDate()),
			Time.getShortTimestamp(newEntry.getModifiedDate()));
		Assert.assertEquals(existingEntry.getName(), newEntry.getName());
		Assert.assertEquals(existingEntry.getEmail(), newEntry.getEmail());
		Assert.assertEquals(existingEntry.getMessage(), newEntry.getMessage());
		Assert.assertEquals(existingEntry.getGuestbookId(),
			newEntry.getGuestbookId());
		Assert.assertEquals(existingEntry.getStatus(), newEntry.getStatus());
		Assert.assertEquals(existingEntry.getStatusByUserId(),
			newEntry.getStatusByUserId());
		Assert.assertEquals(existingEntry.getStatusByUserName(),
			newEntry.getStatusByUserName());
		Assert.assertEquals(Time.getShortTimestamp(
				existingEntry.getStatusDate()),
			Time.getShortTimestamp(newEntry.getStatusDate()));
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid(StringPool.BLANK);

		_persistence.countByUuid(StringPool.NULL);

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByUUID_G() throws Exception {
		_persistence.countByUUID_G(StringPool.BLANK, RandomTestUtil.nextLong());

		_persistence.countByUUID_G(StringPool.NULL, 0L);

		_persistence.countByUUID_G((String)null, 0L);
	}

	@Test
	public void testCountByUuid_C() throws Exception {
		_persistence.countByUuid_C(StringPool.BLANK, RandomTestUtil.nextLong());

		_persistence.countByUuid_C(StringPool.NULL, 0L);

		_persistence.countByUuid_C((String)null, 0L);
	}

	@Test
	public void testCountByG_G() throws Exception {
		_persistence.countByG_G(RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong());

		_persistence.countByG_G(0L, 0L);
	}

	@Test
	public void testCountByEntryName() throws Exception {
		_persistence.countByEntryName(StringPool.BLANK);

		_persistence.countByEntryName(StringPool.NULL);

		_persistence.countByEntryName((String)null);
	}

	@Test
	public void testCountByG_N() throws Exception {
		_persistence.countByG_N(RandomTestUtil.nextLong(), StringPool.BLANK);

		_persistence.countByG_N(0L, StringPool.NULL);

		_persistence.countByG_N(0L, (String)null);
	}

	@Test
	public void testCountByG_G_N() throws Exception {
		_persistence.countByG_G_N(RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong(), StringPool.BLANK);

		_persistence.countByG_G_N(0L, 0L, StringPool.NULL);

		_persistence.countByG_G_N(0L, 0L, (String)null);
	}

	@Test
	public void testCountByG_G_S() throws Exception {
		_persistence.countByG_G_S(RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong(), RandomTestUtil.nextInt());

		_persistence.countByG_G_S(0L, 0L, 0);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Entry newEntry = addEntry();

		Entry existingEntry = _persistence.findByPrimaryKey(newEntry.getPrimaryKey());

		Assert.assertEquals(existingEntry, newEntry);
	}

	@Test(expected = NoSuchEntryException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			getOrderByComparator());
	}

	protected OrderByComparator<Entry> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("Entry", "uuid", true,
			"entryId", true, "groupId", true, "companyId", true, "userId",
			true, "userName", true, "createDate", true, "modifiedDate", true,
			"name", true, "email", true, "message", true, "guestbookId", true,
			"status", true, "statusByUserId", true, "statusByUserName", true,
			"statusDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Entry newEntry = addEntry();

		Entry existingEntry = _persistence.fetchByPrimaryKey(newEntry.getPrimaryKey());

		Assert.assertEquals(existingEntry, newEntry);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Entry missingEntry = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingEntry);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		Entry newEntry1 = addEntry();
		Entry newEntry2 = addEntry();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEntry1.getPrimaryKey());
		primaryKeys.add(newEntry2.getPrimaryKey());

		Map<Serializable, Entry> entries = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, entries.size());
		Assert.assertEquals(newEntry1, entries.get(newEntry1.getPrimaryKey()));
		Assert.assertEquals(newEntry2, entries.get(newEntry2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Entry> entries = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(entries.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		Entry newEntry = addEntry();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEntry.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Entry> entries = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, entries.size());
		Assert.assertEquals(newEntry, entries.get(newEntry.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Entry> entries = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(entries.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		Entry newEntry = addEntry();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEntry.getPrimaryKey());

		Map<Serializable, Entry> entries = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, entries.size());
		Assert.assertEquals(newEntry, entries.get(newEntry.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = EntryLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<Entry>() {
				@Override
				public void performAction(Entry entry) {
					Assert.assertNotNull(entry);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		Entry newEntry = addEntry();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Entry.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("entryId",
				newEntry.getEntryId()));

		List<Entry> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Entry existingEntry = result.get(0);

		Assert.assertEquals(existingEntry, newEntry);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Entry.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("entryId",
				RandomTestUtil.nextLong()));

		List<Entry> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		Entry newEntry = addEntry();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Entry.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("entryId"));

		Object newEntryId = newEntry.getEntryId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("entryId",
				new Object[] { newEntryId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingEntryId = result.get(0);

		Assert.assertEquals(existingEntryId, newEntryId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Entry.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("entryId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("entryId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Entry newEntry = addEntry();

		_persistence.clearCache();

		Entry existingEntry = _persistence.findByPrimaryKey(newEntry.getPrimaryKey());

		Assert.assertTrue(Validator.equals(existingEntry.getUuid(),
				ReflectionTestUtil.invoke(existingEntry, "getOriginalUuid",
					new Class<?>[0])));
		Assert.assertEquals(Long.valueOf(existingEntry.getGroupId()),
			ReflectionTestUtil.<Long>invoke(existingEntry,
				"getOriginalGroupId", new Class<?>[0]));
	}

	protected Entry addEntry() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Entry entry = _persistence.create(pk);

		entry.setUuid(RandomTestUtil.randomString());

		entry.setGroupId(RandomTestUtil.nextLong());

		entry.setCompanyId(RandomTestUtil.nextLong());

		entry.setUserId(RandomTestUtil.nextLong());

		entry.setUserName(RandomTestUtil.randomString());

		entry.setCreateDate(RandomTestUtil.nextDate());

		entry.setModifiedDate(RandomTestUtil.nextDate());

		entry.setName(RandomTestUtil.randomString());

		entry.setEmail(RandomTestUtil.randomString());

		entry.setMessage(RandomTestUtil.randomString());

		entry.setGuestbookId(RandomTestUtil.nextLong());

		entry.setStatus(RandomTestUtil.nextInt());

		entry.setStatusByUserId(RandomTestUtil.nextLong());

		entry.setStatusByUserName(RandomTestUtil.randomString());

		entry.setStatusDate(RandomTestUtil.nextDate());

		_entries.add(_persistence.update(entry));

		return entry;
	}

	private List<Entry> _entries = new ArrayList<Entry>();
	private EntryPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}