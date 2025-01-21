CREATE TABLE pedido (
    id SERIAL PRIMARY KEY,
    usuario_id BIGINT NOT NULL,
    produto_id BIGINT NOT NULL,
    data_pedido TIMESTAMP NOT NULL,
    CONSTRAINT fk_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(id),
    CONSTRAINT fk_produto FOREIGN KEY (produto_id) REFERENCES produto(id)
);