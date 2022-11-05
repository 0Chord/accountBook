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
    private String result;

    public void updateMbti(String result){
        this.result = result;
    }

}
