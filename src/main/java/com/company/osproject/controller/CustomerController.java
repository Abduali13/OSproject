package com.company.osproject.controller;

import com.company.osproject.dto.CustomerDto;
import com.company.osproject.dto.ResponseDto;
import com.company.osproject.entity.enums.CustomerRoles;
import com.company.osproject.service.CustomerService;
import com.company.osproject.util.SimpleRequestCrud;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.Map;

import static com.company.osproject.constants.SwaggerConstants.*;
import static com.company.osproject.constants.SwaggerConstants.EXAMPLE_HOUSE_INTERNAL_SERVER_ERROR;
import static com.company.osproject.dto.SimpleResponseDto.convertStatusByData;

@RestController
@RequestMapping(value = "customer")
@RequiredArgsConstructor
public class CustomerController implements SimpleRequestCrud<CustomerDto, Integer> {

    private final CustomerService customerService;
    @Override
    @PostMapping
    @ApiResponses(
            value = {
                    @ApiResponse(
                            description = "Users API Success Post Method",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_CUSTOMER_SUCCESS)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Bad Request Post Method",
                            responseCode = "400",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_CUSTOMER_BAD_REQUEST)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Not Found Post Method",
                            responseCode = "404",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_CUSTOMER_NOT_FOUND)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Internal Server Error Post Method",
                            responseCode = "500",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_CUSTOMER_INTERNAL_SERVER_ERROR)
                            )
                    )
            }
    )
    public ResponseEntity<ResponseDto<CustomerDto>> createEntity(@RequestBody CustomerDto entity) {
        return convertStatusByData(this.customerService.createEntity(entity));
    }

    @Override
    @GetMapping
    @ApiResponses(
            value = {
                    @ApiResponse(
                            description = "Users API Success Get Method",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_CUSTOMER_SUCCESS)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Bad Request Get Method",
                            responseCode = "400",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_CUSTOMER_BAD_REQUEST)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Not Found Get Method",
                            responseCode = "404",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_CUSTOMER_NOT_FOUND)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Internal Server Error Get Method",
                            responseCode = "500",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_CUSTOMER_INTERNAL_SERVER_ERROR)
                            )
                    )
            }
    )
    public ResponseEntity<ResponseDto<CustomerDto>> getEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusByData(this.customerService.getEntity(entityId));
    }

    @Override
    @PutMapping
    @ApiResponses(
            value = {
                    @ApiResponse(
                            description = "Users API Success Update Method",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_CUSTOMER_SUCCESS)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Bad Request Update Method",
                            responseCode = "400",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_CUSTOMER_BAD_REQUEST)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Not Found Update Method",
                            responseCode = "404",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_CUSTOMER_NOT_FOUND)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Internal Server Error Update Method",
                            responseCode = "500",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_CUSTOMER_INTERNAL_SERVER_ERROR)
                            )
                    )
            }
    )
    public ResponseEntity<ResponseDto<CustomerDto>> updateEntity(@RequestParam(value = "id") Integer entityId, @RequestBody CustomerDto entity) {
        return convertStatusByData(this.customerService.updateEntity(entityId, entity));
    }

    @Override
    @DeleteMapping
    @ApiResponses(
            value = {
                    @ApiResponse(
                            description = "Users API Success Delete Method",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_CUSTOMER_SUCCESS)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Bad Request Delete Method",
                            responseCode = "400",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_CUSTOMER_BAD_REQUEST)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Not Found Delete Method",
                            responseCode = "404",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_CUSTOMER_NOT_FOUND)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Internal Server Error Delete Method",
                            responseCode = "500",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_CUSTOMER_INTERNAL_SERVER_ERROR)
                            )
                    )
            }
    )
    public ResponseEntity<ResponseDto<CustomerDto>> deleteEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusByData(this.customerService.deleteEntity(entityId));
    }

    @ApiResponses(
            value = {
                    @ApiResponse(
                            description = "Users API Success Get Method",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_CUSTOMER_SUCCESS)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Bad Request Get Method",
                            responseCode = "400",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_CUSTOMER_BAD_REQUEST)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Not Found Get Method",
                            responseCode = "404",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_CUSTOMER_NOT_FOUND)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Internal Server Error Get Method",
                            responseCode = "500",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_CUSTOMER_INTERNAL_SERVER_ERROR)
                            )
                    )
            }
    )
    @GetMapping(value = "/get-customer-with-param")
    public ResponseDto<Page<CustomerDto>> getCustomersWithParams(
            @RequestParam Map<String, String> params,
            @RequestParam CustomerRoles customerRoles){
        return this.customerService.getCustomersWithParams(params, customerRoles);
    }
}
