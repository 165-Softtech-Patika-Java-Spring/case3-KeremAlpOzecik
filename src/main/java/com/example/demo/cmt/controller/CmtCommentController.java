package com.example.demo.cmt.controller;

import com.example.demo.cmt.dto.CmtCommentDto;
import com.example.demo.cmt.dto.CmtCustomerCommentsDto;
import com.example.demo.cmt.dto.CmtProductsCommentDto;
import com.example.demo.cmt.dto.CmtSaveRequestDto;
import com.example.demo.cmt.entity.CmtComment;
import com.example.demo.cmt.service.CmtCommentService;
import com.example.demo.cus.dto.CusCustomerDeleteRequestDto;
import com.example.demo.cus.dto.CusCustomerDto;
import com.example.demo.cus.dto.CusCustomerSaveRequestDto;
import com.example.demo.gen.dto.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comment")
@RequiredArgsConstructor
public class CmtCommentController {
    private final CmtCommentService cmtCommentService;
    @GetMapping("/customer/{id}")
    public ResponseEntity findByCustomer(@PathVariable Long id){

        List<CmtCustomerCommentsDto> cmtCommentDto = cmtCommentService.findCustomerComments(id);

        return ResponseEntity.ok(RestResponse.of(cmtCommentDto));
    }

    @GetMapping("/product/{id}")
    public ResponseEntity findByProduct(@PathVariable Long id){

        List<CmtProductsCommentDto> cmtCustomerCommentsDtoList = cmtCommentService.findProductComments(id);

        return ResponseEntity.ok(RestResponse.of(cmtCustomerCommentsDtoList));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody CmtSaveRequestDto cmtSaveRequestDto){

        CmtCommentDto cmtCommentDto = cmtCommentService.save(cmtSaveRequestDto);

        return ResponseEntity.ok(RestResponse.of(cmtCommentDto));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        cmtCommentService.delete(id);

        return ResponseEntity.ok(RestResponse.empty());
    }


}
