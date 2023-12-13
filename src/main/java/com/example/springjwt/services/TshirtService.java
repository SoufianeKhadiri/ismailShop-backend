package com.example.springjwt.services;

import com.example.springjwt.model.Tshirt;
import com.example.springjwt.repositories.TshirtRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TshirtService {


    private final TshirtRepository tshirtRepository;

    public TshirtService(TshirtRepository tshirtRepository) {
        this.tshirtRepository = tshirtRepository;
    }


    public List<Tshirt> getAllProducts() {
        return tshirtRepository.findAll();
    }


    public Optional<Tshirt> getProductById(int id) {
        return tshirtRepository.findById(id);
    }


    public Tshirt createProduct(Tshirt tshirt) {
        return tshirtRepository.save(tshirt);
    }


    public Tshirt updateProduct(int id, Tshirt tshirt) {
        deleteProduct(id);
        return createProduct(tshirt);
    }


    public void deleteProduct(int id) {
        tshirtRepository.deleteById(id);
    }

}
