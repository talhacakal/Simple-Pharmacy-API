package chemist.chemist.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BarcodeIdDTO {

    private int medicineId;
    private String barcodeNum;
    private int storeId;

}
