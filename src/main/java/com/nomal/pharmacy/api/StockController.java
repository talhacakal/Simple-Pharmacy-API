package com.nomal.pharmacy.api;

import com.nomal.pharmacy.business.abstracts.StockService;
import com.nomal.pharmacy.entities.dtos.StockInfo;
import com.nomal.pharmacy.entities.dtos.StockUpdateInfo;
import com.nomal.pharmacy.entities.dtos.TreatmentMedicineInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
@CrossOrigin
public class StockController {

    private StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/getTreatmentMedicines") //fetch prescription drugs
    public List<TreatmentMedicineInfo> getTreatmentMedicines(@RequestParam String prescriptionNum,@RequestParam int storeId){
        return this.stockService.getTreatmentMedicines(prescriptionNum, storeId);
    }

    @GetMapping("/getStockByBarcode") // stock info by barcode number
    public List<StockInfo> getStockByBarcode(@RequestParam String barcodeNum){
        return this.stockService.getStockByBarcode(barcodeNum);
    }

    @GetMapping("/getStockByname")   // stock info by name
    public List<StockInfo> getStockByName(@RequestParam String medicineName){
        return this.stockService.getStockByName(medicineName);
    }


    @GetMapping("/getStockUpdateInfoByBarcode") // medicine info for stock update process
    public StockUpdateInfo getStockUpdateInfoByBarcode(@RequestParam String barcodeNum,@RequestParam int storeId){
        return stockService.getStockUpdateInfoByBarcode(barcodeNum,storeId);
    }

    @GetMapping("/getStockUpdateInfoByName")  // medicine info for stock update process
    public StockUpdateInfo getStockUpdateInfoByName(@RequestParam String name, @RequestParam int storeId){
        return stockService.getStockUpdateInfoByName(name,storeId);
    }

    @PutMapping("/updateStockQuantity")    //stock quantity update
    public void updateStockQuantity(@RequestParam String barcodeNum, @RequestParam int storeId, @RequestParam int stockQuantity){
        this.stockService.updateStockQuantity(barcodeNum, storeId, stockQuantity);
    }

}
