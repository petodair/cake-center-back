package br.com.cake_center_back.service;

import br.com.cake_center_back.dto.ApiResponse;
import br.com.cake_center_back.dto.user.UserResponseDTO;
import br.com.cake_center_back.dto.user.UserResquestDTO;

import java.util.List;

public interface IUserService {
    public ApiResponse<Void> save(UserResponseDTO user);

    public ApiResponse<List<UserResponseDTO>> findAll();

    public ApiResponse<UserResponseDTO> findById(Long id);

    public ApiResponse<UserResponseDTO> findByUsername(String username);

    public ApiResponse<Void> update(UserResquestDTO user);

    public ApiResponse<Void> delete(Long id);
}
