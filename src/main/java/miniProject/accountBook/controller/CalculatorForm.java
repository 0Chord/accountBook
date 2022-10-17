package miniProject.accountBook.controller;

import lombok.Data;

import java.util.Date;

@Data
public class CalculatorForm {
    private String username;
    private Long exportSum;
    private Long importSum;
    private Date date;

    public Date getDate() {
        Date date = new Date();
        return date;
    }

}
