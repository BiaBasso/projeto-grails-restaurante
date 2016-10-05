<div id="divMensagem"></div>
<g:formRemote name="frmProduto" url="[controller: 'produto', action:'salvar']" update="divMensagem" onSuccess="carregarLista()">

    <p>Nome <input type="text" name="nome" value="${produto.nome}"></p>
    <p>Preço <input type="text" name="preco" value="${produto.preco}"></p>
    <p>Qtde. atual <input type="text" name="quantidade" value="${produto.estoque?.quantidade}"></p>
    <p>Qtde. minima <input type="text" name="quantidadeMinima" value="${produto.estoque?.quantidadeMinima}"></p>

    <input type="submit" name="btnSalvar" value="Salvar">
    <input type="button" name="btnCancelar" value="Cancelar" onclick="cancelar()">
    <input type="hidden" name="id" value="${produto.id}">

</g:formRemote>