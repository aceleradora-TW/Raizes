# Documentação Spike Login

#### Descoberta
- Autenticação Login por SpringSecurity
- Código baseado no projeto **_Hospebem_**
 
#### Dificuldades
- Erro nos testes; retorna erro de classe `bean` não compatível, que não está duplicada realmente;
- Precisa dizer cada página que ele não precisa validar;
    * No caso, cada página que **NÃO** precisa de autenticação, precisa ser dita.

#### Vantagens
- Níveis de acesso
- Cada página é validada, ou seja, se uma nova página for criada ele também vai tentar validar
    * Menor risco de ter páginas privadas sendo acessadas
