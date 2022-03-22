package Kim.OwnHub.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "AUTHORITY")
@Getter
public class Authority {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "AUTHORITY_ID")
    private Long id;

    @Column(name = "AUTHORITY_NAME")
    private String pname;

    @OneToOne(mappedBy = "authority")
    private Employee aemployee;
}
