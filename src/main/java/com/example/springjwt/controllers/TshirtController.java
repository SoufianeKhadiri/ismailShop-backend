package com.example.springjwt.controllers;

import com.example.springjwt.model.Tshirt;
import com.example.springjwt.services.TshirtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/rest/api/tshirts")
public class TshirtController {

    @Autowired
    private TshirtService tshirtService;


    @ResponseBody
    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<Tshirt> getAllProducts() {
        return tshirtService.getAllProducts();

    }

    @ResponseBody
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public Optional<Tshirt> getProductById(@PathVariable int id) {
        return tshirtService.getProductById(id);
    }

    @ResponseBody
    @RequestMapping(value = "",method = RequestMethod.POST)
    public ResponseEntity<Tshirt> createProduct(@RequestBody Tshirt tshirt) {
        Tshirt createdTshirt = tshirtService.createProduct(tshirt);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTshirt);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable int id) {
        tshirtService.deleteProduct(id);
    }


}
