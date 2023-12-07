package com.company.osproject.util;

import com.company.osproject.dto.ResponseDto;
import org.springframework.http.ResponseEntity;

public interface SimpleRequestCrud <V, K> {


    ResponseEntity<ResponseDto<V>> createEntity(V entity);
    ResponseEntity<ResponseDto<V>> getEntity(K entityId);
    ResponseEntity<ResponseDto<V>> updateEntity(K entityId, V entity);
    ResponseEntity<ResponseDto<V>> deleteEntity(K entityId);
}
