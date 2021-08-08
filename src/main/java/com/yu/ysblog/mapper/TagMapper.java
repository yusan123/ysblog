package com.yu.ysblog.mapper;

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
public interface TagMapper {

    @Select("select * from tag")
    List<Tag> selectAll();

    @Select("select * from tag where id=#{id}")
    Tag selectById(String id);

    @Select("select count(*) from tag where name=#{name}")
    int countByName(String name);

    // 插入 并查询id 赋给传入的对象
    @Insert("insert into tag values (#{id},#{name})")
    int insert(Tag tag);

    @Delete("delete from tag where id=#{id}")
    int delete(String id);
}
