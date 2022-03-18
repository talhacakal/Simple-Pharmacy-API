package com.nomal.pharmacy.business.abstracts;

import com.nomal.pharmacy.entities.concretes.Medicine;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Validated
public interface MedicineService {

    List<Medicine> getAll();
    List<Medicine> getMedicineByStoreAndCategory(
            @Min(value = 0, message = "StoreId must be greater than 0.") int storeId,
            @Min(value = 0, message = "CategoryId must be greater than 0.") int categoryId); //fetch medicines by category and pharmacy
    Medicine getMedicineByBarcodeNumOrName(@NotBlank(message = "Must not be blank") String barcodeNumOrName); // fetch medicine by barcodnumber or name
    Medicine addMedicine(Medicine medicine);
    Medicine updateMedicine(Medicine medicine);

}
