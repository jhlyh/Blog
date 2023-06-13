package com.blog.dao;

import com.blog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BlogRespository extends JpaRepository<Blog, Long>, JpaSpecificationExecutor<Blog> {

    List<Blog> findAllByTitleContains(String query);
}
