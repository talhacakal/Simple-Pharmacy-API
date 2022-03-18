package com.nomal.pharmacy.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockUpdateInfo {

    private String barcodenum;
    private String name;
    private String category_name;
    private int quantity;
}
