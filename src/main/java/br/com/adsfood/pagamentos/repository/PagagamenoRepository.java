package br.com.adsfood.pagamentos.repository;

import br.com.adsfood.pagamentos.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagagamenoRepository extends JpaRepository<Pagamento, Long> {

}
