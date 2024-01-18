package me.dio.santander.bankline2api.controller;

import me.dio.santander.bankline2api.dto.NovoCorrentista;
import me.dio.santander.bankline2api.model.Correntista;
import me.dio.santander.bankline2api.repository.CorrentistaRepository;
import me.dio.santander.bankline2api.service.CorrentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/correntistas")
public class CorrentistaController {
    @Autowired
    private CorrentistaRepository repository;

    @Autowired
    private CorrentistaService service;

    @GetMapping
    public List<Correntista> findAll() {
        return repository.findAll();
    }

    @PostMapping
    public void save(@RequestBody NovoCorrentista correntista){
        service.save(correntista);
    }
}
