package com.nomal.pharmacy.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "treatment")
public class Treatment {

    @Id
    @Column(name = "treatment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int treatmentId;

    @Column(name = "prescription_num")
    private String prescriptionNum;

    @Column(name = "medicine_id")
    private int medicineId;

    @Column(name = "usage")
    private String usage;

    @Column(name = "amount")
    private int amount;
}
