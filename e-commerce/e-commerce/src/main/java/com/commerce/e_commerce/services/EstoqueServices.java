package com.commerce.e_commerce.services;

import model.Estoque;
import model.Produto;
import com.commerce.e_commerce.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EstoqueServices {

    @Autowired
    private EstoqueRepository estoqueRepository;

    public List<Estoque> listarTodos() {
        return estoqueRepository.findAll();
    }

    public Estoque buscarPorId(Integer id) {
        return estoqueRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Estoque não encontrado com ID: " + id));
    }

    public Estoque salvar(Estoque estoque) {
        // Validações adicionais podem ser feitas aqui
        return estoqueRepository.save(estoque);
    }

    public Estoque atualizar(Integer id, Estoque estoqueAtualizado) {
        Estoque estoqueExistente = buscarPorId(id);

        // Atualizando os campos necessários
        estoqueExistente.setProduto(estoqueAtualizado.getProduto()); // Produto é uma relação @OneToOne
        estoqueExistente.setQuantidade(estoqueAtualizado.getQuantidade());

        return estoqueRepository.save(estoqueExistente);
    }

    public void deletar(Integer id) {
        Estoque estoque = buscarPorId(id);
        estoqueRepository.delete(estoque);
    }
}