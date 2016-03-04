package com.jasondyjohnson.repository;

import com.jasondyjohnson.domain.ChoreReward;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by Jason on 2/21/2016.
 */
public interface ChoreRewardRepository extends CrudRepository<ChoreReward, Long> {

}
