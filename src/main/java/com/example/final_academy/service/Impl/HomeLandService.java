package com.example.final_academy.service.Impl;

import com.example.final_academy.dto.homeLand.CreateAndUpdateBillHomeLandRequest;
import com.example.final_academy.modal.HomeLand;
import com.example.final_academy.repository.IHomeLandRepository;
import com.example.final_academy.repository.Impl.HomeLandRepository;
import com.example.final_academy.service.IHomeLandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeLandService implements IHomeLandService {
    @Autowired
    IHomeLandRepository iHomeLandRepository;

    @Autowired
    HomeLandRepository homeLandRepository;

    public HomeLand save(HomeLand req) {
        return iHomeLandRepository.save(req);
    }

    public List<HomeLand> findAllBillHomeLand(){
        return iHomeLandRepository.findAll();
    }

    public  HomeLand saveBillHomeLand(CreateAndUpdateBillHomeLandRequest req, Long id){
        return homeLandRepository.saveBillHomeLand(req, id);
    }

    public  HomeLand findHomeLandDetailById(Long id) {
        return homeLandRepository.findHomeLandDetailById(id);
    }
}
