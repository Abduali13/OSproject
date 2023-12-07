package com.company.osproject.util;

import com.company.osproject.dto.ResponseDto;

public interface SimpleCrud<V, K>{

    ResponseDto<V> createEntity(V entity);
    ResponseDto<V> getEntity(K entityId);
    ResponseDto<V> updateEntity(K entityId, V entity);
    ResponseDto<V> deleteEntity(K entityId);
}
