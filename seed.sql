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

INSERT INTO aluno_disciplina (aluno_id, curso_id, disciplina_id, provas, trabalhos, recuperacao)
VALUES
    (1,1,1,60,30, null),
    (1,1,2,55,25, null),
    (1,1,3,70,20, null),
    (1,4,10,45,10, 100),
    (1,4,11,55,25, null),
    (1,4,12,70,20, null),
    (2,3,7,40, 10, 80),
    (2,3,8,54,15, 75),
    (2,3,9,70,20, null),
    (3,3,7,30,20, 90),
    (3,3,8,70,30, null),
    (3,3,9,70,10, null);