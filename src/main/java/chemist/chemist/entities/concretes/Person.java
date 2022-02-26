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
@Table(name = "person")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","prescriptions"})
public class Person {

    @Id
    @Column(name = "tc")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String tc;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "birth")
    private String birth;

    @OneToMany(mappedBy = "person")
    private List<Prescription> prescriptions;

}
