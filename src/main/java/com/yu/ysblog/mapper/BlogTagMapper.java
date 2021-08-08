package com.yu.ysblog.mapper;

import com.yu.ysblog.entity.dao.BlogTag;
import com.yu.ysblog.entity.dao.Tag;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author yu
 * @DateTime 2021/8/7 20:26
 */
@Mapper
@Component
public interface BlogTagMapper {

//    @Select("select * from tag")
//    List<Tag> selectAll();
//
//    @Select("select * from tag where id=#{id}")
//    Tag selectById(String id);

    // 插入 并查询id 赋给传入的对象
    @Insert("insert into blog_tag values (#{id},#{blogId},#{tagId})")
    int insert(BlogTag blogTag);

    @Select("select b.id,b.name from blog_tag as a left OUTER join tag as b on a.tag_id=b.id where a.blog_id=#{blogId}")
    List<Tag> selectByBlogId(String blogId);

    @Select("select count(*) from blog_tag where tag_id=#{tagId}")
    int countByTagId(String tagId);

    @Delete("delete from blog_tag where blog_id=#{blogId}")
    int delete(String blogId);
}
