package com.blog.service.impl;

import com.blog.Exception.NotfoundException;
import com.blog.dao.TagRespository;
import com.blog.entity.Tag;
import com.blog.service.TagService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
public class TagServiceimpl implements TagService {

    @Resource
    TagRespository tagRespository;

    @Transactional
    @Override
    public Tag saveTag(Tag tag) {
        return tagRespository.save(tag);
    }

    @Transactional
    @Override
    public Tag getTag(Long id) {
        return tagRespository.getOne(id);
    }

    @Transactional
    @Override
    public Page<Tag> listTag(Pageable pageable) {
        return tagRespository.findAll(pageable);
    }

    @Override
    public List<Tag> listTag() {
        return tagRespository.findAll();
    }

    @Override
    public List<Tag> listTag(String ids) {

        return tagRespository.findAllById(convertToList(ids));

    }

    private List<Long> convertToList(String ids) {
        List<Long> list = new ArrayList<>();
        if (!"".equals(ids) && ids != null) {
            String[] idarray = ids.split(",");
            for (String id : idarray) {
                list.add(Long.parseLong(id));
            }
        }
        return list;
    }

    @Transactional
    @Override
    public Tag updateTag(Long id, Tag tag) throws NotfoundException {
        Tag one = tagRespository.getOne(id);
        if (one == null) {
            throw new NotfoundException("该便签未找到");
        }
        BeanUtils.copyProperties(tag, one);
        return tagRespository.save(one);
    }

    @Transactional
    @Override
    public void deleteTag(Long id) {
        tagRespository.deleteById(id);
    }

    @Transactional
    @Override
    public Tag getByName(String name) {
        return tagRespository.getByName(name);
    }
}
