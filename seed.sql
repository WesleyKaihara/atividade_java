INSERT INTO curso (nome,duracao)
    VALUES
        ('TADS', 5),
        ('Agronomia', 10),
        ('Arquitetura', 10),
        ('Administração', 8);


INSERT INTO aluno (nome, email)
VALUES
    ('João Pedro', 'joao@gmail.com'),
    ('Pedro Vitor', 'pedro@gmail.com'),
    ('Ana Luiza', 'ana@gmail.com');


INSERT INTO aluno_curso (aluno_id, curso_id)
    VALUES (1,1), (2,3),(1,4),(3,3);


INSERT INTO disciplina (curso_id, nome)
VALUES
    (1, 'Algoritmos'),(1,'Backend'), (1,'Anáálise de Dados'),
    (2,'Fisiologia Geral'), (2, 'Fundamentos de Cálculo Aplicado'), (2, 'Vinocultura, Suinocultura e Avicultura'),
    (3,'Desenho Artístico'),(3, 'Sistemas Estruturais'), (3,'Urbanismo'),
    (4, 'Estatística e Probabilidade'), (4, 'Sistemas de Controles Internos'),(4, 'Administração Estratégica');


INSERT INTO disciplina_avaliacao (disciplina_id,valor, nome)
    VALUES
        (1, 70, 'Prova Final'),
        (2, 70, 'Prova Final'),
        (3, 70, 'Prova Final'),
        (4, 70, 'Prova Final'),
        (5, 70, 'Prova Final'),
        (6, 70, 'Prova Final'),
        (7, 70, 'Prova Final'),
        (8, 70, 'Prova Final'),
        (9, 70, 'Prova Final'),
        (10, 70, 'Prova Final'),
        (11, 70, 'Prova Final'),
        (12, 70, 'Prova Final'),
        (1,30, 'Trabalho'),
        (2,30, 'Trabalho'),
        (3,30, 'Trabalho'),
        (4,30, 'Trabalho'),
        (5,30, 'Trabalho'),
        (6,30, 'Trabalho'),
        (7,30, 'Trabalho'),
        (8,30, 'Trabalho'),
        (9,30, 'Trabalho'),
        (10,30, 'Trabalho'),
        (11,30, 'Trabalho'),
        (12,30, 'Trabalho'),
        (1,100, 'Recuperação'),
        (2,100, 'Recuperação'),
        (3,100, 'Recuperação'),
        (4,100, 'Recuperação'),
        (5,100, 'Recuperação'),
        (6,100, 'Recuperação'),
        (7,100, 'Recuperação'),
        (8,100, 'Recuperação'),
        (9,100, 'Recuperação'),
        (10,100, 'Recuperação'),
        (11,100, 'Recuperação'),
        (12,100, 'Recuperação');

INSERT INTO aluno_disciplina_avaliacao (aluno_id, disciplina_avaliacao_id, nota)
VALUES
    -- Notas Aluno 01
    -- Notas Algoritmos
    (1,1,25),
    (1,3,65),
    (1,25,null),
    -- Notas Backend
    (1,2,10),
    (1,14,70),
    (1,26,null),
    -- Notas Análise de Dados
    (1,3,20),
    (1,15,60),
    (1,27, null),
    -- Notas Estatística e Probabilidade
    (1,10, 15),
    (1,22, 50),
    (1,34, 85),
    -- Notas Sistemas de Controles Internos
    (1,11, 15),
    (1,23, 54),
    (1,35, 100),
    -- Notas Administração Estratégica
    (1,12,20),
    (1,24, 65),
    (1,36, null),
    -- Notas Aluno 02
    -- Notas Desenho Artístico
    (2,7, 5),
    (2,19, 50),
    (2,31, 78),
    -- Notas Sistemas Estruturais
    (2,8, 0),
    (2,20, 65),
    (2,32, 80),
    -- Notas Urbanismo
    (2,9, 30),
    (2,21, 70),
    (2,33, null),
    -- Notas Aluno 03
    -- Notas Desenho Artístico
    (3,7, 27),
    (3,19, 65),
    (3,31, null),
    -- Notas Sistemas Estruturais
    (3,8, 15),
    (3,20, 55),
    (3,32, null),
    -- Notas Urbanismo
    (3,9, 20),
    (3,21, 65),
    (3,33, null);
