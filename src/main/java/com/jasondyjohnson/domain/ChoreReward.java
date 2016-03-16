package com.jasondyjohnson.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by Jason on 2/20/2016.
 */
@Data
@Entity
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class ChoreReward {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @Column(unique=true)
    @NotNull
    private String name;
    @NotNull
    private int points;

    public ChoreReward(String name, int points) {
        this.name = name;
        this.points = points;
    }
}
