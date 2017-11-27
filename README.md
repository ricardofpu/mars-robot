[![Code Coverage](https://img.shields.io/codecov/c/github/pvorb/property-providers/develop.svg)](https://codecov.io/gh/ricardofpu/mars-robot/property-providers?branch=master)

# Mars Robot

API que permite enviar comandos para saber a posição exata de um robô.

## O Problema ##
Um time de robôs devem ser colocados pela NASA para explorar um terreno em Marte.
Esse terreno, que é retangular, precisa ser navegado pelos robôs de tal forma que suas câmeras acopladas possam obter uma visão completa da região, enviando essas imagens novamente para a Terra.

A posição de cada robô é representada pela combinação de coordenadas cartesianas (x, y) e por uma letra, que pode representar uma das quatro orientações: NORTH, SOUTH, EAST e WEST. Para simplificar a navegação, a região “marciana” a ser explorada foi subdividia em sub-regiões retangulares.
Uma posição válida de um robô, seria (0, 0, N), que significa que o robô está posicionado no canto esquerdo inferior do terreno, voltado para o Norte.
Para controlar cada robô, a NASA envia uma string simples, que pode conter as letras ‘L’, ‘R’ e ‘M’. As letras ‘L’ e ‘R’ fazem o robô rotacionar em seu próprio eixo 90 graus para esquerda ou para direita, respectivamente, sem se mover da sua posição atual. A letra ‘M’ faz o robô deslocar-se uma posição para frente.
Assuma que um robô se movimenta para o NORTE em relação ao eixo y. Ou seja, um passo para o NORTE da posição (x,y), é a posição (x, y+1)
Exemplo: Se o robô está na posição (0,0,N), o comando "MML" fará ele chegar na posição (0,2,W)

## Tecnologias utilizadas ##

- Java
- Maven
- Spring Boot
- JUnit Tests

## Instalações ##
O projeto possui as seguintes dependências:

* [Java Development Kit](http://www.oracle.com/technetwork/java/javase/downloads/index.html) (versão 8)
* [Maven](https://maven.apache.org/) (versão 3.5 ou maior)

## Configuração do ambiente ##

Após a instalação das dependências, inicie baixando o projeto executando o seguinte comando:

```
git clone https://github.com/ricardofpu/mars-robot.git

```
## Execução ##

Build no projeto com maven. Executar comando na raiz do projeto:

```
mvn clean install
```

## Iniciando a aplicação ##

Acesse o diretório `` mars-robot/mars-robot-web/`` do projeto e execute o seguinte comando para iniciar a aplicação:

```
mvn spring-boot:run
```
Este comando irá realizar o build da aplicação e iniciar o servidor Tomcat. A aplicação ficará disponível na seguinte URL:
```
http://localhost:8080/
```
Outra opção para iniciar a aplicação e executar o seguinte comando dentro do diretório do projeto `` /mars-robot/mars-robot-web/target ``:
```
java -jar mars-robot-web.jar
```
## Utilização do Serviço REST ##

Dentro do diretório `` mars-robot/docs/postman``, estão a collection e environment para testes da API.

## Documentação das API's

Após o build do projeto, é possível acessar a documentação das API's do projeto dentro do diretório `` mars-robot/mars-robot-web/target/generated-docs/mars-robot-manual.html `` e abrir pelo navegador de internet.

