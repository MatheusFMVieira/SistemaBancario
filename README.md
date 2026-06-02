## O que é esse projeto?

Imagine que você está criando um **mini banco digital**. Esse sistema permite que as pessoas:
- Abrir uma conta no banco
- Colocar dinheiro na conta (depositar)
- Sacar dinheiro da conta
- Mandar dinheiro para outra pessoa (transferência)
- Ver o histórico de tudo que aconteceu na conta

Esse projeto é exatamente isso! É como um mini banco rodando no computador.

---

## Como o projeto está organizado?

Pense no projeto como se fosse uma empresa com diferentes departamentos:

```
Sistema Bancário
│
├── entities (As "coisas" do banco)
│   ├── Cliente (Uma pessoa que tem conta)
│   ├── Conta (A conta bancária da pessoa)
│   ├── ContaCorrente (Um tipo de conta mais comum)
│   ├── ContaPoupanca (Um tipo de conta para poupar)
│   └── Transacao (Um registro de movimento de dinheiro)
│
├── services (Quem faz o trabalho)
│   └── Banco (A gerência que controla tudo)
│
├── ui (A tela que você vê)
│   └── Menu (O menu que aparece na tela)
│
├── anums (Classificações)
│   ├── TipoConta (Se é Corrente ou Poupança)
│   └── TipoTransacao (Qual tipo de movimento: saque, depósito...)
│
└── interfaces (As regras que todos devem seguir)
    └── OperacaoBancaria (O que toda conta deve poder fazer)
```

---

## O que é um Cliente?

Um **Cliente** é simplesmente uma pessoa. Cada pessoa tem:
- **Nome** - Como ela se chama
- **CPF** - O documento dela (tipo um ID único)
- **Email** - Para receber notificações

Exemplo:
```
Cliente: João Silva
CPF: 123.456.789-10
Email: joao@email.com
```

---

## O que é uma Conta?

Uma **Conta** é a conta bancária. Cada conta tem:

| Informação | O que significa |
|-----------|-----------------|
| **Número** | Um código único para identificar a conta (ex: 12345) |
| **Saldo** | Quanto dinheiro tem na conta agora |
| **Titular** | Quem é o dono da conta (qual Cliente) |
| **Histórico** | Uma lista de tudo que aconteceu nessa conta |

### Tipos de Conta

Existem **2 tipos** de conta:

1. **Conta Corrente** 
   - É como uma conta de uso diário
   - Você pode fazer quantas transações quiser
   - Exemplo: Sua conta no banco normal

2. **Conta Poupança**
   - É para guardar dinheiro
   - É mais "segura" (em um banco real teria juros)
   - Exemplo: Sua "poupança" para o futuro

---

## Operações Bancárias - O que você pode fazer?

### 1. Abrir uma Conta
Quando você quer criar uma conta nova:
- Você diz seu nome, CPF e email
- Escolhe se quer Conta Corrente ou Poupança
- O sistema cria a conta automaticamente

**O que acontece atrás das cenas:**
1. Um novo "Cliente" é criado
2. Uma nova "Conta" é criada e associada a esse cliente
3. A conta recebe um número único

---

### 2. Depositar Dinheiro
Quando você quer colocar dinheiro na conta:
- Você diz qual é o número da sua conta
- Você diz quanto quer depositar
- Pronto! O dinheiro foi adicionado

**O que acontece atrás das cenas:**
1. O sistema procura a conta pelo número
2. Adiciona o valor ao saldo
3. Registra essa operação no histórico

---

### 3. Sacar Dinheiro
Quando você quer tirar dinheiro da conta:
- Você diz qual é o número da sua conta
- Você diz quanto quer sacar
- O sistema verifica se você tem dinheiro suficiente
- Se tiver, o dinheiro é removido

**O que acontece atrás das cenas:**
1. O sistema procura a conta
2. Verifica se tem saldo suficiente
3. Se tiver, subtrai o valor do saldo
4. Se não tiver, avisa que não dá

**Importante:** Você NÃO pode sacar mais do que tem! É como na vida real.

---

### 4. Transferência
Quando você quer mandar dinheiro para outra pessoa:
- Você diz qual é o número da SUA conta (origem)
- Você diz qual é o número da conta de quem vai receber (destino)
- Você diz quanto quer transferir
- Pronto! O dinheiro saiu da sua conta e entrou na outra

**O que acontece atrás das cenas:**
1. Sistema pega sua conta (origem)
2. Sistema faz um "saque" da sua conta
3. Sistema faz um "depósito" na conta do outro
4. Registra essa operação nos dois históricos

**Resumo:** É como um saque de você + um depósito para outra pessoa ao mesmo tempo.

---

### 5. Ver o Extrato
Quando você quer ver o histórico da sua conta:
- Você diz qual é o número da sua conta
- O sistema mostra todas as operações que aconteceram

**O que ele mostra:**
```
===== EXTRATO BANCÁRIO =====
Titular: João Silva
Conta: 12345
-----------------------------
[Depósito de R$ 1000]
[Saque de R$ 200]
[Transferência enviada de R$ 500]
-----------------------------
Saldo atual: R$ 300
=============================
```

---

## Como o sistema funciona? (De forma simples)

### Passo a passo quando você usa o sistema:

```
INICIO
  ↓
MENU APARECE NA TELA
  ↓
VOCÊ ESCOLHE UMA OPÇÃO (1, 2, 3, 4, 5 ou 6)
  ↓
SISTEMA FAZ O QUE VOCÊ PEDIU
  ↓
RESULTADO APARECE NA TELA
  ↓
VOLTA PARA O MENU (até você escolher sair)
  ↓
FIM
```

### Quando você faz uma operação:

```
VOCÊ escolhe: "Depositar"
  ↓
VOCÊ diz: "Número da conta: 12345"
  ↓
VOCÊ diz: "Valor: 1000"
  ↓
SISTEMA procura: "Existe uma conta 12345?"
  ↓
  ├─ SIM → Adiciona 1000 ao saldo
  └─ NÃO → Mostra "Conta não encontrada"
  ↓
MOSTRA RESULTADO NA TELA
```

---

## O Banco (Banco.java)

O **Banco** é quem controla tudo. Ele:
- **Armazena** todas as contas que foram criadas
- **Cria** novas contas quando alguém pede
- **Procura** as contas pelo número
- **Verifica** se tudo está ok

Pense no Banco como o gerente de um banco de verdade:
- Ele sabe quem tem conta
- Ele autoriza as operações
- Ele guarda o registro de tudo

---

## O Menu (Menu.java)

O **Menu** é o que você vê na tela. É como um painel de controle com botões:

```
===== SISTEMA BANCÁRIO =====
1 - Abrir Conta
2 - Depositar
3 - Sacar
4 - Transferência
5 - Extrato
6 - Sair
Escolha uma opção: _
```

Quando você digita um número, o sistema entende qual operação fazer.

---

## Exemplo de uma história completa

Vamos acompanhar João do início ao fim:

### 1. João abre uma conta
```
1 - Abrir Conta
Nome: João Silva
CPF: 123.456.789-10
Email: joao@email.com
Tipo: Conta Corrente
↓
Conta criada com sucesso! Número: 1001
```

### 2. João deposita R$ 1000
```
2 - Depositar
Número da conta: 1001
Valor: 1000
↓
Depósito realizado com sucesso!
Saldo agora: R$ 1000
```

### 3. João saca R$ 200
```
3 - Sacar
Número da conta: 1001
Valor: 200
↓
Saque realizado com sucesso!
Saldo agora: R$ 800
```

### 4. João vê o extrato
```
5 - Extrato
Número da conta: 1001
↓
===== EXTRATO BANCÁRIO =====
Titular: João Silva
Conta: 1001
-----------------------------
Depósito de R$ 1000
Saque de R$ 200
-----------------------------
Saldo atual: R$ 800
=============================
```
