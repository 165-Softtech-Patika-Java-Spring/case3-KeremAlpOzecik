package com.example.demo.cus.service;



import com.example.demo.cus.dto.CusCustomerDeleteRequestDto;
import com.example.demo.cus.dto.CusCustomerDto;
import com.example.demo.cus.dto.CusCustomerSaveRequestDto;
import com.example.demo.cus.entity.CusCustomer;
import com.example.demo.cus.converter.CusCustomerConverter;
import com.example.demo.cus.converter.CusCustomerMapper;
import com.example.demo.cus.dto.CusCustomerUpdateRequestDto;
import com.example.demo.cus.enums.CusErrorMessage;
import com.example.demo.cus.service.entityservice.CusCustomerEntityService;
import com.example.demo.gen.exceptions.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CusCustomerService {

    private final CusCustomerEntityService cusCustomerEntityService;
    private final CusCustomerConverter cusCustomerConverter;


    public List<CusCustomerDto> findAll() {

        List<CusCustomer> cusCustomerList = cusCustomerEntityService.findAll();

        List<CusCustomerDto> cusCustomerDtoList = cusCustomerConverter.convertToCusCustomerDtoList(cusCustomerList);

        return cusCustomerDtoList;
    }

    public CusCustomerDto save(CusCustomerSaveRequestDto cusCustomerSaveRequestDto) {

        CusCustomer cusCustomer = CusCustomerMapper.INSTANCE.convertToCusCustomer(cusCustomerSaveRequestDto);
        if(cusCustomerEntityService.findByNameOrPhoneOrEmail(cusCustomerSaveRequestDto.getName(),cusCustomerSaveRequestDto.getPhone(),cusCustomerSaveRequestDto.getEmail())!=null){
            throw new RuntimeException("Customer does exist!!! you can't register");
        }
        else
        cusCustomer = cusCustomerEntityService.save(cusCustomer);

        CusCustomerDto cusCustomerDto = CusCustomerMapper.INSTANCE.convertToCusCustomerDto(cusCustomer);

        return cusCustomerDto;
    }


    public void delete(CusCustomerDeleteRequestDto cusCustomerDeleteRequestDto) {


        CusCustomer cusCustomer = CusCustomerMapper.INSTANCE.convertToCusCustomer(cusCustomerDeleteRequestDto);

        if (cusCustomerEntityService.findByNameAndPhone(cusCustomer.getName(),cusCustomer.getPhone())!=null)
        cusCustomerEntityService.delete(cusCustomerEntityService.findByNameAndPhone(cusCustomer.getName(),cusCustomer.getPhone()));
        else{
            controlIsCustomerPhoneAndNumberMatch(cusCustomerDeleteRequestDto);
        }
    }


    public CusCustomerDto findById(Long id) {

        CusCustomer cusCustomer = cusCustomerEntityService.getByIdWithControl(id);

        CusCustomerDto cusCustomerDto = CusCustomerMapper.INSTANCE.convertToCusCustomerDto(cusCustomer);

        return cusCustomerDto;
    }

    public CusCustomerDto findByName(String name) {

        CusCustomer cusCustomer =cusCustomerEntityService.findAllByName(name);

        CusCustomerDto cusCustomerDto = CusCustomerMapper.INSTANCE.convertToCusCustomerDto(cusCustomer);

        return cusCustomerDto;
    }



    public CusCustomerDto update(CusCustomerUpdateRequestDto cusCustomerUpdateRequestDto) {

        controlIsCustomerExist(cusCustomerUpdateRequestDto);

        CusCustomer cusCustomer;
        cusCustomer = CusCustomerMapper.INSTANCE.convertToCusCustomer(cusCustomerUpdateRequestDto);
        cusCustomerEntityService.save(cusCustomer);

        CusCustomerDto cusCustomerDto = cusCustomerConverter.convertToCusCustomerDto(cusCustomer);

        return cusCustomerDto;
    }

    private void controlIsCustomerExist(CusCustomerUpdateRequestDto cusCustomerUpdateRequestDto) {

        Long id = cusCustomerUpdateRequestDto.getId();
        boolean isExist = cusCustomerEntityService.existsById(id);
        if (!isExist){
            throw new ItemNotFoundException(CusErrorMessage.CUSTOMER_ERROR_MESSAGE);
        }
    }


    private void controlIsCustomerPhoneAndNumberMatch(CusCustomerDeleteRequestDto cusCustomerDeleteRequestDto) {

        String name = cusCustomerDeleteRequestDto.getName();
        String phone = cusCustomerDeleteRequestDto.getPhone();
        CusCustomer isExist = cusCustomerEntityService.findByNameAndPhone(name,phone);
        if (isExist==null){
            throw new IllegalStateException(phone+" this phone number not match with "+name);
        }
    }

}
