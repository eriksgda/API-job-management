<h1>Gestão de Empregos para Gatos</h1>

> Status: status: finalizado ✔️

_Ler este documento em outros idiomas:_
[_English_](./translations/README-en.md)

## Sobre o projeto

A API foi projetada para gerenciar e registrar informações sobre ofertas de emprego para gatos, facilitando a organização e o acompanhamento de oportunidades de emprego felinas. O sistema permite a criação de usuários como Empresas, que podem postar e gerenciar ofertas de trabalho para seus funcionários felinos, e Candidatos, que podem navegar e se candidatar a vagas disponíveis. O projeto adota as melhores práticas para o desenvolvimento de APIs, garantindo uma estrutura clara e fácil de usar.

### Funcionalidades API

- Criação de Usuário e Autenticação: Permite que os usuários criem contas como Candidatos ou Empresas. Ambos os tipos de usuários são autenticados para garantir acesso seguro à plataforma, permitindo que os candidatos se candidatem a vagas e as empresas postem e gerenciem ofertas de trabalho.

- Criação de Ofertas de Trabalho (Empresas): As empresas podem criar e gerenciar ofertas de trabalho. Elas podem definir funções, responsabilidades, habilidades necessárias e outros detalhes relevantes sobre as oportunidades de trabalho.

- Candidatura a Vagas (Candidatos): Os candidatos podem navegar pelas ofertas de trabalho disponíveis, se candidatar a posições e acompanhar suas aplicações. Eles podem enviar currículos, cartas de apresentação e quaisquer outros documentos exigidos pelas empresas. Além disso, os candidatos podem buscar vagas utilizando um filtro simples baseado em palavras-chave para encontrar posições que correspondam aos seus interesses.

- Persistência de Dados (PostgreSQL): Utiliza um banco de dados relacional (PostgreSQL) para armazenar de forma persistente as informações dos usuários, ofertas de trabalho e dados de candidatura, garantindo integridade dos dados e consultas eficientes.

- Testes Unitários: A API inclui testes unitários abrangentes para garantir a funcionalidade e a confiabilidade de todos os endpoints, proporcionando confiança na estabilidade e desempenho do sistema.

## Tecnologias Utilizadas e Dependências

<table>
  <tr>
    <td>Java</td>
    <td>SpringBoot</td>
  </tr>
  <tr>
    <td>^22.0.1</td>
    <td>^3.3.1</td>
  </tr>
</table>

## Como Usar

- Clone este repositório para o seu ambiente local:

```bash
git clone https://github.com/eriksgda/job-management.git
```

- Execute o arquivo principal do programa:

```bash
mvn install
mvn spring-boot:run
```

## Licença

Esse projeto está sob a licença [MIT](./../LICENSE).
