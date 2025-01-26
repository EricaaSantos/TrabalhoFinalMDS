**Projeto: The Hotel - Sistema de Gestão de Hotéis**

1.**Descrição do Projeto:**

O projeto "The Hotel" consiste em um sistema de gestão para hotéis que permite realizar operações relacionadas à administração de quartos, reservas e manutenções. Este sistema foi desenvolvido com foco na organização, simplicidade e eficiência, garantindo a funcionalidade dos fluxos de trabalho essenciais para gestores e funcionários.

2.**Funcionalidades**
 - Gestão de Quartos:
   - Criação, edição, remoção e listagem de quartos.
   - Registo do estado de ocupação dos quartos.
 - Gestão de Manutenções:
   - Registo de manutenções associadas aos quartos.
   - Conclusão e remoção de manutenções realizadas. 
 - Gestão de Reservas:
   - Criação, confirmação e gestão de reservas associadas aos quartos.
 - Fluxo de Navegação:
   - Menu interativo para facilitar o acesso às funcionalidades.
   - Opção de retorno ao menu principal em todos os submenus.

3.**Decisões Tomadas**
1. Arquitetura e Estrutura do Sistema
Optou-se por uma arquitetura orientada a objetos para facilitar a manutenção e extensibilidade do código. A divisão do sistema foi feita em classes principais:
 - Quarto: Representa os quartos do hotel e seus atributos (número, capacidade, estado de ocupação, lista de manutenções).
 - Manutencao: Representa manutenções realizadas nos quartos.
 - Reserva: Representa as reservas feitas pelos hóspedes.
 - Pessoa: Classe base abstrata para entidades como Gestor e Funcionario.
   - Gestor e Funcionario: Responsáveis pelas operações de gestão e funcionalidade do hotel.

2. Encapsulamento e Modulação
Todos os atributos das classes foram encapsulados, garantindo o controle de acesso por meio de getters e setters.
As classes foram separadas em arquivos distintos para melhor organização do código.

3. Uso de Herança
A classe Pessoa foi criada como base para Gestor e Funcionario, garantindo a reutilização de atributos e métodos compartilhados.

4. Validações
Foram incluídas validações nos construtores para evitar a criação de objetos com valores inválidos (ex.: capacidade de quarto negativa ou ID nulo).
Nos métodos que lidam com listas, verificou-se a existência dos elementos antes de realizar operações.

5. Sistema de Navegação
O menu interativo foi implementado com um fluxo intuitivo, permitindo que o utilizador escolha entre as funcionalidades e possa voltar ao menu principal em qualquer momento.

6. Testes Unitários
Utilizou-se o JUnit 5 para garantir a qualidade do código por meio de testes unitários.
Foram implementados testes para validar os fluxos principais e cenários de extensão, como:
 - Criação, edição e remoção de quartos.
 - Registo e conclusão de manutenções.
 - Criação e confirmação de reservas.

4.**Ferramentas Utilizadas**
Linguagem: Java 17
Framework de Teste: JUnit 5
Build Tool: Maven
IDE: VSCode

5.**Conclusão:**
O projeto "The Hotel" foi desenvolvido com foco na simplicidade e organização. As decisões tomadas garantiram a robustez do sistema e facilidade de expansão futura. O uso de boas práticas de programação e testes unitários contribuiu para a confiabilidade e manutenção do código.

