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

## Como Executar o Projeto

### 1. Instalação do Ollama
Primeiramente, será necessário instalar o **Ollama**, uma ferramenta de código aberto que permite executar e gerenciar modelos de linguagem grande (LLMs) diretamente na sua máquina local.
1. Acesse o site [Ollama](https://ollama.com/) e faça o download do instalador apropriado para seu sistema operacional.
2. Após a instalação, abra o Prompt de Comando e execute o seguinte comando para baixar o modelo LLM necessário:
   ```bash
   ollama pull phi3
   ```

### 2. Instalação do Java 23
Caso ainda não tenha o Java 23 instalado:
1. Acesse o site oficial do [Oracle Java](https://www.oracle.com/java/technologies/downloads/).
2. Faça o download do Java 23. É necessário ter uma conta Oracle; caso não tenha, crie uma para prosseguir com o download.
3. Siga as instruções de instalação fornecidas.

### 3. Configuração e Execução do Projeto
1. Clone este repositório para o diretório de sua preferência:
   ```bash
   git clone https://github.com/seu_usuario/alumind-feedback-analysis.git
   ```
2. Abra o projeto em uma IDE Java de sua escolha.
3. No projeto, localize o arquivo `AluMindFeedbackSProjectLlmApplication.java` e execute-o para iniciar o servidor.

### 4. Acessando a Interface Swagger
1. Abra seu navegador e acesse a interface do Swagger para visualizar e interagir com os endpoints da aplicação:
   ```
   http://localhost:8080/swagger-ui/index.html#/
   ```
2. Na aba `feedback-controller`, expanda a rota `POST /api/feedback/feedbacks`.
3. Insira o texto do feedback no campo de entrada e clique no botão "Execute" para enviar a requisição e receber a análise do feedback.



