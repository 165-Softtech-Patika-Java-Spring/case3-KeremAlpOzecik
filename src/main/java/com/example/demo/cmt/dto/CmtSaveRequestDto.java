package com.example.demo.cmt.dto;

import lombok.Data;

@Data
public class CmtSaveRequestDto {
    private String comment;
    private Long customer_id;
    private Long product_id;
}
