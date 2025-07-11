package com.example.Gym_backend.service;
import com.example.Gym_backend.dto.MemberDto;
import com.example.Gym_backend.dto.MemberDto;
import com.example.Gym_backend.entities.Member;
import java.util.List;

public interface MemberService {
    boolean deleteMember(Long id);
    Member createMember(Member member);
    List<MemberDto> readMembers();
    MemberDto updateMember(Long id);





}
