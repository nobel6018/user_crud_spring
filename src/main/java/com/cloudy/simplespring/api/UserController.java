package com.cloudy.simplespring.api;

import com.cloudy.simplespring.domain.User;
import com.cloudy.simplespring.dto.*;
import com.cloudy.simplespring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/api/v1/users")
    public CreateUserResponse signUpUser(
        @RequestBody CreateUserRequest userInfo
    ) {
        User user = new User();
        user.setAccountId(userInfo.getId());
        user.setPassword(userInfo.getPassword());

        Long id = userService.signUp(user);

        return new CreateUserResponse(id);
    }

    @PutMapping("/api/v1/users/{id}/password")
    public UpdateUserPasswordResponse updatePassword(
        @PathVariable Long id,
        @RequestBody UpdateUserPasswordRequest passwordInfo
    ) {
        userService.updatePassword(id, passwordInfo.getPassword());
        User user = userService.findOne(id);

        return new UpdateUserPasswordResponse(user.getId());
    }

    @DeleteMapping("/api/v1/users/{id}")
    public DeleteUserResponse deleteUser(
        @PathVariable Long id
    ) {
        userService.delete(id);

        return new DeleteUserResponse("deleted");
    }
}
