package com.nomal.pharmacy.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @Column(name = "stock_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stockId;

    @Column(name = "store_id")
    @Min(value = 1, message = "Store id must be greater than 0.")
    private int storeId;

    @Column(name = "medicine_id")
    @Min(value = 1, message = "Medicine id id must be greater than 0.")
    private int medicineId;

    @Column(name = "quantity")
    @Min(value = 0, message = "Stock quantity can not be negative.")
    private int stockQuantity;
}
