package com.nomal.pharmacy.dataAccess;

import com.nomal.pharmacy.entities.concretes.Prescription;
import com.nomal.pharmacy.entities.dtos.PrescriptionInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface PrescriptionDao extends JpaRepository<Prescription, String> {

     @Query("select new com.nomal.pharmacy.entities.dtos.PrescriptionInfo(p.person.tc, p.person.name, p.person.birth, p.prescriptionNum, p.date, p.status) " +
             "from Prescription p where p.prescriptionNum=:prescriptionNum")
     PrescriptionInfo getPrescriptionByPrescriptionNumber(String prescriptionNum);

     @Modifying
     @Transactional
     @Query("update Prescription p set p.status='Sold' where p.prescriptionNum=:prescriptionNum")
     int setSold(String prescriptionNum);

     /* ----------- */
     Prescription getPrescriptionByPrescriptionNum(String prescriptionNum);


}
