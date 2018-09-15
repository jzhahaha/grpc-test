package com.grpc.client.service;

import com.grpctest.service.GetUserServiceGrpc;
import com.test.common.model.Test1Model;
import io.grpc.Channel;
import net.devh.springboot.autoconfigure.grpc.client.GrpcClient;
import org.springframework.stereotype.Service;
import proto.dto.StringDTO;
import proto.dto.UserDTO;
import proto.dto.UserIdDTO;

@Service
public class GetUserService {

    @GrpcClient("grpc-test-server")
    private Channel serverChannel;

    public String getUserStringById(int id){
        GetUserServiceGrpc.GetUserServiceBlockingStub asyncStub = GetUserServiceGrpc.newBlockingStub(serverChannel);

        UserIdDTO userIdDTO = UserIdDTO.newBuilder().setUserId(id).build();
        return asyncStub.getUserStringById(userIdDTO).getContent();
    }

    public Test1Model getModelById(int id){
        GetUserServiceGrpc.GetUserServiceBlockingStub stub = GetUserServiceGrpc.newBlockingStub(serverChannel);

        UserIdDTO userIdDTO = UserIdDTO.newBuilder().setUserId(id).build();

        Test1Model user = new Test1Model();

        UserDTO userDTO = stub.getUserById(userIdDTO);
        user.setId(userDTO.getUserId());
        user.setAge(userDTO.getAge());
        user.setUsername(userDTO.getUsername());
        user.setArea(userDTO.getArea());

        return user;

    }




}
