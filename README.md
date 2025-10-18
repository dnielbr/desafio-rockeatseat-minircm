# 📝 Mini CRM Challenge

Este projeto é um desafio técnico de implementação de um Mini CRM utilizando **Spring Boot** e **Spring Data JPA**.  
O objetivo é praticar conceitos de **REST API**, **persistência de dados** e **boas práticas de modelagem**.

---

## 🚀 Tecnologias utilizadas
- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Banco de dados H2 (em memória)

---

## 📌 Modelagem
**Cliente**
- `id` (Long)
- `nome` (String)
- `email` (String)

**Contato**
- `id` (Long)
- `tipo` (ex.: "telefone", "email")
- `valor` (String)
- `cliente` (Cliente relacionado)

👉 Relacionamento: **1 Cliente → N Contatos** (OneToMany / ManyToOne)

---

## 🔗 Endpoints obrigatórios
### Cliente
- `POST /clientes` → cria um cliente (sem contatos) → **201 Created**
- `GET /clientes` → lista todos os clientes (com contatos, se mapeado)

### Contato
- `POST /contatos?clienteId={id}`  
  ou  
  `POST /clientes/{id}/contatos` → cria contato vinculado a cliente → **404 Not Found** se cliente não existir

- `GET /clientes/{id}/contatos` → lista os contatos de um cliente → **404 Not Found** se não existir

---

## ⚙️ Regras de resposta
- **201 Created** → criação bem-sucedida
- **200 OK** → buscas com sucesso
- **404 Not Found** → recurso não encontrado
- **400 Bad Request** → requisição inválida

---

## ✅ Critérios de avaliação
- **Modelagem & mapeamento (1-N OK)** → 25 pts
- **Endpoints funcionando conforme enunciado** → 35 pts
- **Status HTTP corretos (ResponseEntity)** → 15 pts
- **Seed com CommandLineRunner** → 10 pts
- **Organização do projeto (pacotes claros)** → 15 pts

---

## ▶️ Como rodar
Clone o repositório:
```bash
git clone https://github.com/seu-usuario/mini-crm.git
cd mini-crm
