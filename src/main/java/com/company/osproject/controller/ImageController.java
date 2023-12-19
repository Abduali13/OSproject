package com.company.osproject.controller;

import com.company.osproject.dto.ImageDto;
import com.company.osproject.dto.ResponseDto;
import com.company.osproject.service.ImageService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileDescriptor;

@RestController
@RequestMapping(value = "file")
@RequiredArgsConstructor
public class ImageController {


    private final ImageService imageService;


    @PostMapping(
            value = "/upload-file",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public ResponseDto<ImageDto> uploadFile(@RequestBody MultipartFile file){
        return this.imageService.uploadFile(file);
    }

    @GetMapping(value = "/{id}")
    public ResponseDto<ImageDto> downloadFile(@PathVariable(value = "id") Integer fileId){
        return this.imageService.downloadFile(fileId);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseDto<ImageDto> deleteFile(@PathVariable(value = "id") Integer fileId){
        return this.imageService.deleteFile(fileId);
    }

}
