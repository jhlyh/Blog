package com.blog.dao;

import com.blog.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TagRespository extends JpaRepository<Tag, Long> {
    Tag getByName(String name);
}
