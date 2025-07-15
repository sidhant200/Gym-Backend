package com.example.Gym_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Gym_backend.entities.Member;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepo extends JpaRepository<Member, Long> {
    @Query(value = "select * from member_tb " +
     "where (:name is null or lower(name) like (concat('%' , :name , '%'))) " +
            "and (:email is null or lower(email) like (concat('%' , :email , '%')))" +
            "and (:phone is null or lower(phone) like (concat('%' , :phone , '%')))" +
            "and (:id is null or id = :id)" , nativeQuery = true)
    public List<Member> search(String name , String phone  , String email , Long id);



}
