package com.nomal.pharmacy.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "medicine")
public class Medicine {

    @Id
    @Column(name = "medicine_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int medicineId;

    @Column(name = "barcode_number")
    @Size(min = 12, max = 13, message = "This is not valid size.")
    @Pattern(regexp = "[0-9]+", message = "Barcode number can only consist of numbers.")
    private String barcodeNum;

    @Column(name = "category_id")
    @Min(value = 1, message = "CategoryId must be greater than 0.")
    private int categoryId;

    @Column(name = "name")
    @Size(min = 2, max = 45, message = "Medicine name length must be between 2 and 45")
    private String name;

    @Column(name = "purpose")
    @Size(min = 2, max = 100, message = "Purpose length must be between 2 and 100")
    private String purpose;

    @Column(name = "side_effect")
    @Size(min = 2, max = 100, message = "Side effect length must be between 2 and 100")
    private String sideEffect;

    @Column(name = "price")
    @Min(value = 0, message = "Price can not be negative.")
    private int price;
}
