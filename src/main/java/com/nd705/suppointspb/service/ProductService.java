package com.nd705.suppointspb.service;

import com.nd705.suppointspb.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAll();
    void addToUserBucket(Long productId, String username);
}
