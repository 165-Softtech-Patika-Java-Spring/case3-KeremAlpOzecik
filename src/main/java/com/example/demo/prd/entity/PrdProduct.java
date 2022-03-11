package com.example.demo.prd.entity;

import com.example.demo.gen.entity.BaseEntity;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrdProduct extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String price;
    private String name;
}
