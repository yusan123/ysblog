package com.yu.ysblog.entity.vo;

import com.yu.ysblog.entity.dao.Tag;
import lombok.*;

import java.util.Date;
import java.util.List;

/**
 * @Author yu
 * @DateTime 2021/8/7 21:05
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class BlogVO {
    private String id;
    private String title;
    private Date createTime;
    private Date updateTime;
    private String context;
    private List<Tag> tags;
}
