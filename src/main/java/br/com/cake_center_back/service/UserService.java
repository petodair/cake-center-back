package br.com.cake_center_back.service;

import br.com.cake_center_back.dto.ApiResponse;
import br.com.cake_center_back.dto.user.UserResponseDTO;
import br.com.cake_center_back.dto.user.UserRequestDTO;
import br.com.cake_center_back.entity.User;
import br.com.cake_center_back.mapper.UserMapper;
import br.com.cake_center_back.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService implements IUserService{

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ApiResponse<User> save(UserRequestDTO userDTO) {
        boolean existsByEmail = this.userRepository.existsByEmail(userDTO.email());
        User user;
        if(existsByEmail) {
            throw new RuntimeException("Email already exists");
        }
        user = this.userRepository.save(UserMapper.toEntity(userDTO));
        return new ApiResponse<>(
                ApiResponse.ResponseStatusType.SUCCESS,
                HttpStatus.CREATED,
                user,
                "Usuário criado com sucesso"
        );
    }

    @Override
    public ApiResponse<List<UserResponseDTO>> findAll() {
        return null;
    }

    @Override
    public ApiResponse<UserResponseDTO> findById(UUID id) {
        return null;
    }

    @Override
    public ApiResponse<UserResponseDTO> findByUsername(String username) {
        return null;
    }

    @Override
    public ApiResponse<Void> update(UserRequestDTO user) {
        return null;
    }

    @Override
    public ApiResponse<Void> delete(Long id) {
        return null;
    }
}
