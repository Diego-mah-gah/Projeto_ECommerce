package controller;

import com.commerce.e_commerce.services.PagamentoServices;
import model.Pagamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagamento")
public class PagamentoController {

    @Autowired
    private PagamentoServices pagamentoService;

    @GetMapping
    public ResponseEntity<List<Pagamento>> listarTodos() {
        List<Pagamento> pagamentos = pagamentoService.listarTodos();
        return ResponseEntity.ok(pagamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pagamento> buscarPorId(@PathVariable Integer id) {
        Pagamento pagamento = pagamentoService.buscarPorId(id);
        return ResponseEntity.ok(pagamento);
    }

    @PostMapping
    public ResponseEntity<Pagamento> criar(@RequestBody Pagamento pagamento) {
        Pagamento novoPagamento = pagamentoService.salvar(pagamento);
        return ResponseEntity.ok(novoPagamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pagamento> atualizar(@PathVariable Integer id, @RequestBody Pagamento pagamentoAtualizado) {
        Pagamento pagamento = pagamentoService.atualizar(id, pagamentoAtualizado);
        return ResponseEntity.ok(pagamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        pagamentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}