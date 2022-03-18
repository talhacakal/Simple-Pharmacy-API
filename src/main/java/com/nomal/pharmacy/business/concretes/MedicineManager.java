package com.nomal.pharmacy.business.concretes;

import com.nomal.pharmacy.business.abstracts.MedicineService;
import com.nomal.pharmacy.business.abstracts.StockService;
import com.nomal.pharmacy.core.exception.AlreadyExistsException;
import com.nomal.pharmacy.core.exception.RecordNotFoundException;
import com.nomal.pharmacy.dataAccess.MedicineDao;
import com.nomal.pharmacy.entities.concretes.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MedicineManager implements MedicineService {

    private MedicineDao medicineDao;
    private StockService stockService;

    @Autowired
    public MedicineManager(MedicineDao medicineDao, StockService stockService) {
        this.medicineDao = medicineDao;
        this.stockService = stockService;
    }

    @Override
    public List<Medicine> getAll() {
        List<Medicine> medicines = this.medicineDao.findAll();

        if (medicines.size() == 0){
            throw new RecordNotFoundException("There is no medicine.");
        }

        return medicines;
    }

    @Override
    public List<Medicine> getMedicineByStoreAndCategory(int storeId, int categoryId) { //fetch medicines by category and pharmacy
        List<Medicine> medicines;
        medicines = this.medicineDao.getMedicineByStoreAndCategory(storeId, categoryId);

        if (medicines.size() == 0)
            throw new RecordNotFoundException("Not data found");

        return medicines;
    }

    @Override
    public Medicine getMedicineByBarcodeNumOrName(String barcodeNumOrName) { // fetch medicine by barcodnumber or name
        Medicine medicine = this.medicineDao.getMedicineByBarcodeNumOrName(barcodeNumOrName, barcodeNumOrName);

        if(medicine == null)
            throw new RecordNotFoundException(barcodeNumOrName + " does not exist");

        return medicine;
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)  // to ensure atomicity
    public Medicine addMedicine(Medicine medicine) {
        Medicine checkMedicine = this.medicineDao.getMedicineByBarcodeNum(medicine.getBarcodeNum());
        if (checkMedicine != null){
            throw new AlreadyExistsException(medicine.getBarcodeNum() +" already exits.");
        }

        checkMedicine = this.medicineDao.save(medicine);
        this.stockService.addStock(checkMedicine.getMedicineId()); // adding stock

        return checkMedicine;
    }

    @Override
    public Medicine updateMedicine(Medicine medicine) {
        Medicine checkMedicine = this.medicineDao.getMedicineByBarcodeNum(medicine.getBarcodeNum());

        if (checkMedicine == null){
            throw new RecordNotFoundException("Invalid inputs. There is no such medicine");
        }else if (medicine.getMedicineId() == 0){
            medicine.setMedicineId(checkMedicine.getMedicineId());
        }

        return this.medicineDao.save(medicine);
    }

}





















