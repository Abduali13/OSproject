package com.company.osproject.controller;

import com.company.osproject.dto.HouseDto;
import com.company.osproject.dto.ResponseDto;
import com.company.osproject.service.HouseService;
import com.company.osproject.util.SimpleRequestCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static com.company.osproject.dto.SimpleResponseDto.convertStatusByData;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "house")
public class HouseController implements SimpleRequestCrud<HouseDto, Integer> {

    private final HouseService houseService;

    @Override
    @PostMapping
    public ResponseEntity<ResponseDto<HouseDto>> createEntity(@RequestBody HouseDto dto) {
        return convertStatusByData(this.houseService.createEntity(dto));
    }

    @Override
    @GetMapping
    public ResponseEntity<ResponseDto<HouseDto>> getEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusByData(this.houseService.getEntity(entityId));
    }

    @Override
    @PutMapping
    public ResponseEntity<ResponseDto<HouseDto>> updateEntity(Integer entityId,@RequestBody HouseDto dto) {
        return convertStatusByData(this.houseService.updateEntity(entityId, dto));
    }

    @Override
    @DeleteMapping
    public ResponseEntity<ResponseDto<HouseDto>> deleteEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusByData(this.houseService.deleteEntity(entityId));
    }

    @GetMapping(value = "/get-all-apartments")
    public ResponseEntity<ResponseDto<HouseDto>> getAllApartments(){
        return convertStatusByData(this.houseService.getAllApartments());
    }

    @GetMapping(value = "/get-all-flats")
    public ResponseEntity<ResponseDto<HouseDto>> getAllFlats(){
        return convertStatusByData(this.houseService.getAllFlats());
    }

    @GetMapping(value = "/get-all-houses")
    public ResponseEntity<ResponseDto<HouseDto>> getAllHouses(){
        return convertStatusByData(this.houseService.getAllHouses());
    }

    @GetMapping(value = "/get-house-with-params")
    public ResponseEntity<ResponseDto<Page<HouseDto>>> getHousesWithParams(@RequestParam Map<String, String> params){
        return convertStatusByData(this.houseService.getHousesWithParams(params));
    }
}
