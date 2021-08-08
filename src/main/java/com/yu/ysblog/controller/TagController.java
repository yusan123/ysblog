package com.yu.ysblog.controller;

import com.yu.ysblog.entity.dao.Tag;
import com.yu.ysblog.mapper.BlogTagMapper;
import com.yu.ysblog.mapper.TagMapper;
import com.yu.ysblog.util.CommonResponse;
import com.yu.ysblog.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author yu
 * @DateTime 2021/8/7 22:16
 */
@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    TagMapper tagMapper;

    @Autowired
    BlogTagMapper blogTagMapper;


    @PostMapping("/create")
    public CommonResponse create(@RequestParam String name) {
        Tag tag = Tag.builder().id(CommonUtil.uuid()).name(name).build();
        tagMapper.insert(tag);
        return CommonResponse.successResp("创建标签成功.", tag);
    }

    @GetMapping("/all")
    public CommonResponse all() {
        return CommonResponse.successResp("查询所有标签.", tagMapper.selectAll());
    }

    @GetMapping("/isExist")
    public CommonResponse isExist(@RequestParam String name) {
        int i = tagMapper.countByName(name.trim());
        if (i == 0) {
            return CommonResponse.successResp("该标签名不存在，可以使用", null);
        } else {
            return CommonResponse.failResp("该标签名已存在，不需要再创建", null);
        }
    }

    @DeleteMapping("/delete")
    public CommonResponse delete(@RequestParam String id) {
        // 查询中间表判断该标签是否已经存在
        int i = blogTagMapper.countByTagId(id);
        if (i != 0) {
            return CommonResponse.failResp("该标签名被使用不能删除...", null);
        }
        int delete = tagMapper.delete(id);
        return CommonResponse.successResp("删除标签成功.", null);
    }
}
