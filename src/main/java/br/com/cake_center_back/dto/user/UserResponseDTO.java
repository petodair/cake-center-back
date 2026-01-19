package br.com.cake_center_back.dto.user;

import br.com.cake_center_back.entity.Product;

import java.util.List;
import java.util.UUID;

public record UserResponseDTO(
        UUID id,
        String name,
        List<Product> products
) {
}
