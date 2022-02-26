package chemist.chemist.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicineStockInfo {

    private int medicineId;
    private String barcodeNumber;
    private String name;
    private String purpose;
    private int storeId;
    private int quantity;


}
