package chemist.chemist.entities.concretes;

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
    @Column(name = "prescriptionnum")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String prescriptionNum;

    @Column(name = "date")
    private String date;

    @ManyToOne
    @JoinColumn(name = "tc")
    private Person person;
}
