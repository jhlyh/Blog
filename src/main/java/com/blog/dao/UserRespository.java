package com.blog.dao;

import com.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRespository extends JpaRepository<User, Long> {
    User findByUsernameAndPassword(String username, String password);
}
