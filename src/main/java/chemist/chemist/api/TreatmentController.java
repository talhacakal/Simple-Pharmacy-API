package chemist.chemist.api;

import chemist.chemist.dataAccess.abstracts.TreatmentDao;
import chemist.chemist.entities.concretes.Medicine;
import chemist.chemist.entities.concretes.Treatment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/treatment")
public class TreatmentController {

    private TreatmentDao treatmentDao;

    @Autowired
    public TreatmentController(TreatmentDao treatmentDao) {
        this.treatmentDao = treatmentDao;
    }

    @RequestMapping("/prescriptionNum/{prescriptionNum}")
    public List<Treatment> getByPrescriptionNumber(@PathVariable String prescriptionNum){
        return this.treatmentDao.getTreatmentByPrescriptionNum(prescriptionNum);
    }


    @GetMapping("/setSold/{prescriptionNum}")    // set sold
    public String setSold(@PathVariable String prescriptionNum){
        this.treatmentDao.setSold(prescriptionNum);
        return "Success";
    }
}
