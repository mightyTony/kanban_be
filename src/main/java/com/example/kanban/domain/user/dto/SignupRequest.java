package com.example.kanban.domain.user.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SignupRequest {
    @NotBlank(message = "아이디는 필수입니다.")
    @Size(min = 6, max = 20, message = "아이디는 6자 이상 20자 이하 여야 합니다.")
    @Pattern(
            regexp = "^(?=.*[a-zA-Z])[a-zA-Z0-9]{6,20}$",
            message = "아이디는 영문자를 반드시 포함하며, 숫자 조합만 가능하고 특수문자는 사용할 수 없습니다."
    )
    private String userId;

    @NotBlank(message = "비밀번호는 필수입니다.")
    @Size(min = 6, max = 20, message = "비밀번호는 6자 이상 20자 이하 여야 합니다.")
    @Pattern(
            regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,20}$",
            message = "비밀번호는 문자와 숫자를 모두 포함해야 합니다."
    )
    private String password;

    @NotBlank(message = "이름은 필수 입니다.")
    @Size(min = 2, max = 10, message = "이름은 2자 이상 10자 이하 여야 합니다.")
    private String name;

    @NotBlank(message = "이메일은 필수입니다.")
    @Email(message = "올바른 이메일 형식이 아닙니다.")
    private String email;
}
