package com.example.final_academy.service;

import com.example.final_academy.dto.homeLand.CreateAndUpdateBillHomeLandRequest;
import com.example.final_academy.modal.HomeLand;

import java.util.List;

public interface IHomeLandService {
    HomeLand save(HomeLand req);

    List<HomeLand> findAllBillHomeLand();

    HomeLand saveBillHomeLand(CreateAndUpdateBillHomeLandRequest req, Long id);

    HomeLand findHomeLandDetailById(Long id);
}
