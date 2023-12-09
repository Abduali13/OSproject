package com.company.osproject.controller;

import com.company.osproject.dto.HouseDto;
import com.company.osproject.dto.ResponseDto;
import com.company.osproject.service.HouseService;
import com.company.osproject.util.SimpleRequestCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.company.osproject.dto.SimpleResponseDto.convertStatusByData;

@RestController
@RequestMapping(value = "house")
@RequiredArgsConstructor
public class HouseController implements SimpleRequestCrud<HouseDto, Integer> {

    private final HouseService houseService;

    @PostMapping
    @Override
    public ResponseEntity<ResponseDto<HouseDto>> createEntity(@RequestBody HouseDto dto) {
        return convertStatusByData(this.houseService.createEntity(dto));
    }

    @GetMapping
    @Override
    public ResponseEntity<ResponseDto<HouseDto>> getEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusByData(this.houseService.getEntity(entityId));
    }

    @PutMapping
    @Override
    public ResponseEntity<ResponseDto<HouseDto>> updateEntity(Integer entityId,@RequestBody HouseDto dto) {
        return convertStatusByData(this.houseService.updateEntity(entityId, dto));
    }

    @DeleteMapping
    @Override
    public ResponseEntity<ResponseDto<HouseDto>> deleteEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusByData(this.houseService.deleteEntity(entityId));
    }
}
