package com.company.osproject.controller;

import com.company.osproject.dto.AddressDto;
import com.company.osproject.dto.ResponseDto;
import com.company.osproject.service.AddressService;
import com.company.osproject.util.SimpleRequestCrud;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.company.osproject.dto.SimpleResponseDto.convertStatusByData;

@RestController
@RequestMapping(value = "address")
@RequiredArgsConstructor
public class AddressController implements SimpleRequestCrud<AddressDto, Integer> {

    private final AddressService addressService;
    @Override
    @PostMapping
    public ResponseEntity<ResponseDto<AddressDto>> createEntity(@RequestBody AddressDto entity) {
        return convertStatusByData(this.addressService.createEntity(entity));
    }

    @Override
    @GetMapping
    public ResponseEntity<ResponseDto<AddressDto>> getEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusByData(this.addressService.getEntity(entityId));
    }

    @Override
    @PutMapping
    public ResponseEntity<ResponseDto<AddressDto>> updateEntity(@RequestParam(value = "id") Integer entityId, @RequestBody AddressDto entity) {
        return convertStatusByData(this.addressService.updateEntity(entityId, entity));
    }

    @Override
    @DeleteMapping
    public ResponseEntity<ResponseDto<AddressDto>> deleteEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusByData(this.addressService.deleteEntity(entityId));
    }
}
