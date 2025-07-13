package com.example.Gym_backend.service;
import com.example.Gym_backend.dto.MemberDtoForId;
import com.example.Gym_backend.entities.Member;

import com.example.Gym_backend.dto.MemberDto;

import com.example.Gym_backend.repository.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    public MemberDto createMember(MemberDto memberDto) {
        Member member = new Member();
        member.setName(memberDto.getName());
        member.setEmail(memberDto.getEmail());
        member.setPhone(memberDto.getPhone());
        member.setMembershipType(memberDto.getMembershipType());

        Member saved = memberRepo.save(member);
        return new MemberDto(saved.getName(), saved.getPhone(), saved.getEmail() , saved.getMembershipType());


    }

    @Override
    public List<MemberDtoForId> readMembers() {
       List<Member> members= memberRepo.findAll();
       return members.stream()
               .map(this::converttoDTOForId)
               .collect(Collectors.toList());

    }

    @Override
    public MemberDtoForId updateMember(Long id , MemberDtoForId dto) {
        Member existedMember = memberRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("id not found " + id));
        existedMember.setName(dto.getName());
        existedMember.setPhone(dto.getPhone());
        existedMember.setEmail(dto.getEmail());
        existedMember.setMembershipType(dto.getMembershipType());

        Member updated  = memberRepo.save(existedMember);
        return converttoDTOForId(updated);
    }


    private MemberDto converttoDTO(Member member) {
        MemberDto dto = new MemberDto();
        dto.setEmail(member.getEmail());
        dto.setPhone(member.getPhone());
        dto.setName(member.getName());
        dto.setMembershipType(member.getMembershipType());
        return dto;

    }
    private MemberDtoForId converttoDTOForId(Member member) {
        MemberDtoForId dto = new MemberDtoForId();
        dto.setId(member.getId());
        dto.setEmail(member.getEmail());
        dto.setPhone(member.getPhone());
        dto.setName(member.getName());
        dto.setMembershipType(member.getMembershipType());
        return dto;
    }

}
