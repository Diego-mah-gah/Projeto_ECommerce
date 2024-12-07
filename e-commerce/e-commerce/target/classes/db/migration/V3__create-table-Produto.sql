CREATE TABLE Produto (
    idProduto INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome VARCHAR(500) NOT NULL,
    descricao VARCHAR(500),
    categoria VARCHAR(200),
    preco FLOAT,
    quantidade INTEGER
);