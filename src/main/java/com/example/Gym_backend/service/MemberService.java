package com.example.Gym_backend.service;
import com.example.Gym_backend.dto.MemberDto;
import com.example.Gym_backend.dto.MemberDto;
import com.example.Gym_backend.dto.MemberDtoForId;
import com.example.Gym_backend.entities.Member;
import java.util.List;

public interface MemberService {
    boolean deleteMember(Long id);
    MemberDto createMember(MemberDto memberDto);
    List<MemberDtoForId> readMembers();
    MemberDto updateMember(Long id , MemberDto dto);





}
