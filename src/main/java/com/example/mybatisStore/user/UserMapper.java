package com.example.mybatisStore.user;

import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("SELECT * id, username, email, password, phone, age, address " +
            "FROM user WHERE id = #{id}")
    @ResultMap("userResultMap")
    User findById(Long id);

    @Insert("INSERT INTO user (gender) VALUES (#{gender})") // 성별
    Enum stringUser(User user);

    @Update("UPDATE user SET username = #{username}, phone = #{phone} WHERE id = #{id}")
    String updateUser(User user);

    @Delete("DELETE FROM user WHERE id = #{id}")
    String deleteUser(Long id);
}
