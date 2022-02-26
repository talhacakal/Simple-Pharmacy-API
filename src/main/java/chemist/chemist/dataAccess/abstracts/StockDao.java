package chemist.chemist.dataAccess.abstracts;

import chemist.chemist.entities.concretes.Medicine;
import chemist.chemist.entities.concretes.Stock;
import chemist.chemist.entities.dtos.MedicineStockInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StockDao extends JpaRepository<Stock, Integer> {

    @Query("select new chemist.chemist.entities.dtos.MedicineStockInfo(" +
            "s.medicine.medicineId ,s.medicine.barcodeNum, s.medicine.name, s.medicine.purpose, s.storeId , s.quantity) FROM Stock s " +
            "where s.medicine.barcodeNum = :barcodeNumber and s.storeId = :storeId")
    MedicineStockInfo getMedicineByBarcode(String barcodeNumber, int storeId);

    @Query("select new chemist.chemist.entities.dtos.MedicineStockInfo(" +
            "s.medicine.medicineId ,s.medicine.barcodeNum, s.medicine.name, s.medicine.purpose, s.storeId, s.quantity) FROM Stock s " +
            "where s.medicine.barcodeNum = :barcodeNumber")
    List<MedicineStockInfo> getAllMedicineByBarcode(String barcodeNumber);

    @Modifying
    @Transactional
    @Query("update Stock s set s.quantity = :amount " +
            "where s.medicine.medicineId= :medicineId and s.storeId = :storeId")
    int setQuantity(int medicineId, int storeId, int amount);

    @Query("select s.quantity from Stock s where s.medicine.medicineId = :medicineId and s.storeId = :storeId")
    int getQuantityById(int medicineId, int storeId);

}
