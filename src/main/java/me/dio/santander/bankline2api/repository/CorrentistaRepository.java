package me.dio.santander.bankline2api.repository;

import me.dio.santander.bankline2api.model.Correntista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorrentistaRepository extends JpaRepository<Correntista, Integer> {
}
