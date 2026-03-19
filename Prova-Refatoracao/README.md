# Package Estrategia

### Interface PagamentoEstrategia
* Interface com uma Variavel calcularValorFinal do tipo Double que recebe parametro (double valorBase).<br>
* Essa Interface tem como objetivo calcular o valor final.

### Classe PagamentoCredito
* Classe PagamentoCredito vai implementar PagamentoEstrategia.
* Está classe vai ter um metodo calcularValorFinal que vai retornar um valor double e tem parametro(double valorBase).<br>
* Ela vai retornar o valorBase * 1.05.<br>
* Como o pagamento é feito pelo credito, é o valor base * 1.05 que no caso vai ter um aumento do valor padrão.<br>

### Classe PagamentoEspecie
* Classe PagamentoEspecie vai implementar PagamentoEstrategia.
* Está classe vai ter um metodo calcularValorFinal que vai retornar um valor double e tem parametro(double valorBase).<br>
* Ela vai retornar o valorBase * 0.92.<br>
* Como o pagamento é feito pelo dinheiro em especie (dinheiro fisico), é o valor base * 0.92 que no caso vai ter um desconto do valor padrão por ser pago em dinheiro vivo.<br>

### Classe PagamentoPagamentoPIX
* Classe PagamentoPIX vai implementar PagamentoEstrategia.
* Está classe vai ter um metodo calcularValorFinal que vai retornar um valor double e tem parametro(double valorBase).<br>
* Ela vai retornar o valorBase * 0.92.<br>
* Como o pagamento é feito pelo pix, é o valor base * 0.90 que no caso vai ter um desconto do valor padrão por ser pago via PIX.<br>


# Package model

### Classe Funcionario
* Ela recebe 3 objetos sendo eles:<br>
-- String nome;<br>
-- String cargo;<br>
-- double salario;<br>
<br>
* Tem o metodo construtor que vai receber esses 3 objetos.<br>
* Gets e Sets com todos os objetos.<br>
* E recebe uma anotação @Overide que vai retornar o nome + cargo + salario<br>

### Classe Pedido
* Ela recebe 4 objetos sendo eles:<br>
  -- Prato prato;<br>
  -- int quantidade;<br>
  -- boolean entrega;<br>
  -- PagamentoEstrategia pagamento<br>
  <br>
* Tem o metodo construtor que vai receber esses 4 objetos.<br>
* Gets e Sets com todos os objetos.<br>

### Classe Prato
* Ela recebe 3 objetos sendo eles:<br>
  -- String nome;<br>
  -- double preco;<br>
  -- int estoque;<br>
  <br>
* Tem o metodo construtor que vai receber esses 3 objetos.<br>
* Gets e Sets com todos os objetos.<br>
* Tem um metodo reduzirEstoque retornando void com parametro(int quantidade). nesse metodo ele vai verificar se a quantidade é maior que o estoque. Caso a quantidade for maior que o estoque ele vai dar uma mensagem (Estoque insuficiente!).<br>
* Tem um metodo adicionarEstoque retornando void com parametro(int quantidade). nesse caso ele so adiciona uma quantidade ao estoque.
* E recebe uma anotação @Overide que vai retornar o nome + preco + estoque<br>

# Package service

### Classe VendaService
* Ela vai ter um metodo processarVenda retornando um double com parametro(Pedido pedido).<br>
* Essa classe vai verificar se o pedido for por entrega. Caso ele seja será adicionado um valor de 15 Reais a mais no valorFinal.<br>
* Caso o pedido não seja por entrega ele somente ira retornar o valorBase.<br>

# Package Utils

### Classe MenuMain
* Na classe MenuMain vai centralizar todos os menus do projeto. Então vai conter o menu<br>
-- exibirMenu (O Menu inicial quando você inicializa o projeto)<br>
-- menuFuncionarios<br>
-- menuCardapio<br>
-- menuEstoque<br>
-- menuVenda<br>
<br>
* Começando pelo exibirMenu ele vai te dar 5 opções. Quando você selecionar uma opção de 1 a 4 ele te levará para os subMenus. Caso você digite 0 ele vai sair do sistema e se você digitar qual quer outro numero diferente ele vai voltar para o menu principal.<br>
* Nesta classe temos o inicializarDados. Que é aonde temos todos os Funcionario cadastrados. e os Pratos cadastrados.<br>
* Nessa mesma parte de inicializarDados. Quando entramos no menu Funcionario ou Cardapio temos a opção de adicionar um novo funcionario ou um novo cardapio. Caso queira você pode deletar um funcionar.<br>
* No metodo Menu Funcionarios podemos | Listar todos os funcionar | Contratar um funcionario | Demitir um Funcionario | Dar um aumento ao um funcionario.<br>
* No metodo Menu Cardapio ele vai te pedir se você deseja cadastrar um novo prato. Caso sim você terá que digitar o nome do prato o preço e a quantidade que tem no estoque dele.<br>
* No metodo Menu Venda ele vai te pedir a quantidade do prato escolhido que será vendidade. Caso não tenha o estoque suficiente do prato ele vai acusar uma mensagem. Caso tenha ele vai pedir se você vai retirar Presencialmente ou se vai ser por Entrega. Após isso ele vai pedir qual vai ser o metodo de pagamento e para finalizar ele Vai te dar o valor total da venda. OBS: O valor total da venda pode variar dependendo do metodo de pagamento.<br>
<br>

## Classe Main
* Aqui na classe Main ela irá somente puxar a classe MenuMain.
* Fiz deste modo para deixar a classe principal a "MAIN" de uma forma visualmente limpa.
