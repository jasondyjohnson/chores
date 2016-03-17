package com.jasondyjohnson;

import com.jasondyjohnson.repository.ChoreRewardRepository;
import com.jasondyjohnson.repository.PersonRepository;

/**
 * Created by Jason on 3/16/2016.
 */
public interface InitChores {
    void initDatabase(PersonRepository personRepository, ChoreRewardRepository choreRepository);
}
