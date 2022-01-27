package com.codewithabe.AAiT.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

//user pojo
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="student",uniqueConstraints = @UniqueConstraint(columnNames="ugr"))
public class Student {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    @NotNull
    @Size(min=2 ,max=15,message="length should be between 2 and 15")
    private String firstName;
    @Size(min=2 ,max=15,message="length should be between 2 and 15")
    @Column(name = "last_name")
    private String lastName;
    @NotEmpty(message="Email field shouldn't be empty")
    @Email(regexp = "^(.+)@(.+)$",message="invalid email")
    @NotBlank(message="ugr cannot be empyt")
    private String ugr;
    @NotBlank
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "students_roles",
            joinColumns = @JoinColumn(
                    name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))

    private Set<Role> roles= new HashSet<>();
    public Student(String firstName, String lastName, String ugr, String password, Set<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ugr = ugr;
        this.password = password;
        this.roles = roles;
    }

    public boolean hasRole(String roleName){
        for (Role role : this.roles) {
            if (role.getName().equals(roleName)) {
                return true;
            }
        }
        return false;
    }
}
