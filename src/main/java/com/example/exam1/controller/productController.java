package com.example.exam1.controller;

import com.example.exam1.model.Products;
import com.example.exam1.service.ICategoryService;
import com.example.exam1.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class productController {
    @Autowired
    public ICategoryService categoryService;
    @Autowired
    public IProductService productService;

    @GetMapping
    public ResponseEntity findAll(){
        List<Products> list = productService.findAll();
        return  new ResponseEntity(list, HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity save(@RequestBody Products products){
        productService.save(products);
        return new ResponseEntity("Ok", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id){
        productService.delete(id);
        return new ResponseEntity("OK",HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity edit(@PathVariable int id, @RequestBody Products products){
        products.setId(id);
        productService.save(products);
        return new ResponseEntity("OK", HttpStatus.OK);
    }

    @GetMapping("/findByPrice/{firstPrice}/{secondPrice}")
    public ResponseEntity findByPrice (@PathVariable double firstPrice, @PathVariable double secondPrice) {
        return new ResponseEntity(productService.findByPrice(firstPrice,secondPrice), HttpStatus.OK);
    }

    @GetMapping("/findTop")
    public ResponseEntity findTop () {
        return new ResponseEntity(productService.findTop(), HttpStatus.OK);
    }
    @GetMapping("/sort")
    public ResponseEntity sort () {
        return new ResponseEntity(productService.sort(), HttpStatus.OK);
    }

    @GetMapping("/findByCategory/{id}")
    public ResponseEntity findByCategory (@PathVariable int id) {
        return new ResponseEntity(productService.findByCategory(id), HttpStatus.OK);
    }

}
