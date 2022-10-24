package miniProject.accountBook.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_key")
    Long commentKey;
    String nickname;
    Long boardId;
    String boardComment;
    String password;
    Boolean checked;
    Date date;

}
