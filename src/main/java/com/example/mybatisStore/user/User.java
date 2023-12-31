package com.example.mybatisStore.user;


import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String username;
    @Column
    private String email; // 로그인 할 때 ID
    @Column
    private String password;
    @Column
    private String phone;
    @Column
    private String age;
    @Column
    private String address;

    // 새로운 toString 메서드 추가
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password= '" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }


    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    // 계정이 만료되지 않았는가?
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }


    // 계정이 잠금상태이가??
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }


    // 비밀번호가 만료되지 않았는가??
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }


    // 계정이 활성화 되었는가??
    @Override
    public boolean isEnabled() {
        return true;
    }
}
