package com.example.demo.cus.dao;


import com.example.demo.cus.entity.CusCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface
CusCustomerDao extends JpaRepository<CusCustomer, Long> {

    List<CusCustomer> findAllBySurname(String surname);
   CusCustomer findAllByName(String name);
   CusCustomer findByNameOrPhoneOrEmail(String name ,String phone,String email);
   CusCustomer findByNameAndPhone(String name,String phone);

}
