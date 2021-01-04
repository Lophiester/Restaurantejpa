package com.lophiester.Restaurante.repositories;

import com.lophiester.Restaurante.domain.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
}
