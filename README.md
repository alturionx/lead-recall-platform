# Lead Recall AI

Lead Recall AI é uma plataforma SaaS inteligente desenvolvida para automatizar a recuperação de oportunidades comerciais em concessionárias e empresas com vendas baseadas em estoque.

A plataforma utiliza Inteligência Artificial, arquitetura orientada a eventos e um motor de matching para identificar automaticamente leads compatíveis com veículos disponíveis, gerando oportunidades comerciais em tempo real.

---

## 🚀 Arquitetura

O sistema é composto pelos seguintes serviços executados em containers Docker:

| Serviço | Tecnologia | Responsabilidade |
|----------|------------|------------------|
| Frontend | React + Vite + Nginx | Interface Web da plataforma |
| Backend | Spring Boot | API REST e regras de negócio |
| Banco de Dados | MySQL | Persistência dos dados |
| Inteligência Artificial | Ollama + Qwen2.5:3b | Processamento inteligente das mensagens |
| Cache | Redis | Cache e suporte aos serviços de infraestrutura |
| WhatsApp | Evolution API *(Em desenvolvimento)* | Integração com o WhatsApp |

---

## 📦 Estrutura do Projeto

```text
lead-recall-platform
│
├── frontend/
├── backend/
├── database/
├── ai/
├── infrastructure/
│   └── evolution/
│
├── docker-compose.yml
├── .env
└── README.md
```

---

## 🐳 Execução

Subir toda a infraestrutura:

```bash
docker compose up --build -d
```

Parar todos os containers:

```bash
docker compose down
```

Visualizar os containers em execução:

```bash
docker ps
```

---

## 📋 Status da Infraestrutura

- ✅ Frontend
- ✅ Backend
- ✅ MySQL
- ✅ Ollama
- ✅ Qwen2.5:3b
- ✅ Redis
- 🚧 Evolution API