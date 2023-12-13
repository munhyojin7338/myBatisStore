package com.example.mybatisStore.user;


import com.example.mybatisStore.user.jwt.JwtTokenProvider;
import com.example.mybatisStore.user.jwt.TokenInfo;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService{

    private final UserMapper userMapper;

    private final LoginCheckService loginCheckService;

    private final PasswordEncoder passwordEncoder;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    private final JwtTokenProvider jwtTokenProvider;


    @Override
    @Transactional
    public Long getSignup(UserSignup userSignup) {

        try {
            // 회원가입 진행 시 email이 중복되었는지 확인
            boolean isEmailDup = loginCheckService.checkEmail(userSignup.getEmail());

            if (isEmailDup) {
                return null;
            }

            // 비밀번호를 암호화하여 저장
            String encodedPassword = passwordEncoder.encode(userSignup.getPassword());

            User user = User.builder()
                    .username(userSignup.getUsername())
                    .email(userSignup.getEmail())
                    .password(encodedPassword)  // 암호화된 비밀번호 저장
                    .phone(userSignup.getPhone())
                    .age(userSignup.getAge())
                    .address(userSignup.getAddress())
                    .build();

            userMapper.insertUser(encodedPassword, user);

            // 새로운 사용자 정보 로깅
            LOGGER.info("새로운 사용자 등록: {}", user);

            return user.getId(); // 새로 생성된 사용자의 ID 반환
        } catch (Exception e) {
            LOGGER.error("사용자 등록 중 오류 발생", e);
            return null;
        }
    }

    @Transactional
    public TokenInfo getLogin(String email, String password) {
        // 1. Login ID/PW 를 기반으로 Authentication 객체 생성
        // 이때 authentication 는 인증 여부를 확인하는 authenticated 값이 false
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email, password);

        // 2. 실제 검증 (사용자 비밀번호 체크)이 이루어지는 부분
        // authenticate 매서드가 실행될 때 CustomUserDetailsService 에서 만든 loadUserByUsername 메서드가 실행
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // 3. 인증 정보를 기반으로 JWT 토큰 생성
        TokenInfo tokenInfo = jwtTokenProvider.generateToken(authentication);

        return tokenInfo;
    }
}
