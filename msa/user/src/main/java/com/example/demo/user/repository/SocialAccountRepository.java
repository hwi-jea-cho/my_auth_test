package com.example.demo.user.repository;

import com.example.demo.user.entity.UserSocialAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialAccountRepository extends JpaRepository<UserSocialAccountEntity, String> {
}
