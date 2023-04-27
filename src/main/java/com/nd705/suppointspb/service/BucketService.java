package com.nd705.suppointspb.service;

import com.nd705.suppointspb.dto.BucketDTO;
import com.nd705.suppointspb.entity.User;
import com.nd705.suppointspb.entity.shop.Bucket;

import java.util.List;

public interface BucketService {
    Bucket createBucket(User user, List<Long> productIds);
    void addProducts(Bucket bucket, List<Long> productsIds);
    BucketDTO getBucketByUser(String name);
}
