package com.example.final_academy.mapper;

import com.example.final_academy.dto.homeLand.BillHomeLandResponse;
import com.example.final_academy.dto.homeLand.HomeLandRequest;
import com.example.final_academy.dto.homeLand.HomeLandResponse;
import com.example.final_academy.modal.HomeLand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IHomeLandMapper {
    @Mappings({
            @Mapping(source = "user.id",target = "userId"),
            @Mapping(source = "service.id",target = "serviceId")
    })
    HomeLandResponse homeLandToHomeLandResponse(HomeLand homeLand);

    @Mappings({
            @Mapping(source = "userId",target = "user.id"),
            @Mapping(source = "serviceId",target = "service.id")
    })
    HomeLand homeLandRequestToHomeLand(HomeLandRequest req);

    @Mappings({
            @Mapping(source = "user.fullName", target = "fullName"),
            @Mapping(source = "user.phone",target = "phone"),
            @Mapping(source = "user.email",target = "email"),
            @Mapping(source = "service.service", target = "service"),
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "createdAt", target = "createdAt", dateFormat = "dd/MM/yyyy"),
    })
    BillHomeLandResponse homeLandToBillHomeLandResponse(HomeLand homeLand);

    List<BillHomeLandResponse> homeLandListToBillHomeLandResponseList(List<HomeLand> homeLand);


}
