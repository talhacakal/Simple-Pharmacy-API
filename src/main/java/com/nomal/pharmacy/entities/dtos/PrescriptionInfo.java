package com.nomal.pharmacy.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionInfo {

    private String tc;
    private String fullName;
    private String birth;
    private String prescriptionNum;
    private String prescriptionDate;
    private String status;

}
