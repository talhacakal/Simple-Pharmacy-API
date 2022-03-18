package com.nomal.pharmacy.api;


import com.nomal.pharmacy.business.abstracts.PrescriptionService;
import com.nomal.pharmacy.entities.dtos.PrescriptionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prescription")
@CrossOrigin
public class PrescriptionController {

    private PrescriptionService prescriptionService;

    @Autowired
    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @GetMapping("/getByPrescriptionNum")  //fetch person information from prescription
    public PrescriptionInfo getByPrescriptionNum(@RequestParam String prescriptionNum){
        return this.prescriptionService.getPrescriptionByPrescriptionNum(prescriptionNum);
    }

    @PutMapping("/sale")    //sale process. set prescription as sold and decrease stock quantity
    public void sale(@RequestParam String prescriptionNum,@RequestParam int storeId){
        this.prescriptionService.sale(prescriptionNum, storeId);
    }
}



