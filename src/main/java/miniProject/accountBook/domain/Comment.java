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
    @Column(name = "board_comment")
    String boardComment;
    @Column(name = "comment_password")
    String commentPassword;
    Boolean checked;
    Date date;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="order_id")
    private Board board;
}
