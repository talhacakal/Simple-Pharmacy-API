package com.nomal.pharmacy.dataAccess;

import com.nomal.pharmacy.entities.concretes.Stock;
import com.nomal.pharmacy.entities.dtos.StockInfo;
import com.nomal.pharmacy.entities.dtos.StockUpdateInfo;
import com.nomal.pharmacy.entities.dtos.TreatmentMedicineInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StockDao extends JpaRepository<Stock, Integer> {

    @Query("select new com.nomal.pharmacy.entities.dtos.TreatmentMedicineInfo(" +
            "m.barcodeNum, " +
            "m.name, " +
            "t.amount, " +
            "t.usage, " +
            "m.sideEffect, " +
            "s.stockQuantity, " +
            "m.price) " +
            "from Stock s " +
            "join Medicine m on s.medicineId=m.medicineId " +
            "join Treatment t on t.medicineId=m.medicineId " +
            "where t.prescriptionNum=:prescriptionNum and s.storeId=:storeId")
    List<TreatmentMedicineInfo> getTreatmentMedicines(String prescriptionNum, int storeId);


    @Query("Select new com.nomal.pharmacy.entities.dtos.StockInfo(m.barcodeNum, m.name, p.name,s.stockQuantity) " +
            "from Stock s " +
            "join Medicine m on s.medicineId=m.medicineId " +
            "join Pharmacy p on p.storeId=s.storeId where m.barcodeNum=:barcodeNum")
    List<StockInfo> getStockByBarcode(String barcodeNum);

    @Query("Select new com.nomal.pharmacy.entities.dtos.StockInfo(m.barcodeNum, m.name, p.name,s.stockQuantity) from Stock s " +
            "join Medicine m on s.medicineId=m.medicineId join Pharmacy p on p.storeId=s.storeId where m.name like %:name% order by m.name")
    List<StockInfo> getStockByName(String name);


    @Query("select new com.nomal.pharmacy.entities.dtos.StockUpdateInfo(" +
            "m.barcodeNum, " +
            "m.name, " +
            "(select c.categoryName from Category c where c.categoryId=m.categoryId), " +
            "s.stockQuantity) " +
            "from Stock s join Medicine m on s.medicineId=m.medicineId " +
            "where m.barcodeNum=:barcodeOrName and s.storeId=:storeId")
    StockUpdateInfo getStockUpdateInfoByBarcode(String barcodeOrName, int storeId);

    @Query("select new com.nomal.pharmacy.entities.dtos.StockUpdateInfo(" +
            "m.barcodeNum, " +
            "m.name, " +
            "(select c.categoryName from Category c where c.categoryId=m.categoryId), " +
            "s.stockQuantity) " +
            "from Stock s join Medicine m on s.medicineId=m.medicineId " +
            "where m.name like %:barcodeOrName% and s.storeId=:storeId")
    StockUpdateInfo getStockUpdateInfoByName(String barcodeOrName, int storeId);

    @Modifying
    @Transactional
    @Query("update Stock s set s.stockQuantity=:stockQuantity where " +
            "s.medicineId=(select medicineId from Medicine where barcodeNum=:barcodeNum) " +
            "and s.storeId=:storeId")
    int updateStockQuantity(String barcodeNum , int storeId, int stockQuantity);

    Stock findTopByMedicineId(int medicineId);


    /*---------------------------*/


    @Modifying
    @Transactional
    @Query("update Stock set stockQuantity=stockQuantity-:amount " +
            "where storeId=:storeId and " +
            "medicineId=:medicineId")
    int decreaseQuantity(int storeId, int medicineId, int amount);

    @Query("select s.stockQuantity from Stock s where s.storeId=:storeId and s.medicineId=:medicineId")
    int getAmountByStoreAndMedicine(int storeId, int medicineId);



}
