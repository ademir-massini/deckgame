DeckGame API

A DeckGame API é uma aplicação Java/Spring Boot que utiliza a API Deck of Cards para distribuir cartas para os jogadores, calcular suas pontuações e determinar o(s) vencedor(es). Suporta empates e retorna todos os jogadores, suas mãos e o(s) campeão(ões).

* Funcionalidades

Criar um baralho embaralhado via DeckOfCardsAPI
Distribuir cartas para N jogadores
Calcular a soma das cartas conforme regras internas

Retornar:
Todos os jogadores com suas pontuações e cartas
O vencedor ou lista de vencedores em caso de empate


* Arquitetura da Aplicação
    Principais componentes:
        GameService: lógica principal do jogo
        DeckOfCardsApiClient: comunicação com API externa
        PlayRequest: request contendo players e cardsPerPlayer
        PlayResult: resposta com jogadores e vencedores
        CardUtils: conversão valor → inteiro
        A aplicação segue o padrão REST e expõe o endpoint:
        POST /api/play


* Como executar o projeto localmente
    1. Requisitos
        Java 8+
        Maven 3.8+
        Docker (opcional para containerizar)

    2. Clonar o repositório
        git clone https://gitlab.com/ademirmassini/deckgame.git
        cd deckgame-api

    3. Build
        mvn clean install

    4. Executar
        mvn spring-boot:run

    A API ficará acessível em:
        http://localhost:8080

* Como subir a aplicação com Docker
    1. Gerar o build
        mvn clean package

    2. Criar a imagem Docker
        docker build -t deckgame-api .

    3. Executar o container
        docker run -p 8080:8080 deckgame-api

* Exemplo de Request
    POST /api/play
        Content-Type: application/json
        {
          "players": 5,
          "cardsPerPlayer": 5
        }

* Exemplo de Response (com vencedor único)
    {
      "players": [
         { "name": "Player 1", "sum": 25, "cards": ["7","5","3","4","6"] },
         { "name": "Player 2", "sum": 30, "cards": ["10","6","5","4","5"] },
         { "name": "Player 3", "sum": 37, "cards": ["10","8","4","9","6"] },
         { "name": "Player 4", "sum": 22, "cards": ["6","5","4","3","4"] },
         { "name": "Player 5", "sum": 28, "cards": ["8","7","6","3","4"] }
      ],
      "winners": [
            {
                "name": "Player 3",
                "sum": 37,
                "cards": ["10","8","4","9","6"]
            }
      ]
    }

* Empate – Exemplo de Response
    {
      "players": [
         { "name": "Player 1", "sum": 35, "cards": ["10","9","8","4","4"] },
         { "name": "Player 2", "sum": 35, "cards": ["K","8","7","5","5"] }
      ],
      "winners": [
            { "name": "Player 1", "sum": 35, "cards": ["10","9","8","4","4"] },
            { "name": "Player 2", "sum": 35, "cards": ["K","8","7","5","5"] }
      ]
    }

* Como funciona o DeckOfCardsApiClient
    Criar baralho embaralhado
    GET https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1
    Comprar cartas
    GET https://deckofcardsapi.com/api/deck/{deck_id}/draw/?count=X

    A API retorna um array com objetos contendo:

    {
      "value": "10",
      "suit": "HEARTS",
      "code": "0H"
    }

* Licença
    Projeto livre para estudos.

* Contato
    Criado por Ademir.