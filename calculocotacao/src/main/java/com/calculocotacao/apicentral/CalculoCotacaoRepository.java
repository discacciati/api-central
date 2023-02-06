package com.calculocotacao.apicentral;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculoCotacaoRepository extends JpaRepository<CalculoCotacao, String> {
}
