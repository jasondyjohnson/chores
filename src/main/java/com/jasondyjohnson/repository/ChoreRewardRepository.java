package com.jasondyjohnson.repository;

import com.jasondyjohnson.domain.ChoreReward;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Jason on 2/21/2016.
 */
public interface ChoreRewardRepository extends CrudRepository<ChoreReward, Long> {

    public List<ChoreReward> findAllByOrderByNameAsc();

    @Query("select cr FROM ChoreReward cr WHERE cr.points > 0 ORDER BY cr.name ASC")
    public List<ChoreReward> findAllChoresOrderByNameAsc();

    @Query("select cr FROM ChoreReward cr WHERE cr.points < 0 ORDER BY cr.name ASC")
    public List<ChoreReward> findAllRewardsOrderByNameAsc();
}
