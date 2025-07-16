package com.example.Gym_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Gym_backend.entities.Member;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MemberRepo extends JpaRepository<Member, Long> {
    @Query(value = "select * from member_tb " +
     "where (:name is null or lower(name) like (concat('%' , :name , '%'))) " +
            "and (:email is null or lower(email) like (concat('%' , :email , '%')))" +
            "and (:phone is null or lower(phone) like (concat('%' , :phone , '%')))" +
            "and (:id is null or id = :id)" , nativeQuery = true)
    public List<Member> search(String name , String phone  , String email , Long id);
    @Query(value = "SELECT COUNT(*) FROM member_tb WHERE email = :email", nativeQuery = true)
    int countByEmail(@Param("email") String email);

    @Query(value = "SELECT COUNT(*) FROM member_tb WHERE phone = :phone", nativeQuery = true)
    int countByPhone(@Param("phone") String phone);

    @Query(value = "SELECT COUNT(*) FROM member_tb WHERE email = :email OR phone = :phone", nativeQuery = true)
    int countByEmailOrPhone(@Param("email") String email, @Param("phone") String phone);



}
