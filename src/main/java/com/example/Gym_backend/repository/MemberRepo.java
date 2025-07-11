package com.example.Gym_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Gym_backend.entities.Member;

public interface MemberRepo extends JpaRepository<Member, Long> {

}
