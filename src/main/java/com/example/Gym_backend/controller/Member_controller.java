package com.example.Gym_backend.controller;

import com.example.Gym_backend.dto.MemberDto;
import com.example.Gym_backend.dto.MemberDtoForId;
import com.example.Gym_backend.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Gym_backend.entities.Member;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class Member_controller {
    @Autowired
    private MemberService memberService;

    @GetMapping("member")
    public List<MemberDtoForId> getAllMembers(Member member){
        return memberService.readMembers();

    }

    @PostMapping("member")
    public ResponseEntity<MemberDto> createMember(@RequestBody MemberDto memberdto){
       MemberDto created =  memberService.createMember(memberdto);
        return ResponseEntity.ok(created);
    }

    @DeleteMapping("member/{id}")
    public ResponseEntity<?> deleteMember(@PathVariable long id){
        memberService.deleteMember(id);
        return ResponseEntity.ok("Successfully deleted");
    }

    @PutMapping("members/{id}")
    public ResponseEntity<MemberDtoForId> updateMember(@PathVariable long id , @RequestBody MemberDtoForId memberdtoforid){
       MemberDtoForId updated =   memberService.updateMember(id , memberdtoforid);
       return ResponseEntity.ok(updated);

    }

    @GetMapping("member/search")
    public List<Member> searchBy(@RequestParam(required = false) String name,
                                 @RequestParam(required = false) String email,
                                 @RequestParam(required = false) String phone,
                                  @RequestParam(required = false) Long id){

        return memberService.search(name , phone , email , id);

    }
}
