package com.job.portals.RozgarBazar.repository;

import com.job.portals.RozgarBazar.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByPhoneNumber(String phoneNumber);

    Optional<User> findByEmail(String email);

    boolean existsByPhoneNumber(String username);

    boolean existsByEmail(String email);


    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.mobileVerified = true WHERE u.phoneNumber = :phoneNumber")
    int verifyMobileByPhoneNumber(@Param("phoneNumber") String phoneNumber);
}