package miniProject.accountBook.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "mbti_form")
public class Mbti {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long division_id;
    private String username;
    @Column(name="e_or_i")
    private Long eOrI;
    @Column(name="n_or_s")
    private Long nOrS;
    @Column(name="t_or_f")
    private Long tOrF;
    @Column(name="p_or_j")
    private Long pOrJ;
    private String result;

    private void updateEOrI(Long eOrI){
        this.eOrI = eOrI;
    }

    private void updateNOrS(Long nOrS){
        this.nOrS = nOrS;
    }

    private void updateTOrF(Long tOrF){
        this.tOrF = tOrF;
    }

    private void updatePOrJ(Long pOrJ){
        this.pOrJ = pOrJ;
    }
}
