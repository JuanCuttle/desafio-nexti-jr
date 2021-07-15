## Developer JR

Parabéns, você passou para a segunda fase do processo seletivo da NEXTI para desenvolvedor JR (Java + Angular).

## Instruções

- Disponibilizar o repositório público no Github e documentar a execução no README. Enviar o link vagas@nexti.com

### Funcionalidades

- Desenvolver uma aplicação web responsável por gerenciar clientes, pedidos e produtos.

- *O investidor solicita um sistema onde possa cadastrar os seus clientes, produtos e pedidos para ter maior controle sobre os mesmos.* 

- *O analista de negócio reuniu mais informações e a seguinte demanda foi gerada para ser executada que está descrita logo abaixo.*

### Demanda

- **Eu como cliente quero cadastrar clientes e produtos e após isso criar pedidos para os clientes contendo todas as informações relevantes ao pedido**

- Cliente
	- Incluir, excluir, atualizar e listar.
- Produto
	- Incluir, excluir, atualizar e listar.
- Pedido
	- Incluir, excluir, atualizar e listar.
	- Vincular cliente a um pedido.
    - Remover cliente de um pedido.
    - Vincular produto(s) a um pedido.
    - Remover produto(s) de um pedido.
	
**CLIENTE** 

O cliente deve ter os seguintes atributos:
```
* ID
* NOME
* CPF
* DATA DE NASCIMENTO
```

**PRODUTO** 

O produto deve ter os seguintes atributos:
```
* ID
* NOME
* DESCRIÇÃO
* PREÇO
* QUANTIDADE
```

**PEDIDO** 

O pedido deve ter os seguintes atributos:
```
* ID
* CLIENTE
* TOTAL DA COMPRA
* DATA DA COMPRA
* PRODUTOS

```


### Desafio
- O desenvolvimento do backend deve ser feito em Java.
- Boa documentação de código e de serviços.
- Desenvolver os módulos de frontend e backend de forma separada.
- O desenvolvimento do frontend pode utilizar JavaScript e qualquer framework ou ferramenta que suportem ou utilizem estas tecnologias.
- Preferencialmente utilizar Spring Boot 1.4+ com toda sua stack para o desenvolvimento do backend.
- Preferencialmente utilizar AngujarJS para o desenvolvimento do frontend.(Diferencial ReactJS, Angular 2+)
- Preferencialmente utilizar Mysql o desenvolvimento do backend.(Aceitável PostgreSQL)
- Não é necessário submeter uma aplicação que cumpra cada um dos requisitos descritos, mas o que for submetido deve funcionar.
- Boas práticas de UX na solução.
- Testes do código.

### Avaliação
- Será visto no código desenvolvido: clean code; resultado funcional; entre outros fatores, e manutenção. 
- Documente todo o processo necessário para executarmos o seu projeto, para isso esperamos que utilize o README no git.
- Explique as decisões técnicas tomadas caso necessário, as escolhas por bibliotecas e ferramentas, o uso de patterns etc.


