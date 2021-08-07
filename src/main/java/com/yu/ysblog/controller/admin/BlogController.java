package com.yu.ysblog.controller.admin;

import com.yu.ysblog.entity.dao.Blog;
import com.yu.ysblog.entity.dao.BlogTag;
import com.yu.ysblog.entity.vo.BlogAddReq;
import com.yu.ysblog.entity.vo.BlogVO;
import com.yu.ysblog.mapper.BlogMapper;
import com.yu.ysblog.mapper.BlogTagMapper;
import com.yu.ysblog.mapper.TagMapper;
import com.yu.ysblog.util.CommonResponse;
import com.yu.ysblog.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author yu
 * @DateTime 2021/8/7 20:42
 */
@RequestMapping("/blog")
@RestController
@Slf4j
public class BlogController {

    @Autowired
    BlogMapper blogMapper;

    @Autowired
    TagMapper tagMapper;

    @Autowired
    BlogTagMapper blogTagMapper;

    @GetMapping("/all")
    public CommonResponse queryAllBlog() {
        // 查询博客基本信息
        List<Blog> blogs = blogMapper.selectAll();

        //查询博客类型
        List<BlogVO> voList = blogs.stream().map(b -> {
            BlogVO blogVO = BlogVO.builder().build();
            BeanUtils.copyProperties(b, blogVO);
            // 查询出此博客管理出的所有标签
            blogVO.setTags(blogTagMapper.selectByBlogId(b.getId()));
            return blogVO;
        }).collect(Collectors.toList());
        return CommonResponse.successResp("查询所有博客成功", voList);
    }

    @PostMapping("/create")
    public CommonResponse create(@RequestBody BlogAddReq blogAddReq) {

        // 保存博客基本信息
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogAddReq, blog);
//        LocalDateTime now = LocalDateTime.now();
        Date now = new Date();
        String blogId = CommonUtil.uuid();
        blog.setId(blogId);
        blog.setCreateTime(now);
        blog.setUpdateTime(now);
        blogMapper.insert(blog);

        // 保存博客对应的标签
        List<String> tagIds = blogAddReq.getTagIds();
        int count = 0;
        for (String tagId : tagIds) {
            BlogTag blogTag = BlogTag.builder().id(CommonUtil.uuid()).blogId(blogId).tagId(tagId).build();
            int insert = blogTagMapper.insert(blogTag);
            count += insert;
            log.info("create blog tag success: blogId={}, tagId={}", blogId, tagId);
        }
        if(tagIds.size() != count){
            return CommonResponse.failResp("创建博客标签出错", null);
        }
        return CommonResponse.successResp("新增博客成功", "blogId: " + blogId);
    }


    @GetMapping("/getById")
    public CommonResponse getById(@RequestParam String id) {
        // 查询博客基本信息
        Blog b = blogMapper.selectById(id);

        BlogVO blogVO = BlogVO.builder().build();
        BeanUtils.copyProperties(b, blogVO);
        blogVO.setTags(blogTagMapper.selectByBlogId(b.getId()));

        return CommonResponse.successResp("查询单个博客成功", blogVO);
    }

}
