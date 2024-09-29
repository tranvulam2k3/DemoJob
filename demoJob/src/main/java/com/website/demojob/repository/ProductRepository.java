package com.website.demojob.repository;

import com.website.demojob.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.math.BigDecimal;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {

    @Query("select p from Product p where p.IDProduct = :IDProduct")
    Product findProductByID(int IDProduct);

    @Query("select p from Product p where p.IDProduct= :IDProduct and p.Color= :Color and p.Size = :Size")
    Product checkProduct(int IDProduct, String Color, String Size);


    @Query("SELECT p FROM Product p " +
            "WHERE (:TypeID IS NULL OR p.TypeID = :TypeID) " +
            "AND (:Color IS NULL OR p.Color = :Color) " +
            "AND (:Size IS NULL OR p.Size = :Size) " +
            "AND (:minPrice IS NULL OR p.Originalprice >= :minPrice) " +
            "AND (:maxPrice IS NULL OR p.Originalprice <= :maxPrice) " +
            "AND (:StyleID IS NULL OR p.StyleID = :StyleID)")
    Page<Product> findFilteredProducts(Integer TypeID,
                                       String Color,
                                       String Size,
                                       BigDecimal minPrice,
                                       BigDecimal maxPrice,
                                       Integer StyleID,
                                       org.springframework.data.domain.Pageable pageable);

}
