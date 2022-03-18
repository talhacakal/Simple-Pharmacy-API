package com.nomal.pharmacy.business.concretes;

import com.nomal.pharmacy.business.abstracts.PrescriptionService;
import com.nomal.pharmacy.business.abstracts.StockService;
import com.nomal.pharmacy.business.abstracts.TreatmentService;
import com.nomal.pharmacy.core.exception.AlreadySoldException;
import com.nomal.pharmacy.core.exception.RecordNotFoundException;
import com.nomal.pharmacy.dataAccess.PrescriptionDao;
import com.nomal.pharmacy.entities.concretes.Prescription;
import com.nomal.pharmacy.entities.concretes.Treatment;
import com.nomal.pharmacy.entities.dtos.PrescriptionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PrescriptionManager implements PrescriptionService {

    private PrescriptionDao prescriptionDao;
    private TreatmentService treatmentService;
    private StockService stockService;

    @Autowired
    public PrescriptionManager(PrescriptionDao prescriptionDao, TreatmentService treatmentService, StockService stockService) {
        this.prescriptionDao = prescriptionDao;
        this.treatmentService = treatmentService;
        this.stockService = stockService;
    }


    @Override
    public PrescriptionInfo getPrescriptionByPrescriptionNum(String prescriptionNum) { //fetch person information from prescription
        PrescriptionInfo prescriptionInfo = this.prescriptionDao.getPrescriptionByPrescriptionNumber(prescriptionNum);
        if (prescriptionInfo == null){
            throw new RecordNotFoundException("Not data found");
        }
        return prescriptionInfo;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)  // to ensure atomicity
    @Override
    public void sale(String prescriptionNum, int storeId) {     //sale process
        Prescription prescription = this.prescriptionDao.getPrescriptionByPrescriptionNum(prescriptionNum);
        if (prescription == null){
            throw new RecordNotFoundException(prescriptionNum +" is invalid");
        }else if (prescription.getStatus().equals("Sold")){
            throw new AlreadySoldException(prescriptionNum + " already sold");
        }
        this.prescriptionDao.setSold(prescriptionNum);

        List<Treatment> treatments = this.treatmentService.getTreatmentMedicinesByPrescription(prescriptionNum);
        for(Treatment treatment : treatments){
            this.stockService.decreaseQuantity(storeId, treatment.getMedicineId(), treatment.getAmount());
        }


    }
}
