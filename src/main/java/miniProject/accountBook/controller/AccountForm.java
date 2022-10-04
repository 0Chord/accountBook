package miniProject.accountBook.controller;

import java.util.Date;

public class AccountForm {
    private String username;
    private String item;
    private Long price;
    private Date date;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Date getDate() {
        Date date = new Date();
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
