package com.nomal.pharmacy.business.abstracts;

import com.nomal.pharmacy.entities.dtos.PrescriptionInfo;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Validated
public interface PrescriptionService {

    PrescriptionInfo getPrescriptionByPrescriptionNum(
            @Size(max = 8, min = 7, message = "Prescription length must be between 7 and 8")
            @NotBlank(message = "Prescription can not be blank") String prescriptionNum); //fetch person information from prescription

    void sale(@Size(max = 8, min = 7, message = "Prescription length must be between 7 and 8")
              @NotBlank(message = "Prescription can not be blank") String prescriptionNum,
              @Min(value = 1, message = "StoreId must be greater than 0.") int storeId); //sale process. set prescription as sold and decrease stock quantity

}
