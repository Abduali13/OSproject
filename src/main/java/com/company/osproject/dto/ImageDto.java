package com.company.osproject.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
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
