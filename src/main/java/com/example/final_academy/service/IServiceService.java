package com.example.final_academy.service;

import com.example.final_academy.modal.TypeService;

import java.util.List;

public interface IServiceService {
    TypeService save(TypeService service);

    List<TypeService> getService();
}
