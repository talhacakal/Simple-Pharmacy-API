package chemist.chemist.api;

import chemist.chemist.dataAccess.abstracts.MedicineDao;
import chemist.chemist.entities.concretes.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicine")
public class MedicineController {

    private MedicineDao medicineDao;

    @Autowired
    public MedicineController(MedicineDao medicineDao) {
        this.medicineDao = medicineDao;
    }

    @RequestMapping("/getAll")
    public List<Medicine> getAll(){
        return this.medicineDao.findAll();
    }

    @RequestMapping("/getByBarcode/{barcodeNum}")
    public Medicine getByBarcodeNumber(@PathVariable String barcodeNum){
        return this.medicineDao.getMedicineByBarcodeNum(barcodeNum);
    }

    @PostMapping("/save")
    public String add(@RequestBody Medicine medicine){
        this.medicineDao.save(medicine);
        return "Success";
    }
}
