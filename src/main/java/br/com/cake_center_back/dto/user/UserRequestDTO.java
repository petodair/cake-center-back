package br.com.cake_center_back.dto.user;

import br.com.cake_center_back.entity.User;

public record UserRequestDTO(
        String username,
        String password,
        String email
) {
}
