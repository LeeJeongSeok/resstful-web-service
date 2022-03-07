package com.example.resstfulwebservice.domain;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter @Setter @AllArgsConstructor
//@JsonIgnoreProperties(value = {"password", "ssn"})
@NoArgsConstructor
//@JsonFilter("UserInfo")
public class User {

    private Long id;

    @Size(min = 2, message = "Name은 2글자 이상 입력해 주세요.")
    private String name;
    @Past
    private LocalDateTime joinDate;

    private String password;
    private String ssn;
}
