package me.dio.santander.bankline2api.service;

import me.dio.santander.bankline2api.dto.NovaMovimentacao;
import me.dio.santander.bankline2api.model.Correntista;
import me.dio.santander.bankline2api.model.Movimentacao;
import me.dio.santander.bankline2api.model.MovimentacaoTipo;
import me.dio.santander.bankline2api.repository.CorrentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MovimentacaoService {
    @Autowired
    private MovimentacaoService repository;
    @Autowired
    private CorrentistaRepository correntistaRepository;

    public void save(NovaMovimentacao novaMovimentacao){
        Movimentacao movimentacao = new Movimentacao();

        // Double valor = novaMovimentacao.getTipo()===MovimentacaoTipo.RECEITA ? novaMovimentacao

        Double valor = novaMovimentacao.getValor();
        if(novaMovimentacao.getTipo() == MovimentacaoTipo.DESPESA)
            valor = valor * -1;

        movimentacao.setDataHora(LocalDateTime.now());
        movimentacao.setDescricao(novaMovimentacao.getDescricao());
        movimentacao.setIdConta(novaMovimentacao.getIdConta());
        movimentacao.setTipo(novaMovimentacao.getTipo());
        movimentacao.setValor(valor);

        Correntista correntista = correntistaRepository.findById(novaMovimentacao.getIdConta()).orElse(null);
        if(correntista != null) {
            correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
            correntistaRepository.save(correntista);
        }

        repository.save(novaMovimentacao);
    }
}
