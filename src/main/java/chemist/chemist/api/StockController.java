package chemist.chemist.api;

import chemist.chemist.dataAccess.abstracts.StockDao;
import chemist.chemist.entities.concretes.Medicine;
import chemist.chemist.entities.concretes.Stock;
import chemist.chemist.entities.dtos.BarcodeIdDTO;
import chemist.chemist.entities.dtos.DescreaseDto;
import chemist.chemist.entities.dtos.MedicineStockInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {

    private StockDao stockDao;

    @Autowired
    public StockController(StockDao stockDao) {
        this.stockDao = stockDao;
    }

    @PostMapping("/getStockInfo")
    public ArrayList<MedicineStockInfo> getStockInfo(@RequestBody List<BarcodeIdDTO> BarcodeIdDTOs){
        ArrayList<MedicineStockInfo> list=new ArrayList<>();
        for (BarcodeIdDTO barcodeIdDTO : BarcodeIdDTOs){
            list.add(this.stockDao.getMedicineByBarcode(barcodeIdDTO.getBarcodeNum(), barcodeIdDTO.getStoreId()));
        }
        return list;
    }

    @PostMapping("/decreaseStock")
    public String decreaseStock(@RequestBody List<DescreaseDto> descreaseDtos){
        int quantity;
        for (DescreaseDto descreaseDto : descreaseDtos){
            quantity = this.stockDao.getQuantityById(descreaseDto.getMedicineId(), descreaseDto.getStoreId());
            this.stockDao.setQuantity(descreaseDto.getMedicineId(), descreaseDto.getStoreId(), quantity-descreaseDto.getAmount());
        }
        return "Success";
    }

    @GetMapping("/getMedicinesStock/{barcodeNumber}")
    public List<MedicineStockInfo> getMedicinesStock(@PathVariable String barcodeNumber){
        return this.stockDao.getAllMedicineByBarcode(barcodeNumber);
    }

    @PostMapping("/addStock")
    public void addStock(@RequestBody Stock stock){
        this.stockDao.save(stock);
        System.out.println("Success");
    }
}


































