package controller;

import model.Pedido;
import com.commerce.e_commerce.services.PedidoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoServices pedidoService;

    @PostMapping("/comprar")
    public ResponseEntity<Pedido> criarPedido(
            @RequestParam Long clienteId,
            @RequestParam Long produtoId,
            @RequestParam Integer quantidade) {
        Pedido pedido = pedidoService.criarPedidoEConcluir(clienteId, produtoId, quantidade);
        return ResponseEntity.ok(pedido);
    }
}