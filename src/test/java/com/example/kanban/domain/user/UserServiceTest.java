package com.example.kanban.domain.user;

import com.example.kanban.domain.user.dto.SignupRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
class UserServiceTest {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    @DisplayName("유저 회원가입")
    void 회원가입(){
        // given
        for (int i = 1; i <= 100; i++) {
            SignupRequest request = new SignupRequest();
            request.setUserId("user" + i);
            request.setName("user"+i);
            request.setPassword("password" + i);
            request.setEmail("user" + i + "@test.com");

            userService.createUser(request);
        }
    }



}