package com.blog.service.impl;

import com.blog.Exception.NotfoundException;
import com.blog.dao.TypeRespositroy;
import com.blog.entity.Type;
import com.blog.service.TypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service
public class TypeServiceimpl implements TypeService {
    @Resource
    TypeRespositroy typeRespositroy;

    @Transactional
    @Override
    public Type saveType(Type type) {

        return typeRespositroy.save(type);
    }

    @Transactional
    @Override
    public Type getType(Long id) {
        return typeRespositroy.getOne(id);
    }

    @Transactional
    @Override
    public Page<Type> listType(Pageable pageable) {
        return typeRespositroy.findAll(pageable);
    }

    @Override
    public List<Type> listType() {
        return typeRespositroy.findAll();
    }


    @Transactional
    @Override
    public Type updateType(Long id, Type type) throws NotfoundException {
        Type one = typeRespositroy.getOne(id);
        if (one == null) {
            throw new NotfoundException("该分类未找到");
        }
        BeanUtils.copyProperties(type, one);
        return typeRespositroy.save(one);
    }

    @Transactional
    @Override
    public void deleteType(Long id) {
        typeRespositroy.deleteById(id);
    }

    @Override
    public Type getByName(String name) {
        return typeRespositroy.findByName(name);
    }
}
