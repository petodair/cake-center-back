package br.com.cake_center_back.mapper;

import br.com.cake_center_back.dto.user.UserRequestDTO;
import br.com.cake_center_back.dto.user.UserResponseDTO;
import br.com.cake_center_back.entity.User;

public class UserMapper {

    private UserMapper() {}

    public static User toEntity(UserRequestDTO dto) {
        User user = new User();
        user.setUsername(dto.username());
        user.setPassword(dto.password());
        user.setEmail(dto.email());
        return user;
    }

    public static UserResponseDTO toDTO(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getUsername()
        );
    }
}
