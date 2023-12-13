package com.example.mybatisStore.user;

import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE id = #{id}")
    @ResultMap("userResultMap")
    User findById(Long id); // id에 해당하는 사용자를 검색

    @Insert("INSERT INTO user (id, username, email, password, phone, age, address) VALUES (#{id}, #{username}, #{email}, #{encodedPassword}, #{phone}, #{age}, #{address})")
    int insertUser(@Param("encodedPassword") String encodedPassword, User user);


    @Update("UPDATE user SET username = #{username}, phone = #{phone} WHERE id = #{id}")
    int updateUser(User user); // id에 해당하는 사용자의 정보를 업데이트

    @Delete("DELETE FROM user WHERE id = #{id}")
    int deleteUser(Long id); // id에 해당하는 사용자를 데이터베이스에서 삭제

    boolean existsByEmail(String email);

}
