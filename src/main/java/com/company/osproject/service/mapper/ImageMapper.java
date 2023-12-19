package com.company.osproject.service.mapper;

import com.company.osproject.dto.ImageDto;
import com.company.osproject.entity.Image;
import org.springframework.stereotype.Component;

@Component
public class ImageMapper {

    public ImageDto toDto(Image image){
        return ImageDto.builder()
                .ext(image.getExt())
                .path(image.getPath())
                .imageId(image.getImageId())
                .contentType(image.getContentType())
                .imageName(image.getImageName())
                .createdAt(image.getCreatedAt())
                .deletedAt(image.getDeletedAt()).build();
    }

    public Image toEntity(ImageDto image){
        return null;
    }
}
