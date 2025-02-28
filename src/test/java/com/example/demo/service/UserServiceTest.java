/*
 * package com.example.demo.service;
 * 
 * import com.example.demo.entity.User; import com.example.demo.model.PagedList;
 * import com.example.demo.model.request.UserRequest; import
 * com.example.demo.model.response.UserResponse; import
 * com.example.demo.repository.UserRepository; import
 * com.example.demo.services.UserService; import org.junit.jupiter.api.*; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.boot.test.mock.mockito.MockBean; import
 * org.springframework.data.domain.Page; import
 * org.springframework.data.domain.PageImpl; import
 * org.springframework.data.domain.PageRequest; import
 * org.springframework.data.domain.Pageable;
 * 
 * import java.time.LocalDate; import java.util.ArrayList; import
 * java.util.List; import java.util.UUID;
 * 
 * import static org.junit.jupiter.api.Assertions.assertEquals; import static
 * org.junit.jupiter.api.Assertions.assertNotNull; import static
 * org.mockito.ArgumentMatchers.any; import static org.mockito.Mockito.doReturn;
 * 
 * @SpringBootTest public class UserServiceTest {
 * 
 * @Autowired private UserService userService;
 * 
 * @MockBean private UserRepository userRepository;
 * 
 * private UserRequest userRequest; private UserResponse userResponse; private
 * User usersEntity;
 * 
 * @BeforeEach void initData() { LocalDate birthday = LocalDate.of(2000, 1, 16);
 * UUID userId = UUID.randomUUID(); userRequest = UserRequest.builder()
 * .username("john") .fullName("John") .email("Doe@gmail.com")
 * .password("12345678") .birthday(birthday) .build();
 * 
 * userResponse = UserResponse.builder() .id(userId) .username("john")
 * .fullName("John") .email("Doe@gmail.com") .birthday(birthday)
 * .usernameTestMapping("john") .build();
 * 
 * usersEntity = User.builder() .id(userId) .username("john") .fullName("John")
 * .email("Doe@gmail.com") .password("12345678") .birthday(birthday) .build(); }
 * 
 * @Test void createUser_validRequest_success() { // GIVEN
 * doReturn(usersEntity).when(userRepository).save(any());
 * 
 * // WHEN UserResponse userResponse = userService.add(userRequest);
 * 
 * // THEN assertNotNull(userResponse, "UserResponse should not be null");
 * assertEquals("john", userResponse.getUsername(), "Names should match"); }
 * 
 * @Test void findAllUser_validRequest_success() { // GIVEN List<User>
 * usersEntityList = new ArrayList<>(); usersEntityList.add(usersEntity);
 * Pageable pageable = PageRequest.of(0, 10); Page<User> usersEntityPage = new
 * PageImpl<>(usersEntityList, pageable, usersEntityList.size());
 * doReturn(usersEntityPage).when(userRepository).findAll(pageable);
 * 
 * // WHEN PagedList<UserResponse> userResponsePagedList =
 * userService.findAll(1, 10);
 * 
 * // THEN assertNotNull(userResponsePagedList,
 * "userResponsePagedList should not be null"); assertEquals(1,
 * userResponsePagedList.getPage(), "Page should match"); assertEquals(10,
 * userResponsePagedList.getSize(), "Size should match"); } }
 */