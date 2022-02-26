package chemist.chemist.dataAccess.abstracts;

import chemist.chemist.entities.concretes.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineDao extends JpaRepository<Medicine, Integer> {

    Medicine getMedicineByBarcodeNum(String barcodeNum);
}
