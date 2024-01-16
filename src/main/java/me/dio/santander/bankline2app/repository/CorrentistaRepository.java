package me.dio.santander.bankline2app.repository;

import me.dio.santander.bankline2app.model.Correntista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorrentistaRepository extends JpaRepository<Correntista, Integer> {
}
