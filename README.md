# 🚀 Projeto de Automação Web e API com Java (RestAssured + Selenium)

Este projeto realiza testes automatizados em uma aplicação de gerenciamento de eventos, cobrindo testes de **API REST** utilizando **RestAssured** e testes **end-to-end (GUI)** utilizando **Selenium WebDriver** com **JUnit**. Os testes garantem o correto funcionamento das funcionalidades de criação e exclusão de eventos via interface e API.

---

## 📁 Estrutura do Projeto

```
📦 src
├── main
│   └── java
│       └── core                     # Configurações de driver, propriedades e ambiente
├── test
│   └── java
│       ├── api
│       │   ├── endpoints            # Classe com chamadas REST (EventoService)
│       │   └── test                 # Testes de API (JUnit)
│       ├── gui
│       │   ├── page                 # PageObjects (EventoPage)
│       │   └── test                 # Testes GUI com Selenium
│       └── hooks                   # Classe de suíte de testes
├── resources
│   └── env.properties              # Configuração de ambientes (baseURI, port)
```

---

## 🧪 Funcionalidades Testadas

### ✅ Testes de API (RestAssured)

- `POST /evento`: Criação de evento com data futura  
- Validação de data inválida (data anterior à atual)  
- `DELETE /evento`: Exclusão do evento criado para manter o ambiente limpo

### ✅ Testes GUI (Selenium)

- Preenchimento e envio de formulário para criação de evento  
- Validação de mensagem de erro ao inserir data inválida  
- Validação de mensagem de sucesso ao excluir um evento

---

## 🛠️ Tecnologias Utilizadas

- Java 21  
- Maven  
- RestAssured  
- Selenium WebDriver  
- WebDriverManager  
- JUnit 4  
- JavaFaker (geração de dados)  
- ExtentReports (relatórios)

---

## ⚙️ Execução Local

### 1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio
```

### 2. Execute os testes com Maven:

```bash
mvn clean test
```

---

## 🌐 Configuração de Ambiente

O arquivo `env.properties` define os ambientes para execução dos testes:

```properties
env=prod

prod.baseURI=https://micro-servico-evento.onrender.com
prod.port=443
```

---

## 🔄 Suite de Testes

A classe `TestHooks.java` executa em conjunto os testes de API e GUI:

```java
@RunWith(Suite.class)
@Suite.SuiteClasses({
    EventoTest.class,             // GUI
    CriarEventoServiceTest.class  // API
})
public class TestHooks {}
```

---

## 📃 Relatórios

O relatório HTML pode ser gerado e armazenado via `ExtentReports` em:

```
src/test/resources/relatorio.html
```

---

## 📅 Utilitário de Data

A classe `Generator` fornece datas futuras e passadas para os testes:

```java
String dataFutura = Generator.dateFuture;
String dataPassada = Generator.datesPast;
```

---
## 📌 Projeto Original

Este projeto de testes foi construído com base na aplicação de gerenciamento de eventos desenvolvida por [Alan Paulo de Jesus](https://www.linkedin.com/in/alanpaulodejesus/) no [github](https://github.com/alanpaulodejesus).

🔗 Repositório original da aplicação:  
[https://github.com/alanpaulodejesus/micro-servico-evento](https://github.com/alanpaulodejesus/micro-servico-evento)
