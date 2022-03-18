package com.nomal.pharmacy.business.abstracts;

import com.nomal.pharmacy.entities.concretes.Treatment;

import java.util.List;

public interface TreatmentService {

    List<Treatment> getTreatmentMedicinesByPrescription(String prescriptionNum);

}
