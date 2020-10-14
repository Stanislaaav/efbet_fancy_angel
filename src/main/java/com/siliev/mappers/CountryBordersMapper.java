package com.siliev.mappers;

import com.siliev.dto.CountryBordersDto;
import com.siliev.entities.CountryBorders;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CountryBordersMapper extends ResourceEntityTransformer<CountryBordersDto, CountryBorders> {

}
