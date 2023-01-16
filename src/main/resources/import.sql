INSERT INTO address(id, cep, logradouro, number, bairro, localidade, uf) VALUES (1, 54800000, 'Rua Azuza', 66, 'centro', 'Moreno', 'PE')
INSERT INTO address(id, cep, logradouro, number, bairro, localidade, uf) VALUES (2, 55310290, 'Rua Pele', 100, 'centro', 'Moreno', 'PE')

INSERT INTO user(address_id, name, last_name, birthday) VALUES (1, 'Felipe', 'Chagas', '1985-01-16')
INSERT INTO user(address_id, name, last_name, birthday) VALUES (2, 'Luiz', 'Chagas', '1985-01-16')