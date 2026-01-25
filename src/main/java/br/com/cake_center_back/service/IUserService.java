package br.com.cake_center_back.service;

import br.com.cake_center_back.dto.ApiResponse;
import br.com.cake_center_back.dto.user.UserResponseDTO;
import br.com.cake_center_back.dto.user.UserRequestDTO;
import br.com.cake_center_back.entity.User;

import java.util.List;
import java.util.UUID;

public interface IUserService {
    public ApiResponse<User> save(UserRequestDTO userDTO);

    public ApiResponse<List<UserResponseDTO>> findAll();

    public ApiResponse<UserResponseDTO> findById(UUID id);

    public ApiResponse<UserResponseDTO> findByUsername(String username);

    public ApiResponse<Void> update(UserRequestDTO user);

    public ApiResponse<Void> delete(Long id);
}
