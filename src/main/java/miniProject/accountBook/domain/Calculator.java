package miniProject.accountBook.domain;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Calculator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long division_id;
    private String username;
    @Column(name = "EXPORT_SUM")
    private Long exportSum;
    @Column(name = "IMPORT_SUM")
    private Long importSum;
    @CreatedDate
    private Date date;

}

