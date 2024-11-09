package com.example.final_academy.service.Impl;

import com.example.final_academy.modal.TypeService;
import com.example.final_academy.repository.Impl.TypeServiceRepository;
import com.example.final_academy.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TypeServiceService implements IServiceService {
    @Autowired
    TypeServiceRepository serviceRepository;

    public TypeService save( TypeService service) {
        return serviceRepository.save(service);
    }

    public List<TypeService> getService() {
        return serviceRepository.getService();
    }
}
