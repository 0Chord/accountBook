package miniProject.accountBook.controller;

import java.util.Date;

public class CalculatorForm {
    private String id;
    private Long exportSum;
    private Long importSum;
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
