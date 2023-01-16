package com.example.demo.myFirstProject.dto;

import com.example.demo.myFirstProject.model.User;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDto {

    private Long id;
    private String name;
    private String last_name;
    private LocalDate birthday;

    public UserDto() {
    }

    public UserDto(Long id, String name, String last_name, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.birthday = birthday;
    }

    public UserDto(User user) {
        id = user.getId();
        name = user.getName();
        last_name = user.getLast_name();
        birthday = user.getBirthday();
    }
}
