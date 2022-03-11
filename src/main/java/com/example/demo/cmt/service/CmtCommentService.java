package com.example.demo.cmt.service;

import com.example.demo.cmt.converter.CmtCommentConverter;
import com.example.demo.cmt.converter.CmtCommentMapper;
import com.example.demo.cmt.dto.CmtCommentDto;
import com.example.demo.cmt.dto.CmtCustomerCommentsDto;
import com.example.demo.cmt.dto.CmtProductsCommentDto;
import com.example.demo.cmt.dto.CmtSaveRequestDto;
import com.example.demo.cmt.entity.CmtComment;
import com.example.demo.cus.service.entityservice.CusCustomerEntityService;
import com.example.demo.prd.service.entityservice.PrdProductEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CmtCommentService {
    private final CmtCommentEntityService cmtCommentEntityService;
    private final CmtCommentConverter cmtCommentConverter;
    private final PrdProductEntityService prdProductEntityService;
    private final CusCustomerEntityService cusCustomerEntityService;


   public List<CmtCustomerCommentsDto> findCustomerComments(Long id){

       if(cusCustomerEntityService.existsById(id)) {
           if (!cmtCommentEntityService.findAllByCustomerId(id).isEmpty()){
               List<CmtComment> cmtCommentList =cmtCommentEntityService.findAllByCustomerId(id);
               List<CmtCustomerCommentsDto> cmtCommentDtoList = cmtCommentConverter.convertToCmtCustomerCommentsDtoList(cmtCommentList);
               return cmtCommentDtoList;
           }
           else {
               String name = cusCustomerEntityService.findById(id).get().getName();
               throw new IllegalStateException(name + " has no comments");
           }
           }
       else {
           throw new IllegalStateException("DATA null");

       }
   }


    public List<CmtProductsCommentDto> findProductComments(Long id){



       if(prdProductEntityService.existsById(id)) {
           if (!cmtCommentEntityService.findAllByProductId(id).isEmpty()){
               List<CmtComment> cmtCommentList =cmtCommentEntityService.findAllByProductId(id);
               List<CmtProductsCommentDto> cmtCommentDtoList = cmtCommentConverter.convertToCmtProductsCommentDtoList(cmtCommentList);
               return cmtCommentDtoList;
           }
           else {
               String name= prdProductEntityService.findById(id).get().getName();
               throw new IllegalStateException("There are no comments for "+name);
           }


        }
       else throw new IllegalStateException("Data null");


    }

    public CmtCommentDto save(CmtSaveRequestDto cmtSaveRequestDto) {

        CmtComment cmtComment = CmtCommentMapper.INSTANCE.convertToComment(cmtSaveRequestDto);

        cmtComment = cmtCommentEntityService.save(cmtComment);

        CmtCommentDto cmtCommentDto = cmtCommentConverter.convertToCmtCommentDto(cmtComment);

        return cmtCommentDto;
    }

    public void delete(Long id) {

        CmtComment cmtComment = cmtCommentEntityService.findById(id).get();
        cmtCommentEntityService.delete(cmtComment);
    }

}
