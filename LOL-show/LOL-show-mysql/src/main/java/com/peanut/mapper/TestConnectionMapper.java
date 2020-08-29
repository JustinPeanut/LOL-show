package com.peanut.mapper;

import org.apache.ibatis.annotations.Param;

public interface TestConnectionMapper {

    public void insertToTestConnection(@Param("id") Integer id , @Param("name") String name, @Param("age") Integer age);
}
