package com.codewithabe.AAiT.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @NotBlank(message = "")
    @Size(min = 3, max = 15, message = "Enter a valid name")
    private String eventName;
    @NotBlank(message = "")
    @Size(min = 5, message = "Enter a valid description")
    private String eventDescription;
    @Lob
    @Column (columnDefinition = "MEDIUMBLOB")
    private String eventImage;
    @ManyToOne
    private EventCatagory catagory;



}
