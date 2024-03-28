package com.team1.service.productService;

import com.team1.model.dto.ProductDto;
import com.team1.model.entity.MemberEntity;
import com.team1.model.entity.ProductEntity;
import com.team1.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public boolean uploadProduct(ProductDto productDto){
        System.out.println(productDto);
        if(productRepository.findBypname(productDto.getPname()) != null){
            System.out.println("중복이있습니다");
            return false;
        }
        ProductEntity productEntity = productRepository.save(productDto.toEntity());
        if (productEntity.getPno() > 0){
            return true;
        }
        return false;
    }

    public List<ProductDto> productDtoList(){

        List<ProductEntity> memberEntityList =productRepository.findAll();
        List<ProductDto> result = memberEntityList.stream().map((e) -> {return e.toDto();}).collect(Collectors.toList());

        return result;
    }
}
