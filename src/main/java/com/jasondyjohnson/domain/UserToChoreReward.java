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
public class UserToChoreReward {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style="F-")
    private Date choreRewardDate;
    private int points;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="chore_reward_id")
    private ChoreReward choreReward;

    public UserToChoreReward(User user, ChoreReward choreReward, Date choreRewardDate) {
        this.user = user;
        this.choreReward = choreReward;
        this.points = choreReward.getPoints();
        this.choreRewardDate = choreRewardDate;
    }

}
