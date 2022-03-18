package com.nomal.pharmacy.api;

import com.nomal.pharmacy.business.abstracts.MedicineService;
import com.nomal.pharmacy.entities.concretes.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/medicine")
@CrossOrigin
public class MedicineController {

    private MedicineService medicineService;

    @Autowired
    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @RequestMapping("/getAll")
    public List<Medicine> getAll(){
        return medicineService.getAll();
    }

    @GetMapping("/getMedicineByStoreAndCategory")   //fetch medicines by category and pharmacy
    List<Medicine> getMedicineByStoreAndCategory(@RequestParam int storeId, @RequestParam int categoryId) {
        return this.medicineService.getMedicineByStoreAndCategory(storeId, categoryId);

    }

    @GetMapping("/getMedicineByBarcodeNumOrName")   //fetch medicine by barcodeNumber or name
    Medicine getMedicineByBarcode(@RequestParam  String barcodeNumOrName) {
        return this.medicineService.getMedicineByBarcodeNumOrName(barcodeNumOrName);

    }

    @PostMapping("/add")   //adding new one
    public ResponseEntity<Medicine> addMedicine(@Valid @RequestBody Medicine medicine) {
        Medicine newMedicine =  this.medicineService.addMedicine(medicine);
        return new ResponseEntity<Medicine>(newMedicine, HttpStatus.CREATED);
    }

    @PutMapping("/update")   //update
    public Medicine updateMedicine(@Valid @RequestBody Medicine medicine) {
        return this.medicineService.updateMedicine(medicine);
    }


}
