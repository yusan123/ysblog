package com.yu.ysblog.controller.admin;

import com.yu.ysblog.entity.dao.Tag;
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
}
