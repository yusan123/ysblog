package com.yu.ysblog.controller;

import com.alibaba.fastjson.JSON;
import com.yu.ysblog.entity.dao.Comment;
import com.yu.ysblog.entity.vo.CommentAddReq;
import com.yu.ysblog.mapper.CommentMapper;
import com.yu.ysblog.util.CommonResponse;
import com.yu.ysblog.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Author yu
 * @DateTime 2021/8/8 12:07
 */
@RequestMapping("/comment")
@RestController
@Slf4j
public class CommentController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private CommentMapper commentMapper;

    @PostMapping("/create")
    public CommonResponse create(@RequestBody CommentAddReq commentAddReq) {
        log.info("博客新增评论的参数为：" + JSON.toJSONString(commentAddReq));
        if (ObjectUtils.isEmpty(commentAddReq.getContent())) {
            throw new RuntimeException("评论内容不能为空.");
        }
        Comment comment = Comment.builder()
                .id(CommonUtil.uuid())
                .blogId(commentAddReq.getBlogId())
                .content(commentAddReq.getContent())
                .parentId(commentAddReq.getParentId())
                .createTime(new Date())
                .ip(request.getRemoteAddr()).build();
        commentMapper.insert(comment);
        return CommonResponse.successResp("新增评论成功.", comment.getId());
    }

    @GetMapping("/all")
    public CommonResponse getAll(@RequestParam(required = false) String blogId) {
        List<Comment> comments;
        if (ObjectUtils.isEmpty(blogId)) {
            comments = commentMapper.selectAll();
        } else {
            comments = commentMapper.getByBlogId(blogId);
        }
        return CommonResponse.successResp("查询所有评论成功.", comments);
    }

//    @GetMapping("/getByBlogId")
//    public CommonResponse getByBlogId(@RequestParam String blogId) {
//        List<Comment> comments = commentMapper.getByBlogId(blogId);
//        return CommonResponse.successResp("查询指定博客所有评论成功.", comments);
//    }

    @DeleteMapping("/delete")
    public CommonResponse del(@RequestParam String ids) {
        log.info("批量删除评论的参数为:" + ids);
        String[] idsArr = ids.split(",");
        List<String> idList = Arrays.asList(idsArr);
        commentMapper.delete(idList);
        return CommonResponse.successResp("批量删除评论成功.", null);
    }
}
