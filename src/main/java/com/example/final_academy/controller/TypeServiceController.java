package com.example.final_academy.controller;

import com.example.final_academy.dto.ApiResponse;
import com.example.final_academy.dto.service.TypeServiceRequest;
import com.example.final_academy.dto.service.TypeServiceResponse;
import com.example.final_academy.mapper.ITypeServiceMapper;
import com.example.final_academy.modal.TypeService;
import com.example.final_academy.service.IServiceService;
import com.example.final_academy.util.JsonResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service")
@AllArgsConstructor
public class TypeServiceController {
    @Autowired
    IServiceService typeServiceService;

    @Autowired
    ITypeServiceMapper iTypeServiceMapper;

    @PostMapping
    public ResponseEntity<ApiResponse<TypeServiceResponse>> save(@RequestBody TypeServiceRequest service){
        TypeService typeService = iTypeServiceMapper.typeServiceRequestToTypeService(service);
        typeServiceService.save(typeService);
        return JsonResponse.create(iTypeServiceMapper.typeServiceToTypeServiceResponse(typeService));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<TypeServiceResponse>>> getService() {
        List<TypeService> typeServices = typeServiceService.getService();
        List<TypeServiceResponse> responses = iTypeServiceMapper.typeServiceToTypeServiceResponseList(typeServices);
        return JsonResponse.ok(responses);
    }
}
