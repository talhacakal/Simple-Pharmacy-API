package chemist.chemist.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "medicine")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "treatments"})
public class Medicine {

    @Id
    @Column(name = "medicineid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int medicineId;

    @Column(name = "barcodenumber")
    private String barcodeNum;

    @Column(name = "name")
    private String name;

    @Column(name = "purpose")
    private String purpose;

    @Column(name = "sideeffect")
    private String sideEffect;

    @Column(name = "price")
    private int price;

    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;

    @OneToMany(mappedBy = "medicine")
    private List<Treatment> treatments;
}
