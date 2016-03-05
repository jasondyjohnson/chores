package com.jasondyjohnson.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Jason on 2/20/2016.
 */
@Data
@Entity
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class Person {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @Column(unique=true)
    private String loginName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String imageFileUrl;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "person")
    @OrderBy(value = "choreRewardDate DESC, points ASC")
    private List<PersonToChoreReward> personToChoreRewardList = new ArrayList<>();

    public Person(String loginName, String password, String firstName, String lastName, String email, String imageFileUrl) {
        this.loginName = loginName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.imageFileUrl = imageFileUrl;
    }

    public void addChoreReward(ChoreReward choreReward, Date choreRewardDate) {
        PersonToChoreReward personToChoreReward = new PersonToChoreReward();
        personToChoreReward.setChoreReward(choreReward);
        personToChoreReward.setPerson(this);
        personToChoreReward.setChoreRewardDate(choreRewardDate);
        personToChoreReward.setPoints(choreReward.getPoints());
        personToChoreRewardList.add(personToChoreReward);
    }

    @Transient
    public List<PersonToChoreReward> getChoresOnly() {
        List<PersonToChoreReward> chores =
                personToChoreRewardList.stream()
                        .filter(personToChoreReward -> personToChoreReward.getChoreReward().getPoints() > 0)
                        .collect(Collectors.toList());
        return chores;
    }

    @Transient
    public List<PersonToChoreReward> getRewardsOnly() {
        List<PersonToChoreReward> rewards =
                personToChoreRewardList
                        .stream()
                        .filter(personToChoreReward -> personToChoreReward.getChoreReward().getPoints() < 0)
                        .collect(Collectors.toList());
        return rewards;
    }
}
