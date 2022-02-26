package chemist.chemist.dataAccess.abstracts;

import chemist.chemist.entities.concretes.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionDao extends JpaRepository<Prescription, String> {

    Prescription getPrescriptionByPrescriptionNum(String prescriptionNum);
}
