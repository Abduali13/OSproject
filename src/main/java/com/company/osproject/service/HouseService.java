package com.company.osproject.service;

import com.company.osproject.dto.HouseDto;
import com.company.osproject.dto.ResponseDto;
import com.company.osproject.entity.House;
import com.company.osproject.repository.HouseRepository;
import com.company.osproject.service.mapper.HouseMapper;
import com.company.osproject.util.SimpleCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
}
