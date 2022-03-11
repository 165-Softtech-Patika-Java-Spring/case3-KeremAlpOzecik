package com.example.demo.cmt.dao;

import com.example.demo.cmt.dto.CmtCommentDto;
import com.example.demo.cmt.dto.CmtCustomerCommentsDto;
import com.example.demo.cmt.dto.CmtProductsCommentDto;
import com.example.demo.cmt.entity.CmtComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CmtCommentDao  extends JpaRepository<CmtComment,Long> {
    List<CmtComment> findByCusCustomerId(Long id);
    List<CmtComment> findByPrdProductId(Long id);


}
