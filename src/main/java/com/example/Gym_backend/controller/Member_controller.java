package com.example.Gym_backend.controller;

import com.example.Gym_backend.dto.MemberDto;
import com.example.Gym_backend.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.Gym_backend.entities.Member;

import java.util.List;

@RestController

public class Member_controller {
    @Autowired
    private MemberService memberService;

    @GetMapping("member")
    public List<MemberDto> getAllMembers(Member member){
        return memberService.readMembers();

    }

    @PostMapping("member")
    public String createMember(@RequestBody Member member){
        memberService.createMember(member);
        return "created succesfull";
    }

    @DeleteMapping("member/{id}")
    public String deleteMember(@RequestParam long id){
        memberService.deleteMember(id);
        return "deleted succesfull";
    }

    @PutMapping("member/{id}")
    public String updateMember(@RequestParam long id){
    }
}
