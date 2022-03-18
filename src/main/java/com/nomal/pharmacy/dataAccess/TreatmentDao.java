package com.nomal.pharmacy.dataAccess;

import com.nomal.pharmacy.entities.concretes.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TreatmentDao extends JpaRepository<Treatment, Integer> {

    List<Treatment> getTreatmentByPrescriptionNum(String prescriptionNum);

}
