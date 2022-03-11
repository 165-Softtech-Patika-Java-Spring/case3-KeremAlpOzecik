package com.example.demo.cus.controller;


import com.example.demo.cus.dto.CusCustomerDeleteRequestDto;
import com.example.demo.cus.dto.CusCustomerDto;
import com.example.demo.cus.dto.CusCustomerSaveRequestDto;
import com.example.demo.cus.dto.CusCustomerUpdateRequestDto;
import com.example.demo.cus.entity.CusCustomer;
import com.example.demo.cus.service.CusCustomerService;
import com.example.demo.gen.dto.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CusCustomerController {

    private final CusCustomerService cusCustomerService;

    @GetMapping
    public ResponseEntity findAll(){

        List<CusCustomerDto> cusCustomerDtoList = cusCustomerService.findAll();

        return ResponseEntity.ok(RestResponse.of(cusCustomerDtoList));
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){

        CusCustomerDto cusCustomerDto = cusCustomerService.findById(id);

        return ResponseEntity.ok(RestResponse.of(cusCustomerDto));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody CusCustomerSaveRequestDto cusCustomerSaveRequestDto){

        CusCustomerDto cusCustomerDto = cusCustomerService.save(cusCustomerSaveRequestDto);

        return ResponseEntity.ok(RestResponse.of(cusCustomerDto));
    }

    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestBody CusCustomerDeleteRequestDto deleteRequestDto){

     cusCustomerService.delete(deleteRequestDto);

        return ResponseEntity.ok(RestResponse.empty());
    }

    @PutMapping
    public ResponseEntity update(@RequestBody CusCustomerUpdateRequestDto cusCustomerUpdateRequestDto){

        CusCustomerDto cusCustomerDto = cusCustomerService.update(cusCustomerUpdateRequestDto);

        return ResponseEntity.ok(RestResponse.of(cusCustomerDto));
    }
}
