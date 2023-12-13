package com.example.springjwt.repositories;

import com.example.springjwt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmail(String email);
   /* public User findUserByEmail(String email){
        User user = new User(email,"1234567");
        user.setFirstName("FirstName");
        user.setLastName("LastName");
        return user;
    }*/



}
