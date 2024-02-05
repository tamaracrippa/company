CREATE TABLE Funcionarios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255),
    data_nascimento DATE,
    salario DECIMAL(10, 2),
    funcao VARCHAR(255)
);

INSERT INTO Funcionarios (nome, data_nascimento, salario, funcao) VALUES
('Maria', '2000-10-18', 2009.44, 'Operador'),
('João', '1990-05-12', 2284.38, 'Operador'),
('Caio', '1961-05-02', 9836.14, 'Coordenador'),
('Miguel', '1988-10-14', 19119.88, 'Diretor'),
('Alice', '1995-01-05', 2234.68, 'Recepcionista'),
('Heitor', '1999-11-19', 1582.72, 'Operador'),
('Arthur', '1993-11-19', 4071.84, 'Contador'),
('Laura', '1994-07-08', 3017.45, 'Gerente'),
('Heloísa', '2003-05-24', 1606.85, 'Eletricista'),
('Helena', '1996-09-02', 2799.93, 'Gerente');
