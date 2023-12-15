package com.company.osproject.service;

import com.company.osproject.dto.HouseDto;
import com.company.osproject.dto.ResponseDto;
import com.company.osproject.entity.House;
import com.company.osproject.entity.enums.Types;
import com.company.osproject.repository.HouseRepository;
import com.company.osproject.service.mapper.HouseMapper;
import com.company.osproject.util.SimpleCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class HouseService implements SimpleCrud<HouseDto, Integer> {

    private final HouseRepository houseRepository;
    private final HouseMapper houseMapper;


    @Override
    public ResponseDto<HouseDto> createEntity(HouseDto dto) {
        try {
            House entity = this.houseMapper.toEntity(dto);
            entity.setCreatedAt(LocalDateTime.now());
            return ResponseDto.<HouseDto>builder()
                    .success(true)
                    .message("OK")
                    .content(
                            this.houseMapper.toDto(
                                    this.houseRepository.save(entity)
                            )
                    )
                    .build();
        } catch (Exception e) {
            return ResponseDto.<HouseDto>builder()
                    .code(-2)
                    .message("Error occurred while creating house")
                    .build();
        }
    }

    @Override
    public ResponseDto<HouseDto> getEntity(Integer entityId) {
        return this.houseRepository.findAllByHouseIdAndDeletedAtIsNull(entityId)
                .map(house ->
                        ResponseDto.<HouseDto>builder()
                                .success(true)
                                .message("OK")
                                .content(this.houseMapper.toDto(house))
                                .build())
                .orElse(ResponseDto.<HouseDto>builder()
                        .code(-1)
                        .message(String.format("House with this %d cannot be found", entityId))
                        .build());
    }

    @Override
    public ResponseDto<HouseDto> updateEntity(Integer entityId, HouseDto dto) {
        return this.houseRepository.findAllByHouseIdAndDeletedAtIsNull(entityId)
                .map(house -> {
                    house.setUpdatedAt(LocalDateTime.now());
                    return ResponseDto.<HouseDto>builder()
                            .success(true)
                            .message("OK")
                            .content(
                                    this.houseMapper.toDto(
                                            this.houseRepository.save(
                                                    this.houseMapper.updateHouse(house, dto)
                                            )
                                    )
                            )
                            .build();
                }).orElse(ResponseDto.<HouseDto>builder()
                        .code(-1)
                        .message(String.format("House with this %d cannot be found", entityId))
                        .build());
    }

    @Override
    public ResponseDto<HouseDto> deleteEntity(Integer entityId) {
        return this.houseRepository.findAllByHouseIdAndDeletedAtIsNull(entityId)
                .map(house -> {
                    house.setDeletedAt(LocalDateTime.now());
                    return ResponseDto.<HouseDto>builder()
                            .success(true)
                            .message("OK")
                            .content(
                                    this.houseMapper.toDto(
                                            this.houseRepository.save(house)
                                    )
                            )
                            .build();
                }).orElse(ResponseDto.<HouseDto>builder()
                        .code(-1)
                        .message(String.format("House with this %d cannot be found", entityId))
                        .build());
    }

    public ResponseDto<HouseDto> getAllApartments(){
        return this.houseRepository.findAllByDeletedAtIsNull()
                .map(house -> ResponseDto.<HouseDto>builder()
                        .success(true)
                        .message("OK")
                        .content(
                                this.houseMapper.toDto(house)
                        )
                        .build()
                ).orElse(ResponseDto.<HouseDto>builder()
                        .code(-1)
                        .message("Cannot find any apartments")
                        .build());
    }

    public ResponseDto<HouseDto> getAllFlats(){
        return this.houseRepository.findAllByTypes(Types.FLAT)
                .map(flat -> ResponseDto.<HouseDto>builder()
                        .success(true)
                        .message("OK")
                        .content(
                                this.houseMapper.toDto(flat)
                        )
                        .build()
                ).orElse(ResponseDto.<HouseDto>builder()
                        .code(-1)
                        .message("Cannot find any houses")
                        .build());

    }

    public ResponseDto<HouseDto> getAllHouses(){
        return this.houseRepository.findAllByTypes(Types.HOUSE)
                .map(house -> ResponseDto.<HouseDto>builder()
                        .success(true)
                        .message("OK")
                        .content(
                                this.houseMapper.toDto(house)
                        )
                        .build()
                ).orElse(ResponseDto.<HouseDto>builder()
                        .code(-1)
                        .message("Cannot find any houses")
                        .build());

    }

    public ResponseDto<HouseDto> getAllHousesForRent(){
        return null;
    }

    public ResponseDto<HouseDto> getAllHousesForSale(){
        return null;
    }

    public ResponseDto<HouseDto> getAllHousesByParam(){
        return null;
    }

    public ResponseDto<Page<HouseDto>> getHousesWithParams(Map<String, String> params) {
        int size = 10, page = 0;
        if (params.containsKey("size")){
            size = Integer.parseInt(params.get("size"));
        }
        if (params.containsKey("page")){
            page = Integer.parseInt(params.get("page"));
        }
        return ResponseDto.<Page<HouseDto>>builder()
                .success(true)
                .message("OK")
                .content(
                        this.houseRepository.getAllHouseWithMoreParams(
                                params.get("houseId") == null ? null : Integer.parseInt(params.get("houseId")),
                                params.get("nameOfBuilding"),
                                params.get("numberOfHouse") == null ? null : Integer.parseInt(params.get("numberOfHouse")),
                                params.get("numberOfRooms") == null ? null : Integer.parseInt(params.get("numberOfRooms")),
                                params.get("numberOfFloor") == null ? null : Integer.parseInt(params.get("numberOfFloor")),
                                params.get("numberOfBedrooms") == null ? null : Integer.parseInt(params.get("numberOfBedrooms")),
                                params.get("numberOfKitchens") == null ? null : Integer.parseInt(params.get("numberOfKitchens")),
                                params.get("numberOfBathrooms") == null ? null : Integer.parseInt(params.get("numberOfBathrooms")),
                                params.get("numberOfGarages") == null ? null : Integer.parseInt(params.get("numberOfGarages")),
                                params.get("numberOfParkingSlots") == null ? null : Integer.parseInt(params.get("numberOfParkingSlots")),
                                params.get("size") == null  ? null : Float.parseFloat( params.get("size")),
                                params.get("price") == null ? null : Long.parseLong(params.get("price")),
                                params.get("additionalInfo"),
                                params.get("description"),
                                PageRequest.of(page, size)
                        ).map(this.houseMapper::toDto)
                )
                .build();
    }
}
