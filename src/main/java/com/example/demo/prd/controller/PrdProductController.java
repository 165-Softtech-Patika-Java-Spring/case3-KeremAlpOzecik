package com.example.demo.prd.controller;

import com.example.demo.cus.dto.CusCustomerDto;
import com.example.demo.cus.dto.CusCustomerSaveRequestDto;
import com.example.demo.cus.dto.CusCustomerUpdateRequestDto;
import com.example.demo.cus.service.CusCustomerService;
import com.example.demo.gen.dto.RestResponse;
import com.example.demo.prd.dto.PrdProductDto;
import com.example.demo.prd.dto.PrdProductSaveRequestDto;
import com.example.demo.prd.dto.PrdProductUpdate;
import com.example.demo.prd.service.PrdProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class PrdProductController {

    private final PrdProductService prdProductService;

    @GetMapping
    public ResponseEntity findAll(){

        List<PrdProductDto> prdProductDtoList = prdProductService.findAll();

        return ResponseEntity.ok(RestResponse.of(prdProductDtoList));
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){

        PrdProductDto prdProductDto = prdProductService.findById(id);

        return ResponseEntity.ok(RestResponse.of(prdProductDto));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody PrdProductSaveRequestDto prdProductSaveRequestDto){

        PrdProductDto prdProductDto = prdProductService.save(prdProductSaveRequestDto);

        return ResponseEntity.ok(RestResponse.of(prdProductDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        prdProductService.delete(id);

        return ResponseEntity.ok(RestResponse.empty());
    }

    @PutMapping
    public ResponseEntity update(@RequestBody PrdProductUpdate prdProductUpdate) {

        PrdProductDto prdProductDto = prdProductService.update(prdProductUpdate);

        return ResponseEntity.ok(RestResponse.of(prdProductDto));
    }}
