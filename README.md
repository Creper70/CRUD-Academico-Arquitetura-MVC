# Sistema de Gerenciamento Academico em Java

Este projeto consiste em um sistema de informação para gerenciamento acadêmico, desenvolvido como atividade avaliativa para a disciplina de Programação Orientada a Objetos. O foco principal da aplicação é aplicar os conceitos de orientação a objetos na prática, garantindo um código limpo, estruturado e de fácil manutenção.

## Arquitetura do Projeto

A base do sistema foi desenhada utilizando a separação de responsabilidades (conceitos de MVC e padrão DAO). A estrutura do código isola as regras de negócio e o modelo de domínio (classes `Aluno` e `Disciplina`) das regras de persistência de dados e da interface gráfica com o usuário.

## Funcionalidades Principais

O sistema realiza o controle completo de duas entidades principais através de operações CRUD (Create, Read, Update, Delete):

* **Gestão de Alunos:** Cadastro de matrícula, nome completo e curso.
* **Gestão de Disciplinas:** Cadastro de código, nome da matéria e carga horária (com validação para aceitar apenas valores inteiros).
* **Módulo de Relatórios:** Geração de consultas filtrando os alunos matriculados por curso específico.

## Diferenciais Técnicos

* **Persistência de Dados (I/O):** Em vez de depender de um banco de dados externo, o sistema simula a persistência salvando e recuperando os registros localmente em arquivos de texto (`.txt`). Isso demonstra o domínio sobre fluxos de entrada e saída (Input/Output) e a sincronização de dados em memória (ArrayList) com o armazenamento físico.
* **Controle de Estado na Interface:** A interface desenvolvida em Java Swing possui validações robustas com blocos `try-catch` e controle de estado dos botões e campos de texto. Os campos são habilitados e desabilitados dinamicamente para prevenir edições acidentais por parte do usuário.

## Tecnologias Utilizadas

* **Linguagem:** Java
* **Interface Gráfica:** Java Swing
* **Armazenamento:** Manipulação de arquivos (.txt) para persistência de dados
* **Paradigma:** Programação Orientada a Objetos (POO)

## Equipe Desenvolvedora

Projeto desenvolvido por Caique Guimarães, Charles Henrique e Davi Manoel.
