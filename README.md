# AppSalarioCalculavel — Calculadora de Salário (Android)

> Aplicativo Android (Java) que permite autenticação local (cadastro/login) e calcula descontos de INSS e IR, aplica salário-família quando cabível e exibe o salário líquido com valores detalhados.

---


## Sobre
AppSalarioCalculavel é um projeto educativo/útil em Java para Android (Android Studio) que demonstra:
- cadastro e login local de usuários;
- cálculo de descontos trabalhistas (INSS, IR), salário-família e salário líquido;
- arquitetura organizada (MVP) com código testável e documentação.

---

## Principais funcionalidades
- Cadastro de usuário (id UUID, nome, email, senha) com armazenamento local seguro.  
- Login local por email/senha.  
- Tela de **Calculadora de Salário** com entradas:
  - Nome do funcionário (texto)
  - Salário bruto (numérico)
  - Sexo (Masculino / Feminino — radiobutton)
  - Número de filhos (inteiro)
- Cálculo de:
  - desconto INSS (taxa flat por faixa),
  - desconto IR (taxa flat por faixa),
  - salário-família quando aplicável,
  - salário líquido.
- Exibição detalhada dos valores e cabeçalho com tratamento (Sr./Sra.).
- Botão “Novo Cálculo” para limpar o formulário.

---

## Tecnologias e requisitos
- Linguagem: **Java**  
- IDE: **Android Studio**  
- Architecture pattern: **MVP**  
- Min SDK: **21** (configurável)  
- Build system: **Gradle**  
- Testes: **JUnit** (unit tests)  
- Recomendado: AndroidX, Jetpack Libraries  

---




## Regras de cálculo (especificação exata)


### INSS (desconto sobre o salário bruto — flat rate)
- Até R$ 1.212,00 → **7,5%**  
- De R$ 1.212,01 até R$ 2.427,35 → **9%**  
- De R$ 2.427,36 até R$ 3.641,03 → **12%**  
- De R$ 3.641,04 até R$ 7.087,22 → **14%**

## Como  executar
1. Clone o repositório:
```bash
git clone https://github.com/Bruno7Martinho/AppSalarioCalculavel

