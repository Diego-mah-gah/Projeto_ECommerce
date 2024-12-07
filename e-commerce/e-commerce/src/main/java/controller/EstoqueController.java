package controller;

import com.commerce.e_commerce.services.EstoqueServices;
import model.Estoque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueServices estoqueService;

    @GetMapping
    public ResponseEntity<List<Estoque>> listarTodos() {
        List<Estoque> estoques = estoqueService.listarTodos();
        return ResponseEntity.ok(estoques);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estoque> buscarPorId(@PathVariable Integer id) {
        Estoque estoque = estoqueService.buscarPorId(id);
        return ResponseEntity.ok(estoque);
    }

    @PostMapping
    public ResponseEntity<Estoque> criar(@RequestBody Estoque estoque) {
        Estoque novoEstoque = estoqueService.salvar(estoque);
        return ResponseEntity.ok(novoEstoque);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estoque> atualizar(@PathVariable Integer id, @RequestBody Estoque estoqueAtualizado) {
        Estoque estoque = estoqueService.atualizar(id, estoqueAtualizado);
        return ResponseEntity.ok(estoque);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        estoqueService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}