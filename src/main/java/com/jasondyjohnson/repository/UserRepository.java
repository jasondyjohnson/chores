package com.jasondyjohnson.repository;

import com.jasondyjohnson.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Jason on 2/20/2016.
 */
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByUserName(String userName);
    User findById(Long id);
}
