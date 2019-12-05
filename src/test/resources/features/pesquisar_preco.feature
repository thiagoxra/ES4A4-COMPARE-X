Feature: Pesquisar os preços de um produto
  "Eu, como usuário não cadastrado necessariamente,
  Devo conseguir digitar o nome do produto de interesse
  De forma que eu tenha acesso aos resultados da minha busca"

  Scenario: Devo ter uma página inicial com um local para pesquisa de um produto

    Given Estou na página inicial da minha aplicação
    When Eu digito dentro do campo "pesquisar" o texto "cano"
    And clico no botão "comparar"
    Then Devo ser redirecionado para a página "Resultado da Busca"