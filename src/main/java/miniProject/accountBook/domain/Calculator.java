package miniProject.accountBook.domain;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getExportSum() {
        return exportSum;
    }

    public void setExportSum(Long exportSum) {
        this.exportSum = exportSum;
    }

    public Long getImportSum() {
        return importSum;
    }

    public void setImportSum(Long importSum) {
        this.importSum = importSum;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

