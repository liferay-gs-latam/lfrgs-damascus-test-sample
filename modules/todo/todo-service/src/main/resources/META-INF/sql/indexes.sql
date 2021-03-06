create index IX_4675E649 on Todo_Todo (companyId, status);
create index IX_54BC5183 on Todo_Todo (companyId, userId, status);
create index IX_8051478B on Todo_Todo (groupId, status);
create unique index IX_36C02242 on Todo_Todo (groupId, urlTitle[$COLUMN_LENGTH:75$]);
create index IX_AB4B50C5 on Todo_Todo (groupId, userId, status);
create index IX_81F58EC3 on Todo_Todo (title[$COLUMN_LENGTH:80$]);
create index IX_E0E97421 on Todo_Todo (todoBooleanStat);
create index IX_B9449F9A on Todo_Todo (todoDateTime);
create index IX_F0147625 on Todo_Todo (todoDocumentLibrary[$COLUMN_LENGTH:512$]);
create index IX_7D24B590 on Todo_Todo (todoDouble);
create index IX_74D9E3C3 on Todo_Todo (todoInteger);
create index IX_6FF7D8A8 on Todo_Todo (todoRichText[$COLUMN_LENGTH:4001$]);
create index IX_FF73672C on Todo_Todo (todoText[$COLUMN_LENGTH:4001$]);
create unique index IX_7FEEC542 on Todo_Todo (urlTitle[$COLUMN_LENGTH:75$]);
create index IX_E7BE9BAB on Todo_Todo (userId, groupId);
create index IX_71B3B3C5 on Todo_Todo (userId, status);
create index IX_27A66359 on Todo_Todo (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_15F1EC1B on Todo_Todo (uuid_[$COLUMN_LENGTH:75$], groupId);