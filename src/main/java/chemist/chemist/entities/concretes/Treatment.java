package chemist.chemist.entities.concretes;

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
    @Column(name = "treatmendid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int treatmentId;

    @Column(name = "prescriptionnum")
    private String prescriptionNum;

    @Column(name = "usage")
    private String usage;

    @Column(name = "amount")
    private int amount;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "medicineid")
    private Medicine medicine;
}
