package miniProject.accountBook.controller;

import lombok.Data;

import java.util.Date;

@Data
public class AccountForm {
    private String username;
    private String item;
    private Long price;
    private Date date;

    public Date getDate() {
        Date date = new Date();
        return date;
    }

}
