package com.commerce.e_commerce.repository;
    import model.Pedido;
    import org.springframework.data.jpa.repository.JpaRepository;

    public interface PedidoRepository extends
            JpaRepository<Pedido, Long> {
    }