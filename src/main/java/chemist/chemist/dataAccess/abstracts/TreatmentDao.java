package chemist.chemist.dataAccess.abstracts;

import chemist.chemist.entities.concretes.Medicine;
import chemist.chemist.entities.concretes.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TreatmentDao extends JpaRepository<Treatment, Integer> {

    @Query("select t.medicine from Treatment t where t.prescriptionNum = :prescriptionNum")
    List<Medicine> getByPrescriptionNumber(String prescriptionNum);

    List<Treatment> getTreatmentByPrescriptionNum(String prescriptionNum);


    @Modifying
    @Transactional
    @Query("update Treatment set status='Sold' where prescriptionNum = :prescriptionNum")
    int setSold(String prescriptionNum);
}
