package com.example.mybatisStore.user;


import com.example.mybatisStore.store.Store;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

/*
 User 객체가 여러개의 상품을 등록 할 수 있으니까
 1:N 관계 (양방향)
 Many To One: 다대일 (N : 1)
 One To Many: 일대다 (1 : N)

 User 객체가 여러개의 댓글을 등록 할 수 있다 (업데이트 예정)
 */
@Getter
@Builder // 빌더 패턴
@NoArgsConstructor // 빈 생성자
@AllArgsConstructor // 전체 생성자
@Entity
public class User implements UserDetails {

    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // auto_increment

    @Column(nullable = false, length = 50)
    private String username;

    @Column(nullable = false, length = 100)
    private String email; // 로그인 할 때 ID

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String age;

    @Column
    private String address;

    /* DB에는 RoleType이라는게 없어서 이걸 붙여줘야함
    Enum으로 만들면 실수를 줄일 수 있다. Enum은 주로 데이터의 도메인을 만들 때 사용한다
    */
    @Enumerated(EnumType.STRING)
    private RoleType role;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Store> stores;


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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
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
