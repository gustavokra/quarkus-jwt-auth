# quarkus-jwt-auth
Projeto possui um serviço de cadastro de produto e um serviço para geração do token jwt.
Para subir o projeto, rode ```./start.sh ``` para gerar suas chaves publicas e privadas por meio do openss e subir o container docker dos dois serviços.
A aplicação possui swagger, então para ver a documentação, após subir o projeto, basta acessar http://localhost:8081/q/swagger-ui/, e gerar o token em http://localhost:8082/jwt.
