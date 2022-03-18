package com.nomal.pharmacy.business.concretes;

import com.nomal.pharmacy.business.abstracts.StockService;
import com.nomal.pharmacy.core.exception.AlreadyExistsException;
import com.nomal.pharmacy.core.exception.RecordNotFoundException;
import com.nomal.pharmacy.core.exception.StockQuantityOutOfBountException;
import com.nomal.pharmacy.dataAccess.StockDao;
import com.nomal.pharmacy.entities.concretes.Stock;
import com.nomal.pharmacy.entities.dtos.StockInfo;
import com.nomal.pharmacy.entities.dtos.StockUpdateInfo;
import com.nomal.pharmacy.entities.dtos.TreatmentMedicineInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockManager implements StockService {

    private StockDao stockDao;

    @Autowired
    public StockManager(StockDao stockDao) {
        this.stockDao = stockDao;
    }

    @Override
    public List<TreatmentMedicineInfo> getTreatmentMedicines(String prescriptionNum, int storeId) {
        List<TreatmentMedicineInfo> treatmentMedicineInfos = this.stockDao.getTreatmentMedicines(prescriptionNum, storeId);

        if (treatmentMedicineInfos.size() == 0){
            throw new RecordNotFoundException("Medicines could not found.");
        }
        return treatmentMedicineInfos;

    }

    @Override
    public List<StockInfo> getStockByBarcode(String barcodeNum) {
        List<StockInfo> stockInfos =  this.stockDao.getStockByBarcode(barcodeNum);

        if (stockInfos.size() == 0){
            throw new RecordNotFoundException("Stock info could not found.");
        }
        return stockInfos;

    }

    @Override
    public List<StockInfo> getStockByName(String medicineName) {
        List<StockInfo> stockInfos =  this.stockDao.getStockByName(medicineName);

        if (stockInfos.size() == 0){
            throw new RecordNotFoundException("Stock info could not found.");
        }
        return stockInfos;
    }

    @Override
    public StockUpdateInfo getStockUpdateInfoByBarcode(String barcodeNum, int storeId) {
        StockUpdateInfo stockUpdateInfo = stockDao.getStockUpdateInfoByBarcode(barcodeNum,storeId);

        if (stockUpdateInfo == null){
            throw new RecordNotFoundException(barcodeNum+" medicine could not found.");
        }

        return stockUpdateInfo;
    }

    @Override
    public StockUpdateInfo getStockUpdateInfoByName(String name, int storeId) {
        StockUpdateInfo stockUpdateInfo = stockDao.getStockUpdateInfoByName(name,storeId);

        if (stockUpdateInfo == null){
            throw new RecordNotFoundException(name+" medicine could not found.");
        }

        return stockUpdateInfo;
    }

    @Override
    public int updateStockQuantity(String barcodeNum, int storeId, int stockQuantity) {
        return this.stockDao.updateStockQuantity(barcodeNum, storeId, stockQuantity);
    }

    /* --------------- */

    @Override
    public int decreaseQuantity(int storeId, int medicineId, int amount){
        int stockQuantity = this.stockDao.getAmountByStoreAndMedicine(storeId, medicineId);

        if (stockQuantity-amount < 0)
            throw new StockQuantityOutOfBountException("Not enough stock.");

        return this.stockDao.decreaseQuantity(storeId, medicineId, amount);
    }

    @Override
    public void addStock(int medicineId) {

        Stock stock = this.stockDao.findTopByMedicineId(medicineId);
        if (stock != null)
            throw new AlreadyExistsException("Medicine already exist.");

        this.stockDao.save(new Stock(0,1,medicineId,0));
        this.stockDao.save(new Stock(0,2,medicineId,0));

    }
}



























