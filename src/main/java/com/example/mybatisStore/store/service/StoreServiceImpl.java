package com.example.mybatisStore.store.service;



import com.example.mybatisStore.store.Store;
import com.example.mybatisStore.store.StoreRepository;
import com.example.mybatisStore.store.dto.StoreRegisterDto;
import com.example.mybatisStore.user.User;
import com.example.mybatisStore.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService{
    private final StoreRepository storeRepository;

    private final UserRepository userRepository;

    @Override
    @Transactional
    public Long getCreate(StoreRegisterDto registerDto) {
        User user = userRepository.findByEmail("DONE@gmail.com")
                .orElseThrow(() -> new RuntimeException("User not found")); // 사용자가 존재하지 않으면 예외 처리

        Store store = Store.builder() // 상품 판매 등록
                .userId(user) // user 정보 , 판매자 정보
                .productName(registerDto.getProductName()) // 상품 이름
                .productImage(registerDto.getProductImage()) // 상품 이미지
                .prices(registerDto.getPrices()) // 상품 가격
                .build();
        storeRepository.save(store);
        return store.getProductId();
    }
}
