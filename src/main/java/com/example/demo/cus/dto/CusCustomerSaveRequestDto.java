package com.example.demo.cus.dto;

import com.example.demo.cus.enums.GenUserType;
import lombok.Data;


@Data
public class CusCustomerSaveRequestDto {

    private String name;
    private String surname;
    private Long identityNo;
    private String email;
    private String phone;
    private String password;
    private GenUserType statusType;
}
