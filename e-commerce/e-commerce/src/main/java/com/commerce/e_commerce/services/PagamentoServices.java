package com.commerce.e_commerce.services;

import model.Pagamento;
import com.commerce.e_commerce.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoServices {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public List<Pagamento> listarTodos() {
        return pagamentoRepository.findAll();
    }

    public Pagamento buscarPorId(Integer id) {
        return pagamentoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pagamento não encontrado com ID: " + id));
    }

    public Pagamento salvar(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    public Pagamento atualizar(Integer id, Pagamento pagamentoAtualizado) {
        Pagamento pagamento = buscarPorId(id);
        pagamento.setId(pagamentoAtualizado.getId());
        pagamento.setPedido(pagamentoAtualizado.getPedido());
        pagamento.setQuantidadeParcelas(pagamentoAtualizado.getQuantidadeParcelas());
        pagamento.setQuantidadeParcelas(pagamentoAtualizado.getQuantidadeParcelas());
        pagamento.setValorTotal(pagamentoAtualizado.getValorTotal());
        return pagamentoRepository.save(pagamento);
    }

    public void deletar(Integer id) {
        Pagamento pagamento = buscarPorId(id);
        pagamentoRepository.delete(pagamento);
    }
}