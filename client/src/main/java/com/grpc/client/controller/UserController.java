package com.grpc.client.controller;

import com.grpc.client.service.GetUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    private GetUserService getUserService;

    @GetMapping("/user")
    public ResponseEntity<?> getUserById(@RequestParam("userId")int userId){

        return new ResponseEntity<>(getUserService.getModelById(userId),HttpStatus.OK);
    }

    @GetMapping("/user/string")
    public ResponseEntity<?> getUserStringById(@RequestParam("userId")int userId){

        return new ResponseEntity<>(getUserService.getUserStringById(userId),HttpStatus.OK);
    }


}
