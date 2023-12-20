package com.example.mybatisStore.user;

import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE id = #{id}")
    User findById(Long id); // id에 해당하는 사용자를 검색

    @Insert("INSERT INTO user (id, username, email, password, phone, age, address) VALUES (#{id}, #{username}, #{email}, #{password}, #{phone}, #{age}, #{address})")
    int insertUser(User user); //  회원정보 데이터 삽입

    @Update("UPDATE user SET username = #{username}, phone = #{phone} WHERE id = #{id}")
    int updateUser(User user); // id에 해당하는 사용자의 정보를 업데이트

    @Delete("DELETE FROM user WHERE id = #{id}")
    int deleteUser(Long id); // id에 해당하는 사용자를 데이터베이스에서 삭제

    @Select("SELECT COUNT(*) FROM user WHERE email = #{email}")
    int checkEmailDuplicate(String email);
}
