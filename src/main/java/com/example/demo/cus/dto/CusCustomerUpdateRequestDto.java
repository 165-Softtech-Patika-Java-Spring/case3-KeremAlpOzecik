package com.example.demo.cus.dto;

import com.example.demo.cus.enums.GenUserType;
import lombok.Data;


@Data
public class CusCustomerUpdateRequestDto {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String password;
    private Long identityNo;
    private GenUserType statusType;
}
