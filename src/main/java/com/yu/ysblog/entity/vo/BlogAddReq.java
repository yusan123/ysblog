package com.yu.ysblog.entity.vo;

import lombok.*;

import java.util.List;

/**
 * @Author yu
 * @DateTime 2021/8/7 21:43
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class BlogAddReq {
    private String title;
    private String context;
    private List<String> tagIds;
}
