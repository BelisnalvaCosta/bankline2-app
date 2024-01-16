package me.dio.santander.bankline2app.controller;

import me.dio.santander.bankline2app.dto.NovaMovimentacao;
import me.dio.santander.bankline2app.dto.NovoCorrentista;
import me.dio.santander.bankline2app.model.Correntista;
import me.dio.santander.bankline2app.model.Movimentacao;
import me.dio.santander.bankline2app.repository.CorrentistaRepository;
import me.dio.santander.bankline2app.repository.MovimentacaoRepository;
import me.dio.santander.bankline2app.service.CorrentistaService;
import me.dio.santander.bankline2app.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {
    @Autowired
    private MovimentacaoRepository repository;

    @Autowired
    private MovimentacaoService service;

    @GetMapping
    public List<Movimentacao> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{idConta}")
    public List<Movimentacao> findAll(@PathVariable("idConta") Integer idConta){
        return repository.findByIdConta(idConta);
    }

    @PostMapping
    public void save(@RequestBody NovaMovimentacao movimentacao){
        service.save(movimentacao);
    }
}