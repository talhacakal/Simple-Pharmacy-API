package com.nomal.pharmacy.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockInfo {

    private String barcode_number;
    private String name;
    private String pharmacyName;
    private int quantity;


}
