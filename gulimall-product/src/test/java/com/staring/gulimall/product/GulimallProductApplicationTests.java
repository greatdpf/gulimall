package com.staring.gulimall.product;

import com.staring.gulimall.product.entity.BrandEntity;
import com.staring.gulimall.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class GulimallProductApplicationTests {
    @Resource
    BrandService brandService;

    @Test
    public void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setDescript("ces");
        brandEntity.setName("华为");
        brandService.save(brandEntity);
        System.out.println("success");
    }

}
