/*
 * package com.example.demo.controller;
 * 
 * import com.example.demo.util.ApiResultStatus; import
 * com.example.demo.model.PagedList; import
 * com.example.demo.model.request.UserRequest; import
 * com.example.demo.model.response.UserResponse; import
 * com.example.demo.services.UserService; import
 * com.fasterxml.jackson.databind.ObjectMapper; import
 * com.fasterxml.jackson.datatype.jsr310.JavaTimeModule; import
 * org.junit.jupiter.api.BeforeEach; import org.junit.jupiter.api.Test; import
 * org.mockito.Mockito; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
 * import org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.boot.test.mock.mockito.MockBean; import
 * org.springframework.http.MediaType; import
 * org.springframework.security.core.Authentication; import
 * org.springframework.security.core.authority.SimpleGrantedAuthority; import
 * org.springframework.security.core.GrantedAuthority; import
 * org.springframework.security.core.context.SecurityContext; import
 * org.springframework.security.core.context.SecurityContextHolder; import
 * org.springframework.test.web.servlet.MockMvc; import
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders; import
 * org.springframework.test.web.servlet.result.MockMvcResultMatchers; import
 * org.springframework.security.test.context.support.WithMockUser;
 * 
 * import java.time.LocalDate; import java.util.*;
 * 
 * import static org.mockito.ArgumentMatchers.any; import static
 * org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
 * 
 * @SpringBootTest
 * 
 * @AutoConfigureMockMvc public class UserControllerTest {
 * 
 * @Autowired private MockMvc mockMvc;
 * 
 * @MockBean private UserService userService;
 * 
 * private UserRequest userRequest; private UserResponse userResponse;
 * 
 * @BeforeEach void initData() {
 * 
 * LocalDate birthday = LocalDate.of(2000, 1, 16); UUID userId =
 * UUID.randomUUID(); userRequest = UserRequest.builder() .username("john")
 * .fullName("John") .email("Doe@gmail.com") .password("12345678")
 * .birthday(birthday) .build();
 * 
 * userResponse = UserResponse.builder() .id(userId) .username("john")
 * .fullName("John") .email("Doe@gmail.com") .birthday(birthday) .build(); }
 * 
 * @Test
 * 
 * @WithMockUser(authorities = "APPROLE_Admin") void
 * createUser_validRequest_success() throws Exception {
 * 
 * // GIVEN ObjectMapper mapper = new ObjectMapper(); mapper.registerModule(new
 * JavaTimeModule()); String content = mapper.writeValueAsString(userRequest);
 * 
 * Mockito.when(userService.add(any())) .thenReturn(userResponse);
 * 
 * //WHEN, THEN mockMvc.perform(MockMvcRequestBuilders .post("/api/user")
 * .contentType(MediaType.APPLICATION_JSON_VALUE) .content(content))
 * .andExpect(MockMvcResultMatchers.status().isOk())
 * .andExpect(jsonPath("status") .value(ApiResultStatus.SUCCESS.name()));
 * 
 * }
 * 
 * @Test
 * 
 * @WithMockUser(authorities = "APPROLE_Admin") void
 * findAllUser_validRequest_success() throws Exception {
 * 
 * // GIVEN List<UserResponse> userResponseList = new ArrayList<>();
 * userResponseList.add(userResponse); PagedList<UserResponse>
 * userResponsePagedList = new PagedList<UserResponse>();
 * userResponsePagedList.setPage(1); userResponsePagedList.setSize(10);
 * userResponsePagedList.setTotal(1);
 * userResponsePagedList.setData(userResponseList);
 * 
 * ObjectMapper mapper = new ObjectMapper(); mapper.registerModule(new
 * JavaTimeModule()); String content =
 * mapper.writeValueAsString(userResponsePagedList);
 * Mockito.when(userService.findAll(1, 10)) .thenReturn(userResponsePagedList);
 * 
 * //WHEN, THEN mockMvc.perform(MockMvcRequestBuilders .get("/api/user")
 * .contentType(MediaType.APPLICATION_JSON_VALUE) .content(content))
 * .andExpect(MockMvcResultMatchers.status().isOk())
 * .andExpect(jsonPath("status") .value(ApiResultStatus.SUCCESS.name()));
 * 
 * } }
 */