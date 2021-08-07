package com.yu.ysblog;

import com.yu.ysblog.entity.dao.Blog;
import com.yu.ysblog.entity.dao.BlogTag;
import com.yu.ysblog.mapper.BlogMapper;
import com.yu.ysblog.mapper.BlogTagMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@SpringBootTest
class YsblogApplicationTests {

    @Autowired
    BlogMapper blogMapper;

    @Autowired
    BlogTagMapper blogTagMapper;

    @Test
    void contextLoads() {
    }

    @Test
    public void queryAll(){
        List<Blog> blogs = blogMapper.selectAll();
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
    }

//    @Test
//    public void insert(){
//        Date now = new Date();
//        Blog blog1 = Blog.builder()
//                .id("222")
//                .title("yuyuyuyu")
//                .createTime(now)
//                .updateTime(now)
//                .context("ddfdfsdfsdf")
//                .build();
//        int insert = blogMapper.insert(blog1);
//        System.out.println(insert);
//    }

    @Test
    public void blogTagInsert(){
        BlogTag build = BlogTag.builder().id("test1").tagId("t1").blogId("b1").build();
        int insert = blogTagMapper.insert(build);
        System.out.println(insert);
    }

}
