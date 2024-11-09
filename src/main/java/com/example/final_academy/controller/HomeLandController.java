package com.example.final_academy.controller;

import com.example.final_academy.dto.ApiResponse;
import com.example.final_academy.dto.homeLand.BillHomeLandResponse;
import com.example.final_academy.dto.homeLand.CreateAndUpdateBillHomeLandRequest;
import com.example.final_academy.dto.homeLand.HomeLandRequest;
import com.example.final_academy.dto.homeLand.HomeLandResponse;
import com.example.final_academy.mapper.IHomeLandMapper;
import com.example.final_academy.modal.HomeLand;
import com.example.final_academy.service.IHomeLandService;
import com.example.final_academy.util.JsonResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home-land")
@AllArgsConstructor
public class HomeLandController {
    @Autowired
    IHomeLandService iHomeLandService;

    @Autowired
    IHomeLandMapper iHomeLandMapper;

    @PostMapping
    public ResponseEntity<ApiResponse<HomeLandResponse>> save(@RequestBody HomeLandRequest req) {
        HomeLand homeLand = iHomeLandMapper.homeLandRequestToHomeLand(req);
        iHomeLandService.save(homeLand);
        return JsonResponse.create(iHomeLandMapper.homeLandToHomeLandResponse(homeLand));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<BillHomeLandResponse>>> findAllBillHomeLand(){
        List<HomeLand> homeLands = iHomeLandService.findAllBillHomeLand();
        List<BillHomeLandResponse> responses = iHomeLandMapper.homeLandListToBillHomeLandResponseList(homeLands);
        return JsonResponse.ok(responses);
    }

    @PostMapping("/create-bill")
    public ResponseEntity<ApiResponse<HomeLandResponse>> saveBillHomeLand(@RequestBody CreateAndUpdateBillHomeLandRequest req,
                                                                          @RequestParam(name = "id",defaultValue = "0", required = false) Long id){
        HomeLand homeLand = iHomeLandService.saveBillHomeLand(req,id);
        return JsonResponse.create(iHomeLandMapper.homeLandToHomeLandResponse(homeLand));
    }

    @GetMapping("/detail")
    public  ResponseEntity<ApiResponse<BillHomeLandResponse>> findHomeLandDetailById(@RequestParam(name = "id") Long id) {
        HomeLand homeLand = iHomeLandService.findHomeLandDetailById(id);
        BillHomeLandResponse res = iHomeLandMapper.homeLandToBillHomeLandResponse(homeLand);
        return JsonResponse.ok(res);
    }

}
