package com.example.demo.cus.entity;


import com.example.demo.cus.enums.GenUserType;
import com.example.demo.gen.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "CUS_CUSTOMER")
@Data
public class CusCustomer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long identityNo;
    private String name;
    private String surname;
    private String password;
    private String email;
    private String phone;
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS_TYPE", length = 30)
    private GenUserType statusType;
}
