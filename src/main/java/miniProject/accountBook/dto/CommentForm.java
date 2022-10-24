package miniProject.accountBook.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CommentForm {
    private Long boardId;
    private String nickname;
    private String boardComment;
    private String password;
    private Boolean checked;
    private Date date;

    public Date getDate() {
        Date date = new Date();
        return date;
    }
}
