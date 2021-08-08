package com.yu.ysblog.mapper;

import com.yu.ysblog.entity.dao.Blog;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author yu
 * @DateTime 2021/8/7 20:26
 */
@Mapper
@Component
public interface BlogMapper {

    @Select("select * from blog")
    List<Blog> selectAll();

    @Select("select * from blog where id=#{id}")
    Blog selectById(String id);

    // 插入 并查询id 赋给传入的对象
    @Insert("insert into blog values (#{id},#{title},#{createTime},#{updateTime},#{context})")
    int insert(Blog blog);

    @Delete("delete from blog where id=#{id}")
    int delete(String id);

    @Update("update blog set title=#{title},context=#{context},update_time=#{updateTime} where id=#{id}")
    int update(Blog blog);
}
