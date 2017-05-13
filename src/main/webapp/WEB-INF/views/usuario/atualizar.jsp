<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editar Usuário</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/css/style.css"/>">
</head>
<body>
    <fieldset>
        <legend>Editar Dados</legend>
        <c:url var="save" value="/usuario/update/senha"/>
        <form:form modelAttribute="usuario" action="${save}" method="post">
            <form:hidden path="id"/>
            <fieldset class="grupo">
                <legend>Editar Senha</legend>
                <div class="campo">
                    <form:label path="senha">Senha</form:label>
                    <form:password path="senha" required="true"/>
                </div>
                <div>
                    <input type="submit" value="Salvar">
                    <input type="reset" value="Limpar">
                </div>
            </fieldset>
        </form:form>

        <c:url var="save" value="/usuario/update"/>
        <form:form modelAttribute="usuario" action="${save}" method="post">
            <form:hidden path="id"/>
            <fieldset class="grupo">
                <legend>Editar Nome e E-mail</legend>
                <div class="campo">
                    <form:label path="nome">Nome</form:label><br>
                    <form:input path="nome" type="text" requerid="true"/>
                </div>
                <div class="campo">
                    <form:label path="email">E-mail</form:label><br>
                    <form:input path="email" type="email" requerid="true"/>
                </div>
                <div>
                    <input type="submit" value="Salvar">
                    <input type="reset" value="Limpar">
                </div>
            </fieldset>
        </form:form>
    </fieldset>
</body>
</html>
