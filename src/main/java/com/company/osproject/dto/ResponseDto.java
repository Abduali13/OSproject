package com.company.osproject.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto <T> {

    private boolean success;
    private int code;
    private String message;
    private T content;
}
