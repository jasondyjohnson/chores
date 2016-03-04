package com.jasondyjohnson.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Jason on 2/20/2016.
 */
@Data
@Entity
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @Column(unique=true)
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String imageFileUrl;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user")
    @OrderBy(value = "choreRewardDate DESC, points ASC")
    private List<UserToChoreReward> userToChoreRewardList = new ArrayList<>();

    public User(String userName, String firstName, String lastName, String email, String imageFileUrl) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.imageFileUrl = imageFileUrl;
    }

    public void addChoreReward(ChoreReward choreReward, Date choreRewardDate) {
        UserToChoreReward userToChoreReward = new UserToChoreReward ();
        userToChoreReward.setChoreReward(choreReward);
        userToChoreReward.setUser(this);
        userToChoreReward.setChoreRewardDate(choreRewardDate);
        userToChoreReward.setPoints(choreReward.getPoints());
        userToChoreRewardList.add(userToChoreReward);
    }

    @Transient
    public List<UserToChoreReward> getChoresOnly() {
        List<UserToChoreReward> chores = new ArrayList<>();
        for (UserToChoreReward userToChoreReward : userToChoreRewardList) {
            if (userToChoreReward.getChoreReward().getPoints() > 0)
                chores.add(userToChoreReward);
        }
        return chores;
    }

    @Transient
    public List<UserToChoreReward> getRewardsOnly() {
        List<UserToChoreReward> rewards = new ArrayList<>();
        for (UserToChoreReward userToChoreReward : userToChoreRewardList) {
            if (userToChoreReward.getChoreReward().getPoints() < 0)
                rewards.add(userToChoreReward);
        }
        return rewards;
    }
}
