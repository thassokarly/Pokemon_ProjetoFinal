API REST - Projeto Final Pokédex
API REST desenvolvida como projeto final, simulando uma Pokédex onde utilizadores (Professores e Treinadores) podem registar-se, autenticar-se e interagir com uma base de dados de Pokémons. Professores têm a capacidade de criar e deletar novos Pokémons.

🛠️ Tecnologias Utilizadas
Java 17+

Spring Boot 3

Spring Security & JWT: Para autenticação e autorização.

Spring Data JPA (Hibernate): Para persistência de dados.

PostgreSQL (Neon): Como banco de dados cloud relacional.

Maven: Para gestão de dependências e build do projeto.

Lombok: Para reduzir código boilerplate.

OpenCSV: Para carregar dados iniciais a partir de um ficheiro CSV.

Swagger/OpenAPI: Para documentação interativa da API.

📋 Pré-requisitos
Antes de começar, certifique-se de que tem o seguinte software instalado na sua máquina:

Java Development Kit (JDK) - Versão 17 ou superior

Apache Maven

Uma conta no Neon com um projeto de banco de dados criado.

Um cliente de API como Postman para testar os endpoints.

⚙️ Configuração do Ambiente
Siga estes quatro passos para preparar o seu ambiente local antes de executar a aplicação.

Passo 1: Clonar o Repositório
Abra o seu terminal, clone o projeto e navegue para a pasta criada:

Passo 2: Verificar a Dependência do Banco de Dados
Este projeto utiliza PostgreSQL. Certifique-se de que o seu ficheiro pom.xml contém a seguinte dependência para o driver do banco de dados:

<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>
</dependency>

Passo 3: Obter as Credenciais de Conexão do Neon
Aceda ao seu painel (dashboard) no Neon.

Selecione o seu projeto.

No painel principal, encontre a secção Connection Details.

Copie a string de conexão, que terá o formato: postgres://<user>:<password>@<host>/<dbname>.

Passo 4: Configurar as Variáveis de Ambiente no Projeto
Abra o ficheiro src/main/resources/application.properties e preencha as seguintes linhas com os dados que obteve do Neon no passo anterior:

# URL de conexão com o PostgreSQL do Neon
# Substitua <host>, <dbname>, <user> e <password> com os seus dados
spring.datasource.url=jdbc:postgresql://ep-twilight-recipe-aecl1rgf-pooler.c-2.us-east-2.aws.neon.tech/neondb?user=neondb_owner&password=npg_gtGj5xD9AsSE&sslmode=require&channelBinding=require
spring.datasource.username=<thasso>
spring.datasource.password=<password>

# Dialeto do Hibernate para PostgreSQL
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect

# Gestão automática do schema (cria/atualiza tabelas automaticamente)
spring.jpa.hibernate.ddl-auto=update

Atenção: O parâmetro ?sslmode=require no final da URL é obrigatório para se conectar ao Neon.

▶️ Como Executar o Projeto
Com o ambiente configurado, pode executar a aplicação de duas formas:

Via IDE (Recomendado)
Importe o projeto para a sua IDE IntelliJ IDEA

A IDE irá descarregar as dependências do Maven automaticamente.

Encontre a classe principal PokemonFinalProjectApplication.java e execute o método main().

Via Linha de Comando (Maven)
mvn spring-boot:run

A aplicação irá iniciar o servidor na porta 8080 e ligar-se ao seu banco de dados Neon na cloud.

🚀 Acessando a API
Documentação (Swagger)
Para uma visualização interativa de todos os endpoints, aceda à documentação do Swagger no seu navegador:
http://localhost:8080/swagger-ui.html

Testando com o Postman
Use a coleção do Postman para testar os endpoints.

<details>
<summary>Ou, clique para importar a coleção via JSON</summary>

{
	"info": {
		"_postman_id": "ecc28738-036b-4058-af47-ef47d048366b",
		"name": "Pokemon API Project",
		"schema": "[https://schema.getpostman.com/json/collection/v2.0.0/collection.json](https://schema.getpostman.com/json/collection/v2.0.0/collection.json)",
		"_exporter_id": "27253242"
	},
	"item": [
		{
			"name": "Autenticação",
			"item": [
				{
					"name": "Registar Professor",
					"request": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\n    \"nome\": \"Professor Carvalho\",\n    \"email\": \"carvalho@poke.gmail.br\",\n    \"senha\": \"password123\",\n    \"especialidade\": \"Pokémons Iniciais\"\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": "http://localhost:8080/api/auth/register/professor",
						"description": "Regista um novo utilizador com a role de Professor. A resposta contém um token JWT."
					},
					"response": []
				},
				{
					"name": "Registar Treinador",
					"request": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\n    \"nome\": \"Ash Ketchum\",\n    \"email\": \"ash@poke.gmail.br\",\n    \"senha\": \"pikachu123\",\n    \"insignias\": 0\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": "http://localhost:8080/api/auth/register/treinador"
					},
					"response": []
				},
				{
					"name": "Autenticar (Login)",
					"request": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\n    \"email\": \"carvalho@poke.gmail.br\",\n    \"senha\": \"password123\"\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": "http://localhost:8080/api/auth/authenticate",
						"description": "Faz o login com um utilizador existente para obter um token JWT. **Copie o token da resposta para usar nas requisições protegidas!**"
					},
					"response": []
				}
			]
		},
		{
			"name": "Pokémons",
			"item": [
				{
					"name": "Listar Todos os Pokémons (Público)",
					"request": {
						"method": "GET",
						"header": [],
						"url": "http://localhost:8080/api/v1/pokemon"
					},
					"response": []
				},
				{
					"name": "Buscar Pokémon por ID (Público)",
					"request": {
						"method": "GET",
						"header": [],
						"url": "http://localhost:8080/api/v1/pokemon/25"
					},
					"response": []
				},
				{
					"name": "Criar Pokémon (PROTEGIDO - Professor)",
					"request": {
						"auth": {
							"type": "bearer",
							"bearer": [
								{
									"key": "token",
									"value": "SEU_TOKEN_JWT_AQUI",
									"type": "string"
								}
							]
						},
						"method": "POST",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\n    \"nome\": \"Gengar\",\n    \"tipo1\": \"Ghost\",\n    \"tipo2\": \"Poison\",\n    \"hp\": 60,\n    \"ataque\": 65,\n    \"defesa\": 60,\n    \"especial\": 130,\n    \"velocidade\": 110\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": "http://localhost:8080/api/v1/pokemon"
					},
					"response": []
				},
				{
					"name": "Apagar Pokémon (PROTEGIDO - Professor)",
					"request": {
						"auth": {
							"type": "bearer",
							"bearer": [
								{
									"key": "token",
									"value": "SEU_TOKEN_JWT_AQUI",
									"type": "string"
								}
							]
						},
						"method": "DELETE",
						"header": [],
						"url": "http://localhost:8080/api/v1/pokemon/150"
					},
					"response": []
				}
			]
		},
		{
			"name": "Professores",
			"item": [
				{
					"name": "Buscar Professor por ID (PROTEGIDO)",
					"request": {
						"auth": {
							"type": "bearer",
							"bearer": [
								{
									"key": "token",
									"value": "SEU_TOKEN_JWT_AQUI",
									"type": "string"
								}
							]
						},
						"method": "GET",
						"header": [],
						"url": "http://localhost:8080/api/v1/professores/1"
					},
					"response": []
				},
				{
					"name": "Deletar Professor por ID (PROTEGIDO)",
					"request": {
						"auth": {
							"type": "bearer",
							"bearer": [
								{
									"key": "token",
									"value": "SEU_TOKEN_JWT_AQUI",
									"type": "string"
								}
							]
						},
						"method": "DELETE",
						"header": [],
						"url": "http://localhost:8080/api/v1/professores/1"
					},
					"response": []
				},
				{
					"name": "Atualizar Professor por ID (PROTEGIDO)",
					"request": {
						"auth": {
							"type": "bearer",
							"bearer": [
								{
									"key": "token",
									"value": "SEU_TOKEN_JWT_AQUI",
									"type": "string"
								}
							]
						},
						"method": "PATCH",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"nome\": \"Professor Carvalho Atualizado\",\r\n    \"especialidade\": \"Evolução Pokémon\"\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": "http://localhost:8080/api/v1/professores/1"
					},
					"response": []
				}
			]
		},
		{
			"name": "Utilizadores",
			"item": [
				{
					"name": "Listar Todos os Utilizadores (PROTEGIDO)",
					"request": {
						"auth": {
							"type": "bearer",
							"bearer": [
								{
									"key": "token",
									"value": "SEU_TOKEN_JWT_AQUI",
									"type": "string"
								}
							]
						},
						"method": "GET",
						"header": [],
						"url": "http://localhost:8080/api/v1/usuario"
					},
					"response": []
				}
			]
		},
		{
			"name": "Treinadores",
			"item": [
				{
					"name": "Buscar Treinador por ID (Público)",
					"request": {
						"method": "GET",
						"header": [],
						"url": "http://localhost:8080/api/v1/treinadores/1"
					},
					"response": []
				},
				{
					"name": "Atualizar Treinador",
					"request": {
						"auth": {
							"type": "bearer",
							"bearer": [
								{
									"key": "token",
									"value": "SEU_TOKEN_JWT_AQUI",
									"type": "string"
								}
							]
						},
						"method": "PATCH",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"nome\": \"Ash Atualizado\",\r\n    \"insignias\": 2\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": "http://localhost:8080/api/v1/treinadores/2"
					},
					"response": []
				},
				{
					"name": "Deletar Treinador",
					"request": {
						"auth": {
							"type": "bearer",
							"bearer": [
								{
									"key": "token",
									"value": "SEU_TOKEN_JWT_AQUI",
									"type": "string"
								}
							]
						},
						"method": "DELETE",
						"header": [],
						"url": "http://localhost:8080/api/v1/treinadores/2"
					},
					"response": []
				}
			]
		}
	]
}

</details>
