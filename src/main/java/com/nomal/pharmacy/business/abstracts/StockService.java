package com.nomal.pharmacy.business.abstracts;

import com.nomal.pharmacy.entities.dtos.StockInfo;
import com.nomal.pharmacy.entities.dtos.StockUpdateInfo;
import com.nomal.pharmacy.entities.dtos.TreatmentMedicineInfo;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Validated
public interface StockService {

    List<TreatmentMedicineInfo> getTreatmentMedicines(
            @Size(max = 8, min = 7, message = "Prescription length must be between 7 and 8")
            @NotBlank(message = "Prescription can not be blank") String prescriptionNum,
            @Min(value = 1, message = "StoreId must be greater than 0.") int storeId);   //fetch prescription drugs

    List<StockInfo> getStockByBarcode( @Size(min = 12, max = 13, message = "This is not valid size.") // stock info by barcode number
                                       @Pattern(regexp = "[0-9]+", message = "Barcode number can only consist of numbers.") String barcodeNum);
    List<StockInfo> getStockByName(@NotBlank(message = "Invalid medicine name.") String medicineName); // stock info by barcode name


    StockUpdateInfo getStockUpdateInfoByBarcode(
            @Size(min = 12, max = 13, message = "This is not valid size.")
            @Pattern(regexp = "[0-9]+", message = "Barcode number can only consist of numbers.") String barcodeNum,
            @Min(value = 1, message = "StoreId must be greater than 0.") int storeId); // medicine info for stock update process

    StockUpdateInfo getStockUpdateInfoByName(@NotBlank(message = "Invalid medicine name.") String name,
                                             @Min(value = 1, message = "StoreId must be greater than 0.") int storeId); // medicine info for stock update process


    int updateStockQuantity(
            @Size(min = 12, max = 13, message = "This is not valid size.")
            @Pattern(regexp = "[0-9]+", message = "Barcode number can only consist of numbers.") String barcodeNum,
            @Min(value = 1, message = "StoreId must be greater than 0.") int storeId,
            @Min(value = 0, message = "Quantity must be greater than zero.") int stockQuantity); //stock quantity update

    /* -------------------------- */

    int decreaseQuantity(int store_id, int medicine_id, int amount);

    void addStock(int medicine_id);


}
