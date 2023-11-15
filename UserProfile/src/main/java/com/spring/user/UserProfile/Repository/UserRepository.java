package com.spring.user.UserProfile.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.spring.user.UserProfile.Model.User;



@Repository
public interface UserRepository extends MongoRepository<User, Long> {

}
