package me.dio.santander.bankline2app.controller;

import me.dio.santander.bankline2app.dto.NovoCorrentista;
import me.dio.santander.bankline2app.model.Correntista;
import me.dio.santander.bankline2app.repository.CorrentistaRepository;
import me.dio.santander.bankline2app.service.CorrentistaService;
import org.antlr.v4.runtime.tree.pattern.ParseTreePattern;
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
