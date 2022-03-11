package com.example.demo.cmt.converter;

import com.example.demo.cmt.dto.CmtCommentDto;
import com.example.demo.cmt.dto.CmtCustomerCommentsDto;
import com.example.demo.cmt.dto.CmtResponseDto;
import com.example.demo.cmt.dto.CmtSaveRequestDto;
import com.example.demo.cmt.entity.CmtComment;
import com.example.demo.cus.dto.CusCustomerDeleteRequestDto;
import com.example.demo.cus.entity.CusCustomer;
import com.example.demo.prd.dto.PrdProductDto;
import com.example.demo.prd.dto.PrdProductSaveRequestDto;
import com.example.demo.prd.entity.PrdProduct;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CmtCommentMapper {

    CmtCommentMapper INSTANCE = Mappers.getMapper(CmtCommentMapper.class);

    CmtComment convertToComment(CmtSaveRequestDto cmtSaveRequestDto);

    CmtResponseDto convertToCommentResponseDto(CmtComment cmtComment);



}
