package com.grpc.server.dao.impl.jdbc;

import com.grpc.server.config.langdriver.SelectLanguageDriver;
import com.grpc.server.dao.Test1Dao;
import com.test.common.model.Test1Model;
import org.apache.ibatis.annotations.*;


import java.util.Map;
import java.util.Set;

@Mapper
public interface Test1Mapper extends Test1Dao {

    @Override
    @Select("select * from test1 where id = #{id}")
    Test1Model selectById(int id);

    @Override
    @MapKey("id")
    @Lang(SelectLanguageDriver.class)
    @Select("select * from test1 where id in (#{ids})")
    Map<Integer, Test1Model> testMapKeyById(@Param("ids") Set<Integer> ids);
}
