package com.nd705.suppointspb.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ProductDTO {
    private long id;
    private String title;
    private BigDecimal price;


}
