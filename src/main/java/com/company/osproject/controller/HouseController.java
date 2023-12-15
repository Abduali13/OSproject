package com.company.osproject.controller;

import com.company.osproject.dto.HouseDto;
import com.company.osproject.dto.ResponseDto;
import com.company.osproject.entity.enums.Status;
import com.company.osproject.entity.enums.Types;
import com.company.osproject.service.HouseService;
import com.company.osproject.util.SimpleRequestCrud;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static com.company.osproject.constants.SwaggerConstants.*;
import static com.company.osproject.dto.SimpleResponseDto.convertStatusByData;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "house")
public class HouseController implements SimpleRequestCrud<HouseDto, Integer> {

    private final HouseService houseService;

    @Override
    @PostMapping
    @ApiResponses(
            value = {
                    @ApiResponse(
                            description = "Users API Success Post Method",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_HOUSE_SUCCESS)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Bad Request Post Method",
                            responseCode = "400",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_HOUSE_BAD_REQUEST)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Not Found Post Method",
                            responseCode = "404",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_HOUSE_NOT_FOUND)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Internal Server Error Post Method",
                            responseCode = "500",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_HOUSE_INTERNAL_SERVER_ERROR)
                            )
                    )
            }
    )
    public ResponseEntity<ResponseDto<HouseDto>> createEntity(@RequestBody HouseDto dto) {
        return convertStatusByData(this.houseService.createEntity(dto));
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
                                    examples = @ExampleObject(value = EXAMPLE_HOUSE_SUCCESS)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Bad Request Get Method",
                            responseCode = "400",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_HOUSE_BAD_REQUEST)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Not Found Get Method",
                            responseCode = "404",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_HOUSE_NOT_FOUND)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Internal Server Error Get Method",
                            responseCode = "500",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_HOUSE_INTERNAL_SERVER_ERROR)
                            )
                    )
            }
    )
    public ResponseEntity<ResponseDto<HouseDto>> getEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusByData(this.houseService.getEntity(entityId));
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
                                    examples = @ExampleObject(value = EXAMPLE_HOUSE_SUCCESS)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Bad Request Update Method",
                            responseCode = "400",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_HOUSE_BAD_REQUEST)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Not Found Update Method",
                            responseCode = "404",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_HOUSE_NOT_FOUND)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Internal Server Error Update Method",
                            responseCode = "500",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_HOUSE_INTERNAL_SERVER_ERROR)
                            )
                    )
            }
    )
    public ResponseEntity<ResponseDto<HouseDto>> updateEntity(Integer entityId,@RequestBody HouseDto dto) {
        return convertStatusByData(this.houseService.updateEntity(entityId, dto));
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
                                    examples = @ExampleObject(value = EXAMPLE_HOUSE_SUCCESS)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Bad Request Delete Method",
                            responseCode = "400",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_HOUSE_BAD_REQUEST)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Not Found Delete Method",
                            responseCode = "404",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_HOUSE_NOT_FOUND)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Internal Server Error Delete Method",
                            responseCode = "500",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_HOUSE_INTERNAL_SERVER_ERROR)
                            )
                    )
            }
    )
    public ResponseEntity<ResponseDto<HouseDto>> deleteEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusByData(this.houseService.deleteEntity(entityId));
    }

    @ApiResponses(
            value = {
                    @ApiResponse(
                            description = "Users API Success Get Method",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_HOUSE_SUCCESS)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Bad Request Get Method",
                            responseCode = "400",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_HOUSE_BAD_REQUEST)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Not Found Get Method",
                            responseCode = "404",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_HOUSE_NOT_FOUND)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Internal Server Error Get Method",
                            responseCode = "500",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_HOUSE_INTERNAL_SERVER_ERROR)
                            )
                    )
            }
    )
    @GetMapping(value = "/get-all-apartments")
    public ResponseEntity<ResponseDto<HouseDto>> getAllApartments(){
        return convertStatusByData(this.houseService.getAllApartments());
    }

    @ApiResponses(
            value = {
                    @ApiResponse(
                            description = "Users API Success Get Method",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_HOUSE_SUCCESS)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Bad Request Get Method",
                            responseCode = "400",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_HOUSE_BAD_REQUEST)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Not Found Get Method",
                            responseCode = "404",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_HOUSE_NOT_FOUND)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Internal Server Error Get Method",
                            responseCode = "500",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_HOUSE_INTERNAL_SERVER_ERROR)
                            )
                    )
            }
    )
    @GetMapping(value = "/get-all-flats")
    public ResponseEntity<ResponseDto<HouseDto>> getAllFlats(){
        return convertStatusByData(this.houseService.getAllFlats());
    }


    @ApiResponses(
            value = {
                    @ApiResponse(
                            description = "Users API Success Get Method",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_HOUSE_SUCCESS)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Bad Request Get Method",
                            responseCode = "400",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_HOUSE_BAD_REQUEST)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Not Found Get Method",
                            responseCode = "404",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_HOUSE_NOT_FOUND)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Internal Server Error Get Method",
                            responseCode = "500",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_HOUSE_INTERNAL_SERVER_ERROR)
                            )
                    )
            }
    )
    @GetMapping(value = "/get-all-houses")
    public ResponseEntity<ResponseDto<HouseDto>> getAllHouses(){
        return convertStatusByData(this.houseService.getAllHouses());
    }


    @ApiResponses(
            value = {
                    @ApiResponse(
                            description = "Users API Success Get Method",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_HOUSE_SUCCESS)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Bad Request Get Method",
                            responseCode = "400",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_HOUSE_BAD_REQUEST)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Not Found Get Method",
                            responseCode = "404",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_HOUSE_NOT_FOUND)
                            )
                    ),
                    @ApiResponse(
                            description = "Users API Internal Server Error Get Method",
                            responseCode = "500",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = EXAMPLE_HOUSE_INTERNAL_SERVER_ERROR)
                            )
                    )
            }
    )
    @GetMapping(value = "/get-house-with-params")
    public ResponseEntity<ResponseDto<Page<HouseDto>>> getHousesWithParams(@RequestParam Map<String, String> params, Types types, Status status){
        return convertStatusByData(this.houseService.getHousesWithParams(params, types, status));
    }
}
