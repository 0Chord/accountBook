package miniProject.accountBook.controller;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Data
public class BoardForm {
    String nickname;
    String title;
    String content;
    @CreatedDate
    Date date;

    public Date getDate() {
        Date date = new Date();
        return date;
    }
}
