package com.example.demo.cmt.service;

import com.example.demo.cmt.dao.CmtCommentDao;
import com.example.demo.cmt.dto.CmtCommentDto;
import com.example.demo.cmt.dto.CmtCustomerCommentsDto;
import com.example.demo.cmt.dto.CmtSaveRequestDto;
import com.example.demo.cmt.entity.CmtComment;
import com.example.demo.cus.dao.CusCustomerDao;
import com.example.demo.cus.entity.CusCustomer;
import com.example.demo.gen.service.BaseEntityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmtCommentEntityService extends BaseEntityService<CmtComment, CmtCommentDao> {
    public CmtCommentEntityService(CmtCommentDao dao) {
        super(dao);
    }
    public List<CmtComment> findAllByCustomerId(Long id){
        return getDao().findByCusCustomerId(id);
    }
    public  List<CmtComment> findAllByProductId(Long id){
        return getDao().findByPrdProductId(id);
    }


}


