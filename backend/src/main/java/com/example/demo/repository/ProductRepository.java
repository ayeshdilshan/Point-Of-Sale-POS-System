package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findByCategoryName(String categoryName);

    @Query(value = "SELECT * FROM product ORDER BY unit_Price DESC LIMIT 5" , nativeQuery = true)
    List<Product> findTop5ExpensiveProducts();

}
