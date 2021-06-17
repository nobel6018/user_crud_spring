package com.cloudy.simplespring.service;

import com.cloudy.simplespring.domain.User;
import com.cloudy.simplespring.exception.UserNotFoundException;
import com.cloudy.simplespring.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional // for rollback in test code
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("회원가입")
    public void signup() {
        // given
        User user = new User();
        user.setAccountId("test_id");
        user.setPassword("complexPassword");

        // when
        Long savedId = userService.signUp(user);

        // then
        User savedUser = userService.findOne(savedId);
        assertThat(savedUser).isEqualTo(user);
    }

    @Test
    @DisplayName("비밀번호 업데이트")
    public void updatePassword() {
        // given
        User user = new User();
        user.setAccountId("test_id");
        user.setPassword("initialPassword");

        // when
        Long savedId = userService.signUp(user);
        userService.updatePassword(user.getId(), "newPassword");

        // then
        User updatedUser = userService.findOne(savedId);
        assertThat(updatedUser).isEqualTo(user);
        assertThat(updatedUser.getPassword()).isEqualTo("newPassword");
    }

    @Test
    @DisplayName("회원 삭제")
    public void deleteUser() {
        // given
        User user = new User();
        user.setAccountId("test_id");
        user.setPassword("initialPassword");

        // when
        Long savedId = userService.signUp(user);
        userService.delete(savedId);

        Throwable e = assertThrows(UserNotFoundException.class, () -> {
            userService.findOne(savedId);
        });

        // then
        assertEquals("User 1 doesn't exist", e.getMessage());
    }

}