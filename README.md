# Alumind Feedback Analysis Project

Este projeto faz parte de um desafio técnico para o processo seletivo da Alura. Ele consiste em uma aplicação backend que analisa e classifica feedbacks dos usuários do aplicativo Alumind, identificando o sentimento do feedback utilizando LLM.

## Tecnologias Utilizadas
- **Java** 23
- **Spring Boot**
- **Spring Data JPA**
- **SQL** (compatível com MySQL e PostgreSQL)
- **LLM** para análise de feedbacks
- **Git & Github**

## Requisitos Atendidos
### 1. Classificação de Feedbacks
O sistema possui um endpoint `/api/feedback/feedbacks` que recebe feedbacks em texto e classifica o sentimento (POSITIVO, NEGATIVO ou INCONCLUSIVO), além de identificar novas funcionalidades sugeridas.

#### Exemplo de Requisição
```json
POST /api/feedback/feedbacks
Content-Type: application/json

{
    "feedback": "Adoro o Alumind! Ele me ajuda muito. Gostaria de editar meu perfil."
}
```

#### Exemplo de Resposta
```json
{
    "id": 1,
    "sentiment": "POSITIVO",
    "requested_features": [
        {
            "code": "EDITAR_PERFIL",
            "reason": "O usuário gostaria de editar o próprio perfil."
        }
    ]
}
```

### 2. Marcação de SPAM
A aplicação implementa um filtro de SPAM para identificar feedbacks que não estão relacionados ao aplicativo Alumind ou que possuem um conteúdo agressivo. A classificação de SPAM é realizada utilizando uma LLM (Large Language Model), que analisa o texto do feedback e decide se ele é relevante ou não.

Esse filtro de SPAM ajuda a evitar que feedbacks irrelevantes entrem no sistema, garantindo que apenas os feedbacks significativos e úteis sejam processados. Feedbacks marcados como SPAM são ignorados, evitando processamento desnecessário.


### 3. Sugestão de Funcionalidade Inovadora com LLM
Para potencializar a experiência do usuário e auxiliar o time de produto na análise de feedbacks, uma funcionalidade inovadora poderia ser implementada: o **Assistente de Engajamento para Feedbacks**. Esse assistente utiliza LLM para identificar temas recorrentes e medir o nível de engajamento e satisfação dos usuários.

#### Funcionalidades do Assistente de Engajamento

- **Identificar temas principais**: Agrupa feedbacks em tópicos como “perfil de usuário”, “acessibilidade”, “interatividade”, entre outros, facilitando a identificação de áreas específicas para melhorias.
  
- **Acompanhar tendências de satisfação**: O sistema gera insights sobre a evolução da satisfação dos usuários ao longo do tempo, baseada nos feedbacks mais recentes.
  
- **Gerar relatórios semanais ou mensais**: Produz resumos automáticos dos temas mais comentados e a frequência de feedbacks em cada categoria, proporcionando ao time de produtos uma visão clara das prioridades e preocupações dos usuários.



