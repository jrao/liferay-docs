create index IX_7D6A6C59 on Entry (groupId, guestbookId, name[$COLUMN_LENGTH:75$]);
create index IX_AD799D00 on Entry (groupId, guestbookId, status);
create index IX_95A92313 on Entry (guestbookId, name[$COLUMN_LENGTH:75$]);
create index IX_EDB18D57 on Entry (name[$COLUMN_LENGTH:75$]);
create index IX_756A1B8C on Entry (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_A59C150E on Entry (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_29F22DE2 on Guestbook (groupId, name[$COLUMN_LENGTH:75$]);
create index IX_57172049 on Guestbook (groupId, status);
create index IX_299BA25B on Guestbook (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_DACF039D on Guestbook (uuid_[$COLUMN_LENGTH:75$], groupId);