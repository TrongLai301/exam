package com.example.exam1.repository;

import com.example.exam1.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products,Integer> {

    @Modifying
    @Query(value = "SELECT * FROM Products p WHERE p.price BETWEEN :minPrice AND :maxPrice",nativeQuery = true)
     List<Products> findByPriceBetween(double minPrice, double maxPrice );

    @Modifying
    @Query(value = "SELECT * FROM Products p ORDER BY p.price DESC LIMIT 3 ", nativeQuery = true)
    List<Products> findTop3New();

    @Modifying
    @Query(value = "SELECT * FROM Products p ORDER BY p.amount ASC", nativeQuery = true)
    List<Products> sort();


    @Modifying
    @Query(value = "SELECT * FROM Products p WHERE p.category_id = :categoryId", nativeQuery = true)
    List<Products> findByIdCategory(int categoryId);
}
