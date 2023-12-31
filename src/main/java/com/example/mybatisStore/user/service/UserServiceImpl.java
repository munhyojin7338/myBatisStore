package com.example.mybatisStore.user.service;

import com.example.mybatisStore.user.User;
import com.example.mybatisStore.user.repository.UserMapper;
import com.example.mybatisStore.user.UserSignup;
import com.example.mybatisStore.user.exception.DuplicateEmailException;
import com.example.mybatisStore.user.exception.LoginErrorException;
import com.example.mybatisStore.user.jwt.JwtTokenProvider;
import com.example.mybatisStore.user.jwt.TokenInfo;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    @Transactional
    public Long getSignup(UserSignup userSignup) {
        LOGGER.info("사용자 등록 시도: {}", userSignup);
        System.out.println("UserSignup: " + userSignup);
        System.out.println("1");
        try {
            // 추가: email 중복 검사
            if (userMapper.checkEmailDuplicate(userSignup.getEmail()) > 0) {

                throw new DuplicateEmailException("이미 사용 중인 이메일입니다.");
            }

            User user = User.builder()
                    .username(userSignup.getUsername())
                    .email(userSignup.getEmail())
                    .password(userSignup.getPassword())
                    .phone(userSignup.getPhone())
                    .age(userSignup.getAge())
                    .address(userSignup.getAddress())
                    .build();

            LOGGER.info("생성된 사용자: {}", user);
            System.out.println("2: " + user );

            userMapper.insertUser(user);

            LOGGER.info("사용자 등록 성공: {}", user);
            return user.getId();
        } catch (DuplicateEmailException e) {
            LOGGER.warn("이미 사용 중인 이메일로의 가입 시도: {}", userSignup.getEmail());
            // 중복된 이메일에 대한 처리를 수행 (예: 예외처리, 메시지 반환 등)
            return null;
        } catch (Exception e) {
            LOGGER.error("사용자 등록 중 오류 발생", e);
            return null;
        }
    }


    @Override
    @Transactional
    public TokenInfo getLogin(String email, String password) {
        try {
            LOGGER.info("로그인 시도: {}", email);

            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email, password);

            // 2. 실제 검증 (사용자 비밀번호 체크)이 이루어지는 부분
            // authenticate 메서드가 실행될 때 CustomUserDetailsService 에서 만든 loadUserByUsername 메서드가 실행
            Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

            // 3. 인증 정보를 기반으로 JWT 토큰 생성
            TokenInfo tokenInfo = jwtTokenProvider.generateToken(authentication);

            return tokenInfo;

        } catch (Exception e) {
            LOGGER.error("로그인 에러: 자격 증명에 실패하였습니다. {}", e.getMessage());
            throw new LoginErrorException("로그인에 실패하였습니다.", e); // 적절한 예외 처리로 변경
        }
    }

}
