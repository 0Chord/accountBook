package miniProject.accountBook.calculator;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Calculator {
    @Id
    String id;
    Long export_sum;
    Long import_sum;
    Long sum;
    Date date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getExport_sum() {
        return export_sum;
    }

    public void setExport_sum(Long export_sum) {
        this.export_sum = export_sum;
    }

    public Long getImport_sum() {
        return import_sum;
    }

    public void setImport_sum(Long import_sum) {
        this.import_sum = import_sum;
    }

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
