package com.grpc.server.service;


import com.grpc.server.dao.Test1Dao;
import com.grpctest.service.GetUserServiceGrpc;
import com.test.common.model.Test1Model;
import io.grpc.Server;
import io.grpc.stub.StreamObserver;
import net.devh.springboot.autoconfigure.grpc.server.GrpcService;
import org.springframework.stereotype.Service;
import proto.dto.StringDTO;
import proto.dto.UserDTO;
import proto.dto.UserIdDTO;

import javax.annotation.Resource;

@Service
@GrpcService(GetUserService.class)
public class GetUserService extends GetUserServiceGrpc.GetUserServiceImplBase {

    @Resource
    private Test1Dao test1Dao;

    private Server server;

    @Override
    public void getUserById(UserIdDTO request, StreamObserver<UserDTO> responseObserver) {
        int userId = request.getUserId();
        Test1Model test1Model = test1Dao.selectById(userId);

        UserDTO userDTO = UserDTO.newBuilder().setUserId(test1Model.getId()).
                            setAge(test1Model.getAge()).setArea(test1Model.getArea()).
                            setUsername(test1Model.getUsername()).build();
        responseObserver.onNext(userDTO);
        responseObserver.onCompleted();
    }

    @Override
    public void getUserStringById(UserIdDTO request, StreamObserver<StringDTO> responseObserver) {
        int userId = request.getUserId();
        Test1Model test1Model = test1Dao.selectById(userId);
        String modelStr = test1Model.toString();

        StringDTO stringDTO = StringDTO.newBuilder().setContent(modelStr).build();
        responseObserver.onNext(stringDTO);
        responseObserver.onCompleted();
    }
}
