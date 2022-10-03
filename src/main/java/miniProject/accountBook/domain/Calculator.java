package miniProject.accountBook.domain;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Calculator {
    @Id
    private String id;
    @Column(name = "EXPORTSUM")
    private Long exportSum;
    @Column(name = "IMPORTSUM")
    private Long importSum;
    @CreatedDate
    private Date date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

