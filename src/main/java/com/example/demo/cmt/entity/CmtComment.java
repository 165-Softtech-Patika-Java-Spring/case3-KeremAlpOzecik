package com.example.demo.cmt.entity;

import com.example.demo.cus.entity.CusCustomer;
import com.example.demo.gen.entity.BaseEntity;
import com.example.demo.prd.entity.PrdProduct;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table
@Data
public class CmtComment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;


    @Column(name = "customer_id", nullable=false)
    private Long customer_id;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "customer_id", insertable=false, updatable=false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private CusCustomer cusCustomer;

    @Column(name = "product_id", nullable=false)
    private Long product_id;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "product_id", insertable=false, updatable=false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private PrdProduct prdProduct;
}
