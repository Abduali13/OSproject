package com.company.osproject.controller;

import com.company.osproject.dto.AddressDto;
import com.company.osproject.dto.ResponseDto;
import com.company.osproject.service.AddressService;
import com.company.osproject.util.SimpleRequestCrud;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.company.osproject.constants.SwaggerConstants.*;
import static com.company.osproject.constants.SwaggerConstants.EXAMPLE_CUSTOMER_INTERNAL_SERVER_ERROR;
import static com.company.osproject.dto.SimpleResponseDto.convertStatusByData;

@RestController
@RequestMapping(value = "address")
@RequiredArgsConstructor
public class AddressController implements SimpleRequestCrud<AddressDto, Integer> {

    private final AddressService addressService;
    @Override
    @PostMapping
    @ApiResponses(
            value = {
                    @ApiResponse(
                            description = "Users API Success Post Method",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_ADDRESS_SUCCESS)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Bad Request Post Method",
                            responseCode = "400",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_ADDRESS_BAD_REQUEST)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Not Found Post Method",
                            responseCode = "404",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_ADDRESS_NOT_FOUND)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Internal Server Error Post Method",
                            responseCode = "500",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_ADDRESS_INTERNAL_SERVER_ERROR)
                            )
                    )
            }
    )
    public ResponseEntity<ResponseDto<AddressDto>> createEntity(@RequestBody AddressDto entity) {
        return convertStatusByData(this.addressService.createEntity(entity));
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
                                    examples = @ExampleObject(value = EXAMPLE_ADDRESS_SUCCESS)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Bad Request Get Method",
                            responseCode = "400",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_ADDRESS_BAD_REQUEST)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Not Found Get Method",
                            responseCode = "404",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_ADDRESS_NOT_FOUND)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Internal Server Error Get Method",
                            responseCode = "500",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_ADDRESS_INTERNAL_SERVER_ERROR)
                            )
                    )
            }
    )
    public ResponseEntity<ResponseDto<AddressDto>> getEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusByData(this.addressService.getEntity(entityId));
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
                                    examples = @ExampleObject(value = EXAMPLE_ADDRESS_SUCCESS)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Bad Request Update Method",
                            responseCode = "400",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_ADDRESS_BAD_REQUEST)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Not Found Update Method",
                            responseCode = "404",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_ADDRESS_NOT_FOUND)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Internal Server Error Update Method",
                            responseCode = "500",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_ADDRESS_INTERNAL_SERVER_ERROR)
                            )
                    )
            }
    )
    public ResponseEntity<ResponseDto<AddressDto>> updateEntity(@RequestParam(value = "id") Integer entityId, @RequestBody AddressDto entity) {
        return convertStatusByData(this.addressService.updateEntity(entityId, entity));
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
                                    examples = @ExampleObject(value = EXAMPLE_ADDRESS_SUCCESS)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Bad Request Delete Method",
                            responseCode = "400",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_ADDRESS_BAD_REQUEST)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Not Found Delete Method",
                            responseCode = "404",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_ADDRESS_NOT_FOUND)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Internal Server Error Delete Method",
                            responseCode = "500",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_ADDRESS_INTERNAL_SERVER_ERROR)
                            )
                    )
            }
    )
    public ResponseEntity<ResponseDto<AddressDto>> deleteEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusByData(this.addressService.deleteEntity(entityId));
    }
}
