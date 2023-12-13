package com.example.mybatisStore.user;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService{

    private final UserMapper userMapper;

    private final LoginCheckService loginCheckService;

    @Override
    @Transactional
    public Long getSignup(UserSignup userSignup) {

        // 회원가입 진행 시 email이 중복되었는지 확인한다.
        boolean isEmailDup = loginCheckService.checkEmail(userSignup.getEmail());

        if (isEmailDup) {
            return null;
        }
        System.out.println("1");
        User user = User.builder()
                .username(userSignup.getUsername())
                .email(userSignup.getEmail())
                .password(userSignup.getPassword())
                .phone(userSignup.getPhone())
                .age(userSignup.getAge())
                .address(userSignup.getAddress())
                .build();

        System.out.println("2");
        userMapper.insertUser(user); // userMapper 데이터 정보 저장

        System.out.println(user);
        return user.getId(); // 새로 생성된 사용자의 ID 반환
    }
}
