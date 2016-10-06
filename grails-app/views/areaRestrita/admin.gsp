<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main"/>
        <title>Área restrita - Restaurante Tô Com Fome</title>
    </head>
    <body>
    <!-- Essa tag, serve para mostrar alguma mensagem para o usuário logado no sistema -->
        <sec:ifLoggedIn>
            Olá, ${usuario}! <!-- Depois de pegar o dado e armazenar numa variavel, uso Groovy, para trazer o dado aqui-->
            <a href="/RestauranteToComFome/j_spring_security_logout">Sair</a> <!-- Para sair -->
        </sec:ifLoggedIn>
    </body>
</html>
