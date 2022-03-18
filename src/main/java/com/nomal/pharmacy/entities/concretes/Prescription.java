package com.nomal.pharmacy.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "prescription")
public class Prescription {

    @Id
    @Column(name = "prescription_num")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String prescriptionNum;

    @Column(name = "date")
    private String date;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "tc")
    private Person person;

}
