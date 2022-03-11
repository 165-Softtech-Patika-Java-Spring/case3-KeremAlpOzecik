package com.example.demo.cmt.dto;

import lombok.Data;

@Data
public class CmtCommentDto {
    private Long id;
    private String comment;
    private Long customer_id;
    private Long product_id;
}
