package com.nd705.suppointspb.dao;

import com.nd705.suppointspb.entity.shop.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
