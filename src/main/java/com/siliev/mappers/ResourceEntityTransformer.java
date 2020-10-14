package com.siliev.mappers;


public interface ResourceEntityTransformer<R, E> {

    R transformToResource(E entity);

    E transformToEntity(R resource);

}
