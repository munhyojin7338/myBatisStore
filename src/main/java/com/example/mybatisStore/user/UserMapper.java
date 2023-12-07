package com.example.mybatisStore.user;

import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column="email" ,property="userEmail"),
            @Result(column="password" ,property="password" ),
            @Result(column="phone" ,property="phone"),
            @Result(column="age" ,property="age" ),
            @Result(column="address" ,property="address")
    })
    User findById(Long id);

    @Insert("INSERT INTO user (gender) VALUES (#{gender})") // 성별
    Enum stringUser(User user);

    @Update("UPDATE user SET username = #{username}, phone = #{phone} WHERE id = #{id}")
    String updateUser(User user);

    @Delete("DELETE FROM user WHERE id = #{id}")
    String deleteUser(Long id);
}
