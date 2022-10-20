package miniProject.accountBook.dto;

import lombok.Data;

@Data
public class RewritePasswordForm {
    private String id;
    private String password;
    private String validatedPassword;
}
