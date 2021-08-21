package br.com.santander.gerenciadoremprestimo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.santander.gerenciadoremprestimo.model.Parcela;

@Repository
public interface ParcelaRepository extends JpaRepository<Parcela, Integer> {

}
