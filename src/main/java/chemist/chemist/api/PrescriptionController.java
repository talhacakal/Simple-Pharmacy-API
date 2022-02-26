package chemist.chemist.api;

import chemist.chemist.dataAccess.abstracts.PrescriptionDao;
import chemist.chemist.entities.concretes.Prescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/prescription")
public class PrescriptionController {

    private PrescriptionDao prescriptionDao;

    @Autowired
    public PrescriptionController(PrescriptionDao prescriptionDao) {
        this.prescriptionDao = prescriptionDao;
    }

    @RequestMapping("/getByPrescriptionNum/{prescriptionNum}")
    public Prescription getByPrescriptionNum(@PathVariable String prescriptionNum){
        return this.prescriptionDao.getPrescriptionByPrescriptionNum(prescriptionNum);
    }

}
