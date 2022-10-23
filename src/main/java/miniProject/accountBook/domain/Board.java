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
    @Column(name = "order_id")
    Long orderId;
    String nickname;
    String title;
    String content;
    @CreatedDate
    Date date;
    Boolean checked;
    @Column(name = "count_visit")
    Long countVisit;

    public void updateVisit(Long countVisit){
        this.countVisit = countVisit;
    }
}
