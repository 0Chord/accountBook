package miniProject.accountBook.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Member {

    @Id
    String id;
    String password;
    String nickname;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
