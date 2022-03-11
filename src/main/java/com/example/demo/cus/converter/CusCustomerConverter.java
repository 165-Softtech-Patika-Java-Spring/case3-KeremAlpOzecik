package com.example.demo.cus.converter;


import com.example.demo.cus.dto.CusCustomerDto;
import com.example.demo.cus.entity.CusCustomer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CusCustomerConverter {

    public List<CusCustomerDto> convertToCusCustomerDtoList(List<CusCustomer> cusCustomerList) {

        List<CusCustomerDto> cusCustomerDtoList = new ArrayList<>();
        for (CusCustomer cusCustomer : cusCustomerList) {

            CusCustomerDto cusCustomerDto = convertToCusCustomerDto(cusCustomer);

            cusCustomerDtoList.add(cusCustomerDto);
        }

        return cusCustomerDtoList;
    }

    public CusCustomerDto convertToCusCustomerDto(CusCustomer cusCustomer) {
        CusCustomerDto cusCustomerDto = new CusCustomerDto();
        cusCustomerDto.setId(cusCustomer.getId());
        cusCustomerDto.setName(cusCustomer.getName());
        cusCustomerDto.setSurname(cusCustomer.getSurname());
        cusCustomerDto.setEmail(cusCustomer.getEmail());
        cusCustomerDto.setPhone(cusCustomer.getPhone());
        cusCustomerDto.setIdentityNo(cusCustomer.getIdentityNo());
        cusCustomerDto.setStatusType(cusCustomer.getStatusType());
        return cusCustomerDto;
    }
}
