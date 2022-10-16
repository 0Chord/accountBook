package miniProject.accountBook.domain;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id")
    Long orderId;
    String nickname;
    String password;
    String title;
    String content;
    @CreatedDate
    Date date;

}
