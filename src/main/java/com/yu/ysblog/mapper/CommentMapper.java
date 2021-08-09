package com.yu.ysblog.mapper;

import com.yu.ysblog.entity.dao.Comment;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author yu
 * @DateTime 2021/8/7 20:26
 */
@Mapper
@Component
public interface CommentMapper {
    @Select("select * from comment order by create_time desc")
    List<Comment> selectAll();


    @Select("select * from comment where blog_id=#{blogId} order by create_time desc")
    List<Comment> getByBlogId(String blogId);

    @Select("select * from comment where id=#{id}")
    Comment selectById(String id);

    @Select("select count(*) from comment where blog_id=#{blogId}")
    int countByBlogId(String blogId);

    // 插入 并查询id 赋给传入的对象
    @Insert("insert into comment values (#{id},#{content},#{createTime},#{blogId},#{parentId},#{ip})")
    int insert(Comment comment);

    @Delete("<script>"
            + "delete from comment where id IN "
            + "<foreach item='id' index='index' collection='idList'  open='(' separator=',' close=')'>"
            + "#{id}"
            + "</foreach>"
            + "</script>"
    )
    int delete(@Param("idList") List<String> idList);
}
