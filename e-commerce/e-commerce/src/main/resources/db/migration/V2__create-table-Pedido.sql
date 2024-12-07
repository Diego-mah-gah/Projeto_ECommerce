CREATE TABLE Pedido (
    idPedido INT AUTO_INCREMENT PRIMARY KEY,
    idCliente INT NOT NULL,
    dataPedido DATE NOT NULL,
    total DOUBLE NOT NULL,
    FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente)
);