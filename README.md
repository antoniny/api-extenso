Projeto criado para realização de um desafio corporativo. Criado um servidor HTTP que para cada requisição GET na api, será retornado um JSON cuja chave extenso será a versão por extenso do número inteiro enviado no path. Os números estão limitados no intervalo [-99999, 99999].

# Visão geral

O projeto é uma aplicação back-end com objetivo de demonstrar a construção de uma API utilizando os frameworks [Spring Boot](https://projects.spring.io/spring-boot), [Spring MVC](https://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html) e [Spring Data](http://projects.spring.io/spring-data) em conjunto.

## Tecnologias

- [Spring Boot](https://projects.spring.io/spring-boot) é uma ferramenta que simplifica a configuração e execução de aplicações Java stand-alone,  com conceitos de dependências “starters”, auto configuração e servlet container embutidos é proporcionado uma grande produtividade desde o start-up da aplicação até sua ida a produção.
 
- [Spring MVC](https://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html) é um framework já consolidado no mercado, que a partir da versão fornece mecanismos simplificados para a criação de APIs RESTful através de anotação, além disso, também possui recursos de serialização e deserialização de objetos de forma transparente 
 
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa) é um framework que abstrai o acesso ao modelo de dados, independente a tecnologia de base de dados.

- [H2 Database Engine](https://www.h2database.com/) é um banco de dados Open Source que funciona em memória com um console acessível pelo browser dentro do contexto da aplicação. 

 
# Setup da aplicação (local)

## Pré-requisito

Antes de rodar a aplicação é preciso garantir que as seguintes dependências estejam corretamente instaladas:
```
Java 8
Maven 3.1.0
```

## Instalação da aplicação 

Primeiramente, faça o clone do repositório:
```
https://github.com/antoniny/api-extenso.git
```
Acesse a pasta do projeto:
```
cd api-extenso
```
É preciso compilar o código e baixar as dependências do projeto:
```
mvn clean package
```
Finalizado esse passo, vamos iniciar a aplicação:
```
mvn spring-boot:run
```

A api já deverá estar disponível em http://localhost:3000/ \
Swagger: http://localhost:3000/swagger-ui.html \
Api:     http://localhost:3000/extenso/v1/ 


# Setup da aplicação com docker


## Executar servidor via docker - pull DockerHUB 

O comando abaixo deverá realizar o pull(download) da imagem do repositorio DockerHub e na sequência excutar a mesma localmente.

https://hub.docker.com/r/antoniny/api-extenso

Run:
```
docker run --name api-extenso -t -p 3000:3000 antoniny/api-extenso:latest

Nota: execute sem log no prompot de comando
docker run --name api-extenso -t -d -p 3000:3000 antoniny/api-extenso:latest
```
Stop:
```
docker stop api-extenso
```

Remove:
```
docker rm api-extenso
```


## Pré-requisito - Instalação Local

Antes de rodar a aplicação é preciso garantir que as seguintes dependências estejam corretamente instaladas:

```
Java 8
Docker 19.03.8 
Maven 3.1.0 
```

## Preparando ambiente

## Instalação da aplicação

Baixar as dependência e criar imagem da aplicação

Nota 1: Docker Cli deve estar ativo (Linux)
Nota 2: Ativar -> Docker Cli Win > Settings > General > Expose daemon on tcp://localhost:2375 without TLS 
Necessário para que o Maven consiga gerar a imagem no docker.
```
mvn clean package docker:build
```

Executar container da aplicação

```
docker run -it -p 3000:3030 antoniny/api-extenso:latest
```

A aplicação estará disponível em http://localhost:3000
```
Swagger: http://localhost:3000/swagger-ui.html
Api:     http://localhost:3000/extenso/v1/
```

# APIs

O projeto disponibiliza uma API que utiliza o padrão Rest de comunicação, produzindo arquivo no formato JSON.

Segue abaixo a API disponível no projeto:

#### Extenso

 - /extenso/v1/{number} (GET)
    - Espera atributo numérico no path da url para ser critério de busca e retorna no body do response a representação numérica. [-99999/99999]
    
    exemplo:
    ```
    λ curl http://localhost:3000/extenso/v1/1345
    {
      "extenso": "um mil trezentos e quarenta e cinco"
    }
    ```
    ```
       http://localhost:3000/extenso/v1/-34212
       {
         "extenso": "menos trinta mil duzentos e doze"
       }
     ```
   
   