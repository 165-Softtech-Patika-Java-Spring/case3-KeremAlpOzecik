package com.example.demo.cus.service.entityservice;



import com.example.demo.cus.dao.CusCustomerDao;
import com.example.demo.cus.entity.CusCustomer;
import com.example.demo.gen.service.BaseEntityService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CusCustomerEntityService extends BaseEntityService<CusCustomer, CusCustomerDao> {

    public CusCustomerEntityService(CusCustomerDao dao) {
        super(dao);
    }

    public List<CusCustomer> findAllBySurname(String surname){
        return getDao().findAllBySurname(surname);
    }
    public CusCustomer findAllByName(String name){
        return getDao().findAllByName(name);
    }
    public  CusCustomer findByNameOrPhoneOrEmail(String name,String phone,String email){
        return getDao().findByNameOrPhoneOrEmail(name,phone,email);
    }
    public  CusCustomer findByNameAndPhone(String name,String phone){
        return getDao().findByNameAndPhone(name,phone);
    }
}
