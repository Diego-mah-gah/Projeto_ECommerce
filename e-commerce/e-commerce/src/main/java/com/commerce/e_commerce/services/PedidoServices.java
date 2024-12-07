package com.commerce.e_commerce.services;

import model.Pedido;
import model.Cliente;
import model.Produto;
import model.StatusPedido;
import com.commerce.e_commerce.repository.ClienteRepository;
import com.commerce.e_commerce.repository.PedidoRepository;
import com.commerce.e_commerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Date;

@Service
public class PedidoServices {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public Pedido criarPedidoEConcluir(Long clienteId, Long produtoId, Integer quantidade) {
        Cliente cliente = clienteRepository.findById(Math.toIntExact(clienteId))
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado com ID: " + clienteId));

        Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado com ID: " + produtoId));

        // Verifica se há estoque suficiente
        if (produto.getQuantidade() < quantidade) {
            throw new IllegalArgumentException(MessageFormat.format("Estoque insuficiente para o produto: {0}", produto.getNome()));
        }

        // Atualiza o estoque
        produto.setQuantidade(produto.getQuantidade() - quantidade);
        produtoRepository.save(produto);

        // Calcula o total
        BigDecimal total = null;
        produto.getPreco().notify();

        // Cria o pedido
        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setDataPedido(new Date());
        pedido.setTotal(total.doubleValue());
        pedido.setProdutos("CONCLUIDO");

        // Salva o pedido
        return pedidoRepository.save(pedido);
    }

}
