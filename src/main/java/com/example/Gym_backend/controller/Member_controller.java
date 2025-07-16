package com.example.Gym_backend.controller;

import com.example.Gym_backend.dto.MemberDto;
import com.example.Gym_backend.dto.MemberDtoForId;
import com.example.Gym_backend.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<?> createMember(@RequestBody MemberDto memberdto) {
        try {

            MemberDto created = memberService.createMember(memberdto);
            return ResponseEntity.ok(created);
        }  catch (DataIntegrityViolationException e) {
            // This means duplicate key error
            return ResponseEntity.status(409).body("Duplicate member data: Email or Phone already exists.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("duplicate data exists");
        }
    }

    @DeleteMapping("member/{id}")
    public ResponseEntity<?> deleteMember(@PathVariable long id){
        memberService.deleteMember(id);
        return ResponseEntity.ok("Successfully deleted");
    }
    @PutMapping("member/{id}")
    public ResponseEntity<?> updateMember(@PathVariable long id , @RequestBody MemberDtoForId memberdtoforid) {
        try {
            MemberDtoForId updated = memberService.updateMember(id, memberdtoforid);
            return ResponseEntity.ok(updated);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(409).body("Duplicate member data: Email or Phone already exists.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("duplicate data exists");
        }
    }

    @GetMapping("member/search")
    public List<Member> searchBy(@RequestParam(required = false) String name,
                                 @RequestParam(required = false) String email,
                                 @RequestParam(required = false) String phone,
                                  @RequestParam(required = false) Long id){

        return memberService.search(name , phone , email , id);

    }
}
