package com.example.demo.prd.service.entityservice;

import com.example.demo.gen.service.BaseEntityService;
import com.example.demo.prd.dao.PrdProductDao;
import com.example.demo.prd.dto.PrdProductDto;
import com.example.demo.prd.entity.PrdProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class PrdProductEntityService extends BaseEntityService<PrdProduct, PrdProductDao> {


    public PrdProductEntityService(PrdProductDao dao) {
        super(dao);
    }

    public List<PrdProduct> findAll(){
       return getDao().findAll();
    }
    public Optional<PrdProduct> findById(Long id){
       return  getDao().findById(id);
    }
    public  void Delete(Long id){
       if (getDao().findById(id).isPresent())
           getDao().delete(getDao().findById(id).get());
      else throw new RuntimeException("Product does not exist");
    }


    public  void updatePrice(Long id,String newPrice){
        if (getDao().findById(id).isPresent())
            getDao().findById(id).get().setPrice(newPrice);
        else throw new RuntimeException("Product does not exist");
    }

    }


