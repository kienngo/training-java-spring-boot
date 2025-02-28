package com.example.demo.controller;

import com.example.demo.model.ApiBaseResponse;
import com.example.demo.model.PagedList;
import com.example.demo.model.request.UserRequest;
import com.example.demo.model.response.UserResponse;
import com.example.demo.services.interfaces.IUserService;
import com.example.demo.util.ApiResultStatus;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("/api/user")
@Validated
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {

    IUserService userServices;

    private final MessageSource messageSource;

    @Operation(summary = "Get list of users")
    @GetMapping
    @ResponseBody
    @PreAuthorize("hasAuthority('APPROLE_Admin')")
    public ResponseEntity<ApiBaseResponse<PagedList<UserResponse>>> get(
            @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        PagedList<UserResponse> response = userServices.findAll(pageNumber, pageSize);
        return ResponseEntity.ok().body(
                ApiBaseResponse.<PagedList<UserResponse>>builder()
                        .status(ApiResultStatus.SUCCESS)
                        .message(messageSource.getMessage("get_all_user_success",
                                null, Locale.forLanguageTag("en")))
                        .data(response)
                        .build()
        );
    }

    @Operation(summary = "Create user")
    @PostMapping
    @ResponseBody
    @PreAuthorize("hasAuthority('APPROLE_Admin')")
    public ResponseEntity<ApiBaseResponse<UserResponse>> add(@RequestBody @Valid UserRequest user) {
        UserResponse response = userServices.add(user);
        return ResponseEntity.ok().body(
                ApiBaseResponse.<UserResponse>builder()
                        .status(ApiResultStatus.SUCCESS)
                        .message(messageSource.getMessage("add_user_success",
                                null, Locale.forLanguageTag("en")))
                        .data(response)
                        .build()
        );
    }
}
