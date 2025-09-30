API REST - Projeto Final Pokédex
API REST desenvolvida como projeto final, simulando uma Pokédex onde utilizadores (Professores e Treinadores) podem registar-se, autenticar-se e interagir com uma base de dados de Pokémons. Professores têm a capacidade de criar e deletar novos Pokémons.

🛠️ Tecnologias Utilizadas
Java 17+

Spring Boot 3

Spring Security & JWT: Para autenticação e autorização.

Spring Data JPA (Hibernate): Para persistência de dados.

SQL Server: Como banco de dados relacional.

Maven: Para gestão de dependências e build do projeto.

Lombok: Para reduzir código boilerplate.

OpenCSV: Para carregar dados iniciais a partir de um ficheiro CSV.

Swagger/OpenAPI: Para documentação interativa da API.

📋 Pré-requisitos
Antes de começar, certifique-se de que tem o seguinte software instalado na sua máquina:

Java Development Kit (JDK) - Versão 17 ou superior

Apache Maven

SQL Server.

SQL Server Management Studio (SSMS).

Um cliente de API como Postman para testar os endpoints.

⚙️ Configuração do Ambiente
Siga estes passos para preparar o seu ambiente local antes de executar a aplicação.

2. Configurar o Banco de Dados (SQL Server)
A aplicação precisa de um banco de dados e de um utilizador para se conectar.

a. Crie o Banco de Dados:
Abra o SSMS, conecte-se ao seu servidor e execute a seguinte query para criar o banco de dados:

CREATE DATABASE pokedexdb;
-- Cria um novo login para o servidor
CREATE LOGIN pokemon_user WITH PASSWORD = 'sua_senha_forte_aqui';

-- Muda para o contexto do seu novo banco de dados
USE pokedexdb;

-- Associa esse login a um utilizador dentro do banco
CREATE USER pokemon_user FOR LOGIN pokemon_user;

-- Concede as permissões necessárias ao utilizador
ALTER ROLE db_owner ADD MEMBER pokemon_user;

3. Configurar as Variáveis de Ambiente
As configurações de conexão com o banco de dados estão no ficheiro src/main/resources/application.properties. Abra este ficheiro e edite as seguintes linhas com as suas credenciais:

# Endereço do seu servidor e nome do banco de dados
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=pokedexdb;encrypt=true;trustServerCertificate=true

# Utilizador e senha que configurou no passo anterior
spring.datasource.username=pokemon_user
spring.datasource.password=sua_senha_forte_aqui

Atenção: Se estiver a usar uma instância nomeada do SQL Server (como SQLEXPRESS), a sua URL pode precisar de ser ajustada: jdbc:sqlserver://localhost\\SQLEXPRESS;...

▶️ Como Executar o Projeto
Com o ambiente configurado, pode executar a aplicação.

Via IDE (Recomendado)
Importe o projeto para a sua IDE favorita (IntelliJ IDEA, Eclipse, VS Code).

A IDE deverá detetar que é um projeto Maven e descarregar as dependências automaticamente.

Encontre a classe principal PokemonFinalProjectApplication.java.

Execute o método main() desta classe. A aplicação irá arrancar.

Via Linha de Comando (Maven)
Navegue até à pasta raiz do projeto e execute o seguinte comando no seu terminal:

mvn spring-boot:run

A aplicação irá compilar, descarregar as dependências (na primeira vez) e iniciar o servidor na porta 8080.

🚀 Acessando a API
Após iniciar a aplicação, pode interagir com os endpoints.

Documentação (Swagger)
Para uma visualização interativa de todos os endpoints disponíveis, aceda à documentação do Swagger no seu navegador:
http://localhost:8080/swagger-ui.html

A partir do Swagger, pode testar os endpoints, ver os modelos de dados e entender os requisitos de autenticação para cada rota.

Endpoints Principais
Autenticação:

POST /api/auth/register/professor: Regista um novo Professor.

POST /api/auth/register/treinador: Regista um novo Treinador.

POST /api/auth/authenticate: Autentica um utilizador e retorna um token JWT.

Pokémon:

GET /api/v1/pokemon: Lista todos os Pokémons.

POST /api/v1/pokemon: Cria um novo Pokémon (requer autenticação como ROLE_PROFESSOR).

Utilizadores (Treinadores e Professores):

As rotas em /api/v1/treinadores e /api/v1/professores permitem visualizar e modificar dados. A modificação de dados requer que o utilizador autenticado seja o dono do recurso ou um ROLE_PROFESSOR.API REST - Projeto Final Pokédex
API REST desenvolvida como projeto final, simulando uma Pokédex onde utilizadores (Professores e Treinadores) podem registar-se, autenticar-se e interagir com uma base de dados de Pokémons. Professores têm a capacidade de criar novos Pokémons.

🛠️ Tecnologias Utilizadas
Java 17+

Spring Boot 3

Spring Security & JWT: Para autenticação e autorização.

Spring Data JPA (Hibernate): Para persistência de dados.

SQL Server: Como banco de dados relacional.

Maven: Para gestão de dependências e build do projeto.

Lombok: Para reduzir código boilerplate.

OpenCSV: Para carregar dados iniciais a partir de um ficheiro CSV.

Swagger/OpenAPI: Para documentação interativa da API.

📋 Pré-requisitos
Antes de começar, certifique-se de que tem o seguinte software instalado na sua máquina:

Java Development Kit (JDK) - Versão 17 ou superior

Apache Maven

SQL Server (qualquer edição, incluindo a Developer ou Express que são gratuitas).

SQL Server Management Studio (SSMS) (Recomendado para gerir o banco de dados).

Um cliente de API como Postman ou Insomnia para testar os endpoints.

⚙️ Configuração do Ambiente
Siga estes passos para preparar o seu ambiente local antes de executar a aplicação.

1. Clonar o Repositório

2. Configurar o Banco de Dados (SQL Server)
A aplicação precisa de um banco de dados e de um utilizador para se conectar.

a. Crie o Banco de Dados:
Abra o SSMS, conecte-se ao seu servidor e execute a seguinte query para criar o banco de dados:

CREATE DATABASE pokedexdb;

-- Cria um novo login para o servidor
CREATE LOGIN pokemon_user WITH PASSWORD = 'sua_senha_forte_aqui';

-- Muda para o contexto do seu novo banco de dados
USE pokedexdb;

-- Associa esse login a um utilizador dentro do banco
CREATE USER pokemon_user FOR LOGIN pokemon_user;

-- Concede as permissões necessárias ao utilizador
ALTER ROLE db_owner ADD MEMBER pokemon_user;

3. Configurar as Variáveis de Ambiente
As configurações de conexão com o banco de dados estão no ficheiro src/main/resources/application.properties. Abra este ficheiro e edite as seguintes linhas com as suas credenciais:

# Endereço do seu servidor e nome do banco de dados
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=pokedexdb;encrypt=true;trustServerCertificate=true

# Utilizador e senha que configurou no passo anterior
spring.datasource.username=pokemon_user
spring.datasource.password=sua_senha_forte_aqui

▶️ Como Executar o Projeto
Com o ambiente configurado, pode executar a aplicação.

Via IDE (Recomendado)
Importe o projeto para a IDE (IntelliJ IDEA).

Encontre a classe principal PokemonFinalProjectApplication.java.

Execute o método main() desta classe.

🚀 Acessando a API
Após iniciar a aplicação, pode interagir com os endpoints.

Documentação (Swagger)
Para uma visualização interativa de todos os endpoints disponíveis, aceda à documentação do Swagger no seu navegador:
http://localhost:8080/swagger-ui.html

A partir do Swagger, pode testar os endpoints, ver os modelos de dados e entender os requisitos de autenticação para cada rota.

🧪 Testando com o Postman
Para facilitar os testes, uma coleção do Postman com todas as requisições da API está disponível.

Importação Manual (JSON)
Alternativamente, pode importar a coleção usando o JSON bruto:

Abra o Postman e vá para File > Import.

Copie e cole o conteúdo JSON abaixo.

<details>
<summary>Clique para ver o JSON da Coleção</summary>

{
	"info": {
		"_postman_id": "ecc28738-036b-4058-af47-ef47d048366b",
		"name": "Pokemon API Project",
		"schema": "[https://schema.getpostman.com/json/collection/v2.0.0/collection.json](https://schema.getpostman.com/json/collection/v2.0.0/collection.json)",
		"_exporter_id": "27253242",
		"_collection_link": "[https://www.postman.com/thasso/workspace/sistemascoorporativos/collection/27253242-ecc28738-036b-4058-af47-ef47d048366b?action=share&source=collection_link&creator=27253242](https://www.postman.com/thasso/workspace/sistemascoorporativos/collection/27253242-ecc28738-036b-4058-af47-ef47d048366b?action=share&source=collection_link&creator=27253242)"
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
						"auth": {
							"type": "bearer",
							"bearer": {
								"token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjYXJ2YWxob0Bwb2tlLmdtYWlsLmJyIiwiaWF0IjoxNzU5MjY5MzYzLCJleHAiOjE3NTkyNzA4MDN9.SeKtw7XLZ0UDejBOqVmLeMIsLscjUdCfMDiF2sqrGw8"
							}
						},
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
					"name": "Listar_AllPokemons(PÚBLICO)",
					"request": {
						"auth": {
							"type": "bearer",
							"bearer": {
								"token": ""
							}
						},
						"method": "GET",
						"header": [],
						"url": "http://localhost:8080/api/v1/pokemon"
					},
					"response": []
				},
				{
					"name": "Criar Pokémon (PROTEGIDO - Professor)",
					"request": {
						"auth": {
							"type": "bearer",
							"bearer": {
								"token": "{{vault:authorization-secret}}"
							}
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
							"bearer": {
								"token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjYXJ2YWxob0Bwb2tlLmdtYWlsLmJyIiwiaWF0IjoxNzU5MjYzNjgwLCJleHAiOjE3NTkyNjUxMjB9.0U0-aRBPEZB5NQaug_qkxi-6-v-n1N6wxEiIERfJuts"
							}
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
							"bearer": {
								"token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhc2hAcG9rZS5nbWFpbC5iciIsImlhdCI6MTc1OTE3ODE0MywiZXhwIjoxNzU5MTc5NTgzfQ.Ts32ft6QXaoOJOIbpjs25w513g7H7XELxUgldtPAiso"
							}
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
							"bearer": {
								"token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjYXJ2YWxob0Bwb2tlLmdtYWlsLmJyIiwiaWF0IjoxNzU5MjU4NjIyLCJleHAiOjE3NTkyNjAwNjJ9.n7vqy2TpPeILvIS2jengnXyGmCr7WBdgVxAHgqa5FC4"
							}
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
							"bearer": {
								"token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjYXJ2YWxob0Bwb2tlLmdtYWlsLmJyIiwiaWF0IjoxNzU5MjU4NjIyLCJleHAiOjE3NTkyNjAwNjJ9.n7vqy2TpPeILvIS2jengnXyGmCr7WBdgVxAHgqa5FC4"
							}
						},
						"method": "PATCH",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"nome\": \"Professor \",\r\n    \"especialidade\": \"Pokémon\"\r\n}",
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
							"bearer": {
								"token": "{{vault:authorization-secret}}"
							}
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
							"bearer": {
								"token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjYXJ2YWxob0Bwb2tlLmdtYWlsLmJyIiwiaWF0IjoxNzU5MjYzNjgwLCJleHAiOjE3NTkyNjUxMjB9.0U0-aRBPEZB5NQaug_qkxi-6-v-n1N6wxEiIERfJuts"
							}
						},
						"method": "PATCH",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"nome\": \"sads\",\r\n    \"insignias\": 2\r\n}",
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
							"bearer": {
								"token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjYXJ2YWxob0Bwb2tlLmdtYWlsLmJyIiwiaWF0IjoxNzU5MjYzNjgwLCJleHAiOjE3NTkyNjUxMjB9.0U0-aRBPEZB5NQaug_qkxi-6-v-n1N6wxEiIERfJuts"
							}
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

</details>🧪 Testando com o Postman
Para facilitar os testes, uma coleção do Postman com todas as requisições da API está disponível.

Importação Rápida (Recomendado)
Clique no botão abaixo para importar a coleção diretamente para o seu Postman:

Importação Manual (JSON)
Alternativamente, pode importar a coleção usando o JSON bruto:

Abra o Postman e vá para File > Import.

Selecione a aba Raw text.

Copie e cole o conteúdo JSON abaixo.

<details>
<summary>Clique para ver o JSON da Coleção</summary>

{
	"info": {
		"_postman_id": "ecc28738-036b-4058-af47-ef47d048366b",
		"name": "Pokemon API Project",
		"schema": "[https://schema.getpostman.com/json/collection/v2.0.0/collection.json](https://schema.getpostman.com/json/collection/v2.0.0/collection.json)",
		"_exporter_id": "27253242",
		"_collection_link": "[https://www.postman.com/thasso/workspace/sistemascoorporativos/collection/27253242-ecc28738-036b-4058-af47-ef47d048366b?action=share&source=collection_link&creator=27253242](https://www.postman.com/thasso/workspace/sistemascoorporativos/collection/27253242-ecc28738-036b-4058-af47-ef47d048366b?action=share&source=collection_link&creator=27253242)"
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
						"auth": {
							"type": "bearer",
							"bearer": {
								"token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjYXJ2YWxob0Bwb2tlLmdtYWlsLmJyIiwiaWF0IjoxNzU5MjY5MzYzLCJleHAiOjE3NTkyNzA4MDN9.SeKtw7XLZ0UDejBOqVmLeMIsLscjUdCfMDiF2sqrGw8"
							}
						},
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
					"name": "Listar_AllPokemons(PÚBLICO)",
					"request": {
						"auth": {
							"type": "bearer",
							"bearer": {
								"token": ""
							}
						},
						"method": "GET",
						"header": [],
						"url": "http://localhost:8080/api/v1/pokemon"
					},
					"response": []
				},
				{
					"name": "Criar Pokémon (PROTEGIDO - Professor)",
					"request": {
						"auth": {
							"type": "bearer",
							"bearer": {
								"token": "{{vault:authorization-secret}}"
							}
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
							"bearer": {
								"token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjYXJ2YWxob0Bwb2tlLmdtYWlsLmJyIiwiaWF0IjoxNzU5MjYzNjgwLCJleHAiOjE3NTkyNjUxMjB9.0U0-aRBPEZB5NQaug_qkxi-6-v-n1N6wxEiIERfJuts"
							}
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
							"bearer": {
								"token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhc2hAcG9rZS5nbWFpbC5iciIsImlhdCI6MTc1OTE3ODE0MywiZXhwIjoxNzU5MTc5NTgzfQ.Ts32ft6QXaoOJOIbpjs25w513g7H7XELxUgldtPAiso"
							}
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
							"bearer": {
								"token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjYXJ2YWxob0Bwb2tlLmdtYWlsLmJyIiwiaWF0IjoxNzU5MjU4NjIyLCJleHAiOjE3NTkyNjAwNjJ9.n7vqy2TpPeILvIS2jengnXyGmCr7WBdgVxAHgqa5FC4"
							}
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
							"bearer": {
								"token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjYXJ2YWxob0Bwb2tlLmdtYWlsLmJyIiwiaWF0IjoxNzU5MjU4NjIyLCJleHAiOjE3NTkyNjAwNjJ9.n7vqy2TpPeILvIS2jengnXyGmCr7WBdgVxAHgqa5FC4"
							}
						},
						"method": "PATCH",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"nome\": \"Professor \",\r\n    \"especialidade\": \"Pokémon\"\r\n}",
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
							"bearer": {
								"token": "{{vault:authorization-secret}}"
							}
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
							"bearer": {
								"token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjYXJ2YWxob0Bwb2tlLmdtYWlsLmJyIiwiaWF0IjoxNzU5MjYzNjgwLCJleHAiOjE3NTkyNjUxMjB9.0U0-aRBPEZB5NQaug_qkxi-6-v-n1N6wxEiIERfJuts"
							}
						},
						"method": "PATCH",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"nome\": \"sads\",\r\n    \"insignias\": 2\r\n}",
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
							"bearer": {
								"token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjYXJ2YWxob0Bwb2tlLmdtYWlsLmJyIiwiaWF0IjoxNzU5MjYzNjgwLCJleHAiOjE3NTkyNjUxMjB9.0U0-aRBPEZB5NQaug_qkxi-6-v-n1N6wxEiIERfJuts"
							}
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

