package com.example.demo.config.mapping;

import com.example.demo.entity.User;
import com.example.demo.model.response.UserResponse;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.createTypeMap(User.class, UserResponse.class).addMappings(mapper ->
                mapper.map(User::getUsername, UserResponse::setUsernameTestMapping)
        );

        return modelMapper;
    }
}
