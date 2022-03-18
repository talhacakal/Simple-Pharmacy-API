package com.nomal.pharmacy.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreatmentMedicineInfo {

    private String barcode_num;
    private String name;
    private int quantity;
    private String usage;
    private String side_effect;
    private int stock_quantity;
    private int price;
}
