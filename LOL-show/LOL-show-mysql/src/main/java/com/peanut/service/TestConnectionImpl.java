package com.peanut.service;


import com.peanut.mapper.TestConnectionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestConnectionImpl implements  TestConnection{

    @Autowired
    private TestConnectionMapper mapper;


    @Override
    public void insert(Integer id, String name, Integer age) {
        mapper.insertToTestConnection(id,name,age);
    }
}
