package com.codewithabe.AAiT.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventCatagory {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @NotNull
    @Size(min =3, max = 15)
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "catagory_id")
    private List<Event> event = new ArrayList<>();


    public EventCatagory(int id, String name) {
        this.id = id;
        this.name = name;
    }





}
