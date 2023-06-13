package com.blog.service;

import com.blog.Exception.NotfoundException;
import com.blog.bean.BlogQuery;
import com.blog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface BlogService {

    Blog gethtmlBlog(Long id);

    Blog getBlog(Long id);

    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);

    Page<Blog> listBlog(Pageable pageable);

    Page<Blog> searchtag(Pageable pageable, String name);

    Page<Blog> searchBlog(Pageable pageable, String query);

    Blog saveBlog(Blog blog);

    Blog updateBlog(Long id, Blog blog) throws NotfoundException;

    void deleteBlog(Long id);
}
