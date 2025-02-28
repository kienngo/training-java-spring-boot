package com.example.demo.services;

import com.example.demo.entity.User;
import com.example.demo.model.PagedList;
import com.example.demo.model.request.UserRequest;
import com.example.demo.model.response.UserResponse;
import com.example.demo.repository.*;
import com.example.demo.services.interfaces.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService implements IUserService {

    UserRepository userRepository;
    ModelMapper mapper;
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

    public UserResponse add(UserRequest request) {
        var user = mapper.map(request, User.class);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setId(UUID.randomUUID());
        var result = userRepository.save(mapper.map(user, User.class));
        return mapper.map(result, UserResponse.class);
    }

    @Operation(summary = "Get list of users")
    public PagedList<UserResponse> findAll(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        var result = userRepository.findAll(pageable);
        var content = result.getContent().stream().map(user -> mapper.map(user, UserResponse.class)).toList();
        var total = result.getTotalElements();
        return new PagedList<>(pageNumber, pageSize, content, total);
    }
}
