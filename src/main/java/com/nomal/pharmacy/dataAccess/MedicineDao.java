package com.nomal.pharmacy.dataAccess;

import com.nomal.pharmacy.entities.concretes.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MedicineDao extends JpaRepository<Medicine, Integer> {

    @Query("select new Medicine(m.medicineId, m.barcodeNum, m.categoryId, m.name, m.purpose, m.sideEffect, m.price) " +
            "from Medicine m join Stock s on m.medicineId=s.medicineId where s.storeId=:storeId and m.categoryId=:categoryId")
    List<Medicine> getMedicineByStoreAndCategory(int storeId, int categoryId);   // just medicine

    Medicine getMedicineByBarcodeNumOrName(String barcodeNum, String name);

    Medicine getMedicineByBarcodeNum(String barcodeNum);



}
