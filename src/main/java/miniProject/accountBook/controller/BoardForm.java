package miniProject.accountBook.controller;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Data
public class BoardForm {
    private String nickname;
    private String password;
    private String title;
    private String content;
    @CreatedDate
    private Date date;

    public Date getDate() {
        Date date = new Date();
        return date;
    }
}
