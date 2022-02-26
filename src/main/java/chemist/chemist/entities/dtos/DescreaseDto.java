package chemist.chemist.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DescreaseDto {

    private int medicineId;
    private int storeId;
    private int amount;
}
