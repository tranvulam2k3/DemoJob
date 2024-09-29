package com.website.demojob.repository;

import com.website.demojob.model.Cart;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartReponsitory extends CrudRepository<Cart, Integer> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Cart(IDProduct,Productname, Productimage, Specialprice, Color, Size, Quantity) " +
            "SELECT :idproduct ,p.Productname, p.Productimage, p.Specialprice, :color, :size, :quantity " +
            "FROM Product p WHERE p.IDProduct = :idproduct", nativeQuery = true)
    void addCartByIdproduct(int idproduct, String color, String size, int quantity);


    @Query("select c from Cart c")
    List<Cart> getAllProductByCart();

    @Query("select c from Cart c where c.IDProduct= :IDProduct and c.Color= :Color and c.Size = :Size")
    Cart checkProductByCart(int IDProduct, String Color, String Size);

    @Modifying
    @Transactional
    @Query("update Cart c set c.Quantity =:quantity where c.IDProduct = :IDProduct")
    void updateQuantilyByCart(int IDProduct, int quantity);

}
