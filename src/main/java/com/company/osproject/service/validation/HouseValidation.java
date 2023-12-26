package com.company.osproject.service.validation;


import com.company.osproject.dto.ErrorDto;
import com.company.osproject.dto.HouseDto;
import com.company.osproject.repository.AddressRepository;
import com.company.osproject.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class HouseValidation {

    private final AddressService addressService;

    public List<ErrorDto> houseValid(HouseDto dto){
        List<ErrorDto> errorList = new ArrayList<>();
        if (this.addressService.get(dto.getAddressId()).getContent() == null){
            errorList.add(new ErrorDto("addressId", String.format("House with this %d address id is not found", dto.getAddressId())));
        }
        return errorList;
    }

}
