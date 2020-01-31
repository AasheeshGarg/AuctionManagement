package com.example.AuctionManagementSystem.service;


import com.example.AuctionManagementSystem.model.Product;
import com.example.AuctionManagementSystem.model.User;
import com.example.AuctionManagementSystem.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @InjectMocks
    ProductService service;

    @Mock
    ProductRepository productRepository;

    @Mock
    UserService userService;

    @Test
    public void testAddProductSuccess() {

        User user = new User("ashish", "ashish");
        user.setUserId(1l);
        when(userService.getUserById(anyLong())).thenReturn(user);

        Product product = new Product(1, "name", "desc", user);
         service.addProduct(product);

        verify(userService, times(1)).getUserById(anyLong());
        verify(productRepository, times(1)).save(any(Product.class));
    }

    @Test
    public void testAddProductFailure() {

        User user = new User("ashish", "ashish");
        user.setUserId(1l);
        Product product = new Product(1, "name", "desc", user);
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        user.setProducts(productList);
        when(userService.getUserById(anyLong())).thenReturn(user);

        try {
            service.addProduct(product);
        }catch(IllegalArgumentException e){
            Assert.assertEquals(e.getMessage(), "Product already present.");
        }

        verify(userService, times(1)).getUserById(anyLong());
        verify(productRepository, times(0)).save(any(Product.class));
    }

    @Test
    public void testAddProductFailureWithInvalidProduct() {


        Product product = new Product();

        try {
            service.addProduct(product);
        }catch(IllegalArgumentException e){
            Assert.assertEquals(e.getMessage(), "Invalid product name.");
        }

        verify(userService, times(0)).getUser(anyString());
        verify(productRepository, times(0)).save(any(Product.class));
    }

    @Test
    public void testGetProductByUserId() {

        User user = new User("ashish", "ashish");
        user.setUserId(1l);
        Product product = new Product(1, "name", "desc", user);
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        user.setProducts(productList);
        when(userService.getUserById(anyLong())).thenReturn(user);

        List<Product> result = service.getProductsByUserId("1");

        Assert.assertNotNull(result);
        Assert.assertEquals(1,result.size());
    }

    @Test
    public void testGetProductById() {
        User user = new User("ashish", "ashish");
        user.setUserId(1l);
        Product product = new Product(1, "name", "desc", user);
        Optional<Product> optionalProduct = Optional.of(product);
        when(productRepository.findById(anyLong())).thenReturn(optionalProduct);

        Product result = service.getProductById(1l);

        Assert.assertNotNull(result);
    }
}
