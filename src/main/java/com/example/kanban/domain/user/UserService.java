package com.example.kanban.domain.user;

import com.example.kanban.domain.user.dto.SignupRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    // 8자리 UUID 생성 유틸
    private String generateShortUuid(){
        return UUID.randomUUID().toString().replace("-","").substring(0,8);
    }

    @Transactional
    public User createUser(SignupRequest request) {
        User user = User.builder()
                .id(generateShortUuid())
                .username(request.getUserId())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .name(request.getName())
                .build();
        return userRepository.save(user);
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public User getUserById(UUID uuid) {
        return userRepository.findById(uuid).orElse(null);
    }
}
