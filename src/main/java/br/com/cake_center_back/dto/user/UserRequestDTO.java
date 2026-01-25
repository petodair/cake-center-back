package br.com.cake_center_back.dto.user;

import br.com.cake_center_back.entity.User;

public record UserRequestDTO(
        String username,
        String password,
        String email
) {
    public User toEntity() {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        return user;
    }
}
