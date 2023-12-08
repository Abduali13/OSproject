package com.company.osproject.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImageDto {

    private Integer imageId;
    private String imageName;
    private String ext;
    private String path;
    private String contentType;
    private byte[] content;

    private HouseDto house;

    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;
}
