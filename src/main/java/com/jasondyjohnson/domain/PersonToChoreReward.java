package com.jasondyjohnson.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Jason on 2/20/2016.
 */
@Data
@Entity
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class PersonToChoreReward {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style="F-")
    private Date choreRewardDate;
    private int points;

    @ManyToOne
    @JoinColumn(name="person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name="chore_reward_id")
    private ChoreReward choreReward;

    public PersonToChoreReward(Person person, ChoreReward choreReward, Date choreRewardDate) {
        this.person = person;
        this.choreReward = choreReward;
        this.points = choreReward.getPoints();
        this.choreRewardDate = choreRewardDate;
    }

}
