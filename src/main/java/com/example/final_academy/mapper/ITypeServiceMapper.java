package com.example.final_academy.mapper;

import com.example.final_academy.dto.service.TypeServiceRequest;
import com.example.final_academy.dto.service.TypeServiceResponse;
import com.example.final_academy.modal.TypeService;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ITypeServiceMapper {
    TypeService typeServiceRequestToTypeService(TypeServiceRequest req);
    TypeServiceResponse typeServiceToTypeServiceResponse(TypeService req);

    List<TypeServiceResponse> typeServiceToTypeServiceResponseList(List<TypeService> req);
}
