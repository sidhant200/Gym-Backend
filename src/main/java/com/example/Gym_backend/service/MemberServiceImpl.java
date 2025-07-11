package com.example.Gym_backend.service;

import com.example.Gym_backend.dto.MemberDto;

import com.example.Gym_backend.repository.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Gym_backend.entities.Member;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class MemberServiceImpl implements MemberService{
    @Autowired
    private MemberRepo memberRepo;
    @Override
    public boolean deleteMember(Long id) {
        memberRepo.deleteById(id);
        return true;

    }


    @Override
    public Member createMember(Member member) {
      return memberRepo.save(member);

    }

    @Override
    public List<MemberDto> readMembers() {
       List<Member> members= memberRepo.findAll();
       return members.stream()
               .map(this::converttoDTO)
               .collect(Collectors.toList());

    }

    @Override
    public MemberDto updateMember(Long id) {


    }

    private MemberDto converttoDTO(Member member) {
        MemberDto dto = new MemberDto();
        dto.setId(member.getId());
        dto.setEmail(member.getEmail());
        dto.setPhone(member.getPhone());
        dto.setName(member.getName());
        return dto;

    }
}
