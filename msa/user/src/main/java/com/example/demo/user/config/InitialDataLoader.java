package com.example.demo.user.config;

import com.example.demo.user.entity.Role;
import com.example.demo.user.entity.UserEntity;
import com.example.demo.user.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class InitialDataLoader implements CommandLineRunner {
    private final UserRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public InitialDataLoader(UserRepository memberRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public void run(String... args) throws Exception {
        if (memberRepository.findByEmail("admin@naver.com").isPresent()) return;
        UserEntity member = UserEntity.builder()
                .nickname("admin")
                .email("admin@naver.com")
                .password(passwordEncoder.encode("12341234"))
                .roles(Set.of(Role.ADMIN))
                .build();
        memberRepository.save(member);
    }
}
