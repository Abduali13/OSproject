package com.company.osproject.controller;

import com.company.osproject.dto.CustomerDto;
import com.company.osproject.dto.ResponseDto;
import com.company.osproject.service.CustomerService;
import com.company.osproject.util.SimpleRequestCrud;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.company.osproject.dto.SimpleResponseDto.convertStatusByData;

@RestController
@RequestMapping(value = "customer")
@RequiredArgsConstructor
public class CustomerController implements SimpleRequestCrud<CustomerDto, Integer> {

    private final CustomerService customerService;
    @Override
    @PostMapping
    public ResponseEntity<ResponseDto<CustomerDto>> createEntity(@RequestBody CustomerDto entity) {
        return convertStatusByData(this.customerService.createEntity(entity));
    }

    @Override
    @GetMapping
    public ResponseEntity<ResponseDto<CustomerDto>> getEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusByData(this.customerService.getEntity(entityId));
    }

    @Override
    @PutMapping
    public ResponseEntity<ResponseDto<CustomerDto>> updateEntity(@RequestParam(value = "id") Integer entityId, @RequestBody CustomerDto entity) {
        return convertStatusByData(this.customerService.updateEntity(entityId, entity));
    }

    @Override
    @DeleteMapping
    public ResponseEntity<ResponseDto<CustomerDto>> deleteEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusByData(this.customerService.deleteEntity(entityId));
    }
}
