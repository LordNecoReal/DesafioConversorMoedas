🚀 Conversor de Moedas - Challenge ONE - Java
Sobre o Projeto:

Este projeto é um conversor de moedas interativo desenvolvido em Java como parte do desafio do programa ONE, uma parceria entre a Alura e a Oracle. O objetivo principal foi criar uma aplicação que, a partir de uma API externa, fosse capaz de converter valores entre diferentes moedas em tempo real.

A aplicação foi construída com foco em:

Requisições HTTP 🌐: Utilização do java.net.http.HttpClient para se comunicar com uma API externa.

Manipulação de JSON 📦: Uso da biblioteca Gson para transformar dados JSON em objetos Java.

Interação com o Usuário 💻: Criação de uma interface de console amigável e intuitiva, com um menu de opções.

Código Modular 🧩: Divisão da lógica em classes e métodos específicos para maior organização e legibilidade.

Funcionalidades:

O programa oferece um menu no console com as seguintes opções de conversão:

USD -> Outras Moedas ➡️: Converte Dólar Americano para Peso Argentino (ARS), Boliviano da Bolivia (BOB), Real Brasileiro (BRL), Peso Chileno (CLP), Peso Colombiano (COP), Rúpia Indiana (INR) e Iene Japonês (JPY).

Outras Moedas -> BRL ➡️: Converte de qualquer outra moeda suportada para Real Brasileiro.

Tecnologias e Dependências
Linguagem: Java (JDK 24 ou superior)

Biblioteca: Gson (para processamento de JSON)

API: ExchangeRate-API (para taxas de câmbio)

Intellij

pom.xml

Para usar a biblioteca Gson, a seguinte dependência deve ser adicionada ao seu arquivo pom.xml:

<dependencies>
    <dependency>
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
        <version>2.10.1</version>
    </dependency>
</dependencies>

Como Executar o Projeto
Obtenha sua chave da API 🔑: Visite o site da ExchangeRate-API e registre-se para obter uma chave de API gratuita.

Configure o projeto ⚙️: Certifique-se de que a dependência do Gson está configurada no seu projeto.

Adicione a chave ✍️: Abra o arquivo ApiCambio.java e substitua a chave de API na variável exchangeApiKey pela sua chave real.

Execute ▶️: Rode a classe Main.java a partir da sua IDE. O menu interativo será exibido no console para que você possa iniciar as conversões.

Estrutura do Código
Main.java: O ponto de entrada do programa. Gerencia o menu, a interação com o usuário e a chamada para as funções de conversão.

ApiCambio.java: Contém a lógica para fazer a requisição à API e processar a resposta.

TaxaCambio.java: Uma classe modelo que representa os dados JSON retornados pela API, facilitando o acesso às taxas de câmbio.

Autor
[Lord Neco] 👤
