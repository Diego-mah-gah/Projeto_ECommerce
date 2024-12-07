CREATE TABLE Pagamento (
    idPagamento INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    idPedido INT NOT NULL,
    valorTotal FLOAT NOT NULL,
    quantidadeParcelas INT,
    FOREIGN KEY (idPedido) REFERENCES Pedido(idPedido)
);