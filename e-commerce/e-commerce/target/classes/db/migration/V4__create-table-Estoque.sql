CREATE TABLE Estoque (
    idEstoque INT AUTO_INCREMENT PRIMARY KEY,
    idProduto INT NOT NULL,
    quantidade INT NOT NULL,
    FOREIGN KEY (idProduto) REFERENCES Produto(idProduto)
);
