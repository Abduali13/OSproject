package com.company.osproject.service;

import com.company.osproject.dto.ImageDto;
import com.company.osproject.dto.ResponseDto;
import com.company.osproject.entity.Image;
import com.company.osproject.repository.ImageRepository;
import com.company.osproject.service.mapper.ImageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;
    private final ImageMapper imageMapper;

    public ResponseDto<ImageDto> uploadFile(MultipartFile file) {
        try {

            if(!checkFileContent(Objects.requireNonNull(file.getOriginalFilename()).split("\\.")[0])){
                return ResponseDto.<ImageDto>builder()
                        .code(1)
                        .message(String.format("File with %s already exists", file.getOriginalFilename()))
                        .build();
            }

            return ResponseDto.<ImageDto>builder()
                    .success(true)
                    .message("OK")
                    .content(
                            this.imageMapper.toDto(
                                    this.imageRepository.save(
                                            Image.builder()
                                                    .imageName(Objects.requireNonNull(file.getOriginalFilename()).split("\\.")[0])
                                                    .ext(Objects.requireNonNull(file.getOriginalFilename()).split("\\.")[1])
                                                    .path(saveFile(file))
                                                    .contentType(file.getContentType())
                                                    .createdAt(LocalDateTime.now())
                                                    .build()
                                    )
                            )
                    )
                    .build();

        }
        catch (Exception e){
            return ResponseDto.<ImageDto>builder()
                    .code(-2)
                    .message(String.format("Error occurred while saving file; message: %s", e.getMessage()))
                    .build();
        }
    }

    public ResponseDto<ImageDto> downloadFile(Integer fileId) {
        Optional<Image> optional = this.imageRepository.findByImageIdAndDeletedAtIsNull(fileId);
        if (optional.isEmpty()) {
            return ResponseDto.<ImageDto>builder()
                    .code(-1)
                    .message(String.format("File with this %d id is not found", fileId))
                    .build();
        }
        Image image = optional.get();
        try {
            ImageDto dto = this.imageMapper.toDto(image);
            dto.setContent(Files.readAllBytes(Path.of(image.getPath())));
            return ResponseDto.<ImageDto>builder()
                    .success(true)
                    .message("OK")
                    .content(dto)
                    .build();
        }
        catch (Exception e){
            return ResponseDto.<ImageDto>builder()
                    .code(-4)
                    .message(String.format("File while reading error, %s", e.getMessage()))
                    .build();
        }


    }

    public ResponseDto<ImageDto> deleteFile(Integer imageId) {
        try {
            Optional<Image> optional = this.imageRepository.findByImageIdAndDeletedAtIsNull(imageId);
            if (optional.isEmpty()) {
                return ResponseDto.<ImageDto>builder()
                        .code(-1)
                        .message(String.format("File with this %d id is not found", imageId))
                        .build();
            }

            Image fileModel = optional.get();
            File file = new File(fileModel.getPath());
            if (file.exists()){
                file.delete();
            }
            fileModel.setDeletedAt(LocalDateTime.now());
            return ResponseDto.<ImageDto>builder()
                    .success(true)
                    .message("OK")
                    .content(
                            this.imageMapper.toDto(
                                    this.imageRepository.save(fileModel)
                            )
                    )
                    .build();
        }
        catch (Exception e){
            return ResponseDto.<ImageDto>builder()
                    .code(-4)
                    .message(String.format("File while deleting error, %s", e.getMessage()))
                    .build();
        }


    }

    private boolean checkFileContent(String imageName) {
        return this.imageRepository.findByImageNameAndDeletedAtIsNull(imageName).isEmpty();
    }
    private String saveFile(MultipartFile file) throws IOException {
        String folder = String.format("%s/%s", "upload/", LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
        File newFile = new File(folder);
        if (!newFile.exists()){
            newFile.mkdirs();
        }
        String fileName = String.format("%s/%s", folder, file.getOriginalFilename());
        Files.copy(file.getInputStream(), Path.of(fileName));
        return fileName;
    }
}
