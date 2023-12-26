package com.company.osproject.service.validation;


import com.company.osproject.dto.CustomerDto;
import com.company.osproject.dto.ErrorDto;
import com.company.osproject.service.HouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomerValidation {

    private final HouseService houseService;

    public List<ErrorDto> customerValid(CustomerDto dto){
        List<ErrorDto> errorList = new ArrayList<>();
        if (this.houseService.get(dto.getHouseId()).getContent() == null){
            errorList.add(new ErrorDto("houseId", String.format("Customer with this %d house id cannot be found", dto.getHouseId())));
        }
        return errorList;
    }
}
