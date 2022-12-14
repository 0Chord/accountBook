package miniProject.accountBook.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Member {

    @Id
    private String id;
    private String password;
    private String nickname;
    private String name;
    private String phone;

    public void updatePassword(String password){
        this.password = password;
    }

}
