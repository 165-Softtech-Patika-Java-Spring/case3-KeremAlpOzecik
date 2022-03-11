package com.example.demo.cmt.converter;

import com.example.demo.cmt.dto.CmtCommentDto;
import com.example.demo.cmt.dto.CmtCustomerCommentsDto;
import com.example.demo.cmt.dto.CmtProductsCommentDto;
import com.example.demo.cmt.entity.CmtComment;
import com.example.demo.cus.dto.CusCustomerDto;
import com.example.demo.cus.entity.CusCustomer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CmtCommentConverter {
    public List<CmtCommentDto> convertToCmtCommentDtoList(List<CmtComment> cmtCommentList) {

        List<CmtCommentDto> cmtCommentDtoList = new ArrayList<>();
        for (CmtComment cmtComment : cmtCommentList) {

            CmtCommentDto cmtCommentDto = convertToCmtCommentDto(cmtComment);

            cmtCommentDtoList.add(cmtCommentDto);
        }

        return cmtCommentDtoList;
    }

    public CmtCommentDto convertToCmtCommentDto(CmtComment cmtComment) {
        CmtCommentDto cmtCommentDto = new CmtCommentDto();
        cmtCommentDto.setId(cmtComment.getId());
        cmtCommentDto.setComment(cmtComment.getComment());
        cmtCommentDto.setCustomer_id(cmtComment.getCustomer_id());
        cmtCommentDto.setProduct_id(cmtComment.getProduct_id());
        return cmtCommentDto;
    }


    public List<CmtCustomerCommentsDto> convertToCmtCustomerCommentsDtoList(List<CmtComment> cmtCommentList) {

        List<CmtCustomerCommentsDto> cmtCommentDtoList = new ArrayList<>();
        for (CmtComment cmtComment : cmtCommentList) {

            CmtCustomerCommentsDto cmtCommentDto = convertToCmtCustomerCommentsDto(cmtComment);

            cmtCommentDtoList.add(cmtCommentDto);
        }

        return cmtCommentDtoList;
    }

    public CmtCustomerCommentsDto convertToCmtCustomerCommentsDto(CmtComment cmtComment) {
        CmtCustomerCommentsDto cmtCustomerCommentsDto = new CmtCustomerCommentsDto();
        cmtCustomerCommentsDto.setCustomerComment(cmtComment.getComment());
        cmtCustomerCommentsDto.setCustomerName(cmtComment.getCusCustomer().getName());

        return cmtCustomerCommentsDto;
    }

    public List<CmtProductsCommentDto> convertToCmtProductsCommentDtoList(List<CmtComment> cmtCommentList) {

        List<CmtProductsCommentDto> cmtCommentDtoList = new ArrayList<>();
        for (CmtComment cmtComment : cmtCommentList) {

            CmtProductsCommentDto cmtCommentDto = convertToCmtProductsCommentDto(cmtComment);

            cmtCommentDtoList.add(cmtCommentDto);
        }

        return cmtCommentDtoList;
    }

    public CmtProductsCommentDto convertToCmtProductsCommentDto(CmtComment cmtComment) {
        CmtProductsCommentDto cmtProductsCommentDto = new CmtProductsCommentDto();
        cmtProductsCommentDto.setComment(cmtComment.getComment());
        cmtProductsCommentDto.setProductName(cmtComment.getPrdProduct().getName());

        return cmtProductsCommentDto;
    }


}
