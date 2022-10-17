package miniProject.accountBook.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SelectionForm {

    @NotBlank
    private String option;
}
