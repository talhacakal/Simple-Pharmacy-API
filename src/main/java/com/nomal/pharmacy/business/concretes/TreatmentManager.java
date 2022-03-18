package com.nomal.pharmacy.business.concretes;

import com.nomal.pharmacy.business.abstracts.TreatmentService;
import com.nomal.pharmacy.dataAccess.TreatmentDao;
import com.nomal.pharmacy.entities.concretes.Treatment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreatmentManager implements TreatmentService {

    private TreatmentDao treatmentDao;

    @Autowired
    public TreatmentManager(TreatmentDao treatmentDao) {
        this.treatmentDao = treatmentDao;
    }


    @Override
    public List<Treatment> getTreatmentMedicinesByPrescription(String prescriptionNum) {
        return this.treatmentDao.getTreatmentByPrescriptionNum(prescriptionNum);
    }
}
