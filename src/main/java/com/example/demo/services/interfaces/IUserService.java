package com.example.demo.services.interfaces;

import com.example.demo.model.PagedList;
import com.example.demo.model.request.UserRequest;
import com.example.demo.model.response.UserResponse;

public interface IUserService {
    PagedList<UserResponse> findAll(Integer pageNumber, Integer pageSize);
    UserResponse add(UserRequest user);
}
