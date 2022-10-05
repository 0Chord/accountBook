package miniProject.accountBook.controller;

import java.util.Date;

public class CalculatorForm {
    private String username;
    private Long exportSum;
    private Long importSum;
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
        Date date = new Date();
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
