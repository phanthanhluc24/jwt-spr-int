package com.example.final_academy.repository.Impl;

import com.example.final_academy.modal.TypeService;
import com.example.final_academy.repository.IServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TypeServiceRepository {
    @Autowired
    IServiceRepository iServiceRepository;

    public TypeService save(TypeService service) {
        Optional<TypeService> isExitService = iServiceRepository.findByService(service.getService());
        if (isExitService.isPresent()){
            throw new IllegalArgumentException("service is exit");
        }

        TypeService services = new TypeService();
        services.setService(service.getService());
        return iServiceRepository.save(services);
    }

    public List<TypeService> getService(){
        return iServiceRepository.findAll();
    }
}
