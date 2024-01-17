package umc.spring.web.dto.member;

import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import umc.spring.validation.annotation.ExistCategories;

public class MemberRequest {

    @Getter
    public static class JoinDTO{
        @NotBlank
        String name;

        @NotNull
        Integer birthYear;

        @NotNull
        Integer birthMonth;

        @NotNull
        Integer birthDay;

        @Size(min=5, max=12)
        String address;

        @Size(min=5, max=12)
        String specAddress;

        @ExistCategories
        List<Long> preferList;
    }
}
