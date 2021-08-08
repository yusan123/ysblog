-- 博客基本表
create table blog
(
    id   varchar(64) primary key,
    title varchar(150),
    create_time datetime,
    update_time datetime,
    context  TEXT
);
-- 分类标签表
create table tag
(
    id   varchar(64) primary key,
    name varchar(150)
);
-- 增加唯一索引保证标签名不能重复
create unique index tag_name_uindex
	on tag (name);
-- 博客与分类的关联关系表
create table blog_tag
(
    id   varchar(64) primary key,
    blog_id varchar(64),
    tag_id varchar(64)
);

