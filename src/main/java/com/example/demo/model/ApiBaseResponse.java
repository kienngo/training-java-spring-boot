package com.example.demo.model;

import com.example.demo.util.ApiResultStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApiBaseResponse<T> {
	ApiResultStatus status;
    String message;
    T data;
}
