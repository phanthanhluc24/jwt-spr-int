package com.example.final_academy.repository.Impl;

import com.example.final_academy.dto.homeLand.CreateAndUpdateBillHomeLandRequest;
import com.example.final_academy.exception.ApiException;
import com.example.final_academy.exception.ErrorCode;
import com.example.final_academy.modal.HomeLand;
import com.example.final_academy.modal.TypeService;
import com.example.final_academy.modal.User;
import com.example.final_academy.repository.IHomeLandRepository;
import com.example.final_academy.repository.IServiceRepository;
import com.example.final_academy.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class HomeLandRepository {
    @Autowired
    IHomeLandRepository iHomeLandRepository;

    @Autowired
    IUserRepository iUserRepository;

    @Autowired
    IServiceRepository iServiceRepository;

    public HomeLand save(HomeLand req) {
        User user = iUserRepository.findById(req.getUser().getId())
                .orElseThrow(() -> new ApiException(ErrorCode.USER_NOT_FOUND));

        TypeService service = iServiceRepository.findById(req.getService().getId())
                .orElseThrow(() -> new ApiException(ErrorCode.SERVICE_NOT_FOUND));

        HomeLand homeLand = new HomeLand();
        homeLand.setPrice(req.getPrice());
        homeLand.setSpaceLand(req.getSpaceLand());
        homeLand.setUser(user);
        homeLand.setService(service);

        return iHomeLandRepository.save(homeLand);
    }

    public HomeLand saveBillHomeLand(CreateAndUpdateBillHomeLandRequest req, Long id) {
        HomeLand homeLand = iHomeLandRepository.findById(id)
                .orElse(new HomeLand()); // Create a new HomeLand if not found

        homeLand.setPrice(req.getPrice());
        homeLand.setSpaceLand(req.getSpaceLand());


        User user = iUserRepository.findByEmail(req.getEmail())
                .map(s -> {
                    s.setFullName(req.getFullName());
                    s.setPhone(Integer.valueOf(req.getPhone()));
                    return iUserRepository.save(s);
                })
                .orElseGet(() -> {
                    User newUser = new User();
                    newUser.setFullName(req.getFullName());
                    newUser.setPhone(Integer.valueOf(req.getPhone()));
                    newUser.setEmail(req.getEmail());
                    return iUserRepository.save(newUser);
                });

        TypeService service = iServiceRepository.findById(req.getServiceId())
                .orElseThrow(() -> new ApiException(ErrorCode.SERVICE_NOT_FOUND));

        homeLand.setService(service);
        homeLand.setUser(user);

        return iHomeLandRepository.save(homeLand);
    }

    public HomeLand findHomeLandDetailById(Long id) {
        HomeLand homeLand = iHomeLandRepository.findById(id)
                .orElseThrow(() -> new ApiException(ErrorCode.HOME_LAND_NOT_FOUND));
        return iHomeLandRepository.findHomeLandDetailById(homeLand.getId());
    }
}
