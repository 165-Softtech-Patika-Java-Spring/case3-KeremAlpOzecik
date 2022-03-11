package com.example.demo.cus.converter;

import com.example.demo.cus.dto.CusCustomerDeleteRequestDto;
import com.example.demo.cus.dto.CusCustomerDto;
import com.example.demo.cus.dto.CusCustomerSaveRequestDto;
import com.example.demo.cus.dto.CusCustomerUpdateRequestDto;
import com.example.demo.cus.entity.CusCustomer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CusCustomerMapper {

    CusCustomerMapper INSTANCE = Mappers.getMapper(CusCustomerMapper.class);

    CusCustomer convertToCusCustomer(CusCustomerSaveRequestDto cusCustomerSaveRequestDto);

    CusCustomer convertToCusCustomer(CusCustomerUpdateRequestDto cusCustomerUpdateRequestDto);

    CusCustomer convertToCusCustomer(CusCustomerDeleteRequestDto cusCustomerDeleteRequestDto);

    List<CusCustomerDto> convertToCusCustomerDtoList(List<CusCustomer> cusCustomerList);

    CusCustomerDto convertToCusCustomerDto(CusCustomer cusCustomer);
}
