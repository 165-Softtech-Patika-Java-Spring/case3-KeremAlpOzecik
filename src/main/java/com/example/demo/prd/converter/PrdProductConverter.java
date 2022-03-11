package com.example.demo.prd.converter;

import com.example.demo.cus.dto.CusCustomerDto;
import com.example.demo.cus.entity.CusCustomer;
import com.example.demo.prd.dto.PrdProductDto;
import com.example.demo.prd.entity.PrdProduct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PrdProductConverter {

    public List<PrdProductDto> convertToPrdProductDtoList(List<PrdProduct> prdProductList) {

        List<PrdProductDto> prdProductDtoList = new ArrayList<>();
        for (PrdProduct prdProduct : prdProductList) {

            PrdProductDto prdProductDto = convertToPrdProductDto(prdProduct);

            prdProductDtoList.add(prdProductDto);
        }

        return prdProductDtoList;
    }

    public PrdProductDto convertToPrdProductDto(PrdProduct prdProduct) {
        PrdProductDto prdProductDto = new PrdProductDto();
        prdProductDto.setId(prdProduct.getId());
        prdProductDto.setName(prdProduct.getName());
        prdProductDto.setPrice(prdProduct.getPrice());
        return prdProductDto;

    }
}
