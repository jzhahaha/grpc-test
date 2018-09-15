package com.grpc.server.dao;


import com.test.common.model.Test1Model;

import java.util.Map;
import java.util.Set;

public interface Test1Dao {

    Test1Model selectById(int id);

    Map<Integer, Test1Model> testMapKeyById(Set<Integer> ids);

}
