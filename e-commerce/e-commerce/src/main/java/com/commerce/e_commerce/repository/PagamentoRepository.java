package com.commerce.e_commerce.repository;
    import model.Pagamento;
    import org.springframework.data.jpa.repository.JpaRepository;

    public interface PagamentoRepository extends
            JpaRepository<Pagamento, Integer> {
    }
