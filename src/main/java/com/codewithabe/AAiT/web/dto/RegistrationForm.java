package com.codewithabe.AAiT.web.dto;

import com.codewithabe.AAiT.models.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationForm {
    private String firstName;
    private String lastName;
    private String ugr;
    private String password;
    private List<Course> course = new ArrayList<>();

}
