<%--
  Created by IntelliJ IDEA.
  User: wanderlei
  Date: 07/05/17
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Usuário</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/css/style.css"/>">
</head>
<body>
    <c:import url="../menu.jsp"/>
    <br>
    <c:url var="save" value="/usuario/save"/>
    <form:form modelAttribute="usuario" action="${save}" method="post" enctype="multipart/form-data">
        <form:hidden path="id"/>
        <fieldset>
            <legend>Cadastro de Usuário</legend>
            <div class="campo">
                <form:label path="nome">Nome</form:label><br>
                <form:input path="nome" type="text" requerid="true"/>
            </div>
            <div class="campo">
                <form:label path="email">E-mail</form:label><br>
                <form:input path="email" type="email" requerid="true"/>
            </div>
            <div class="campo">
                <form:label path="senha">Senha</form:label><br>
                <form:password path="senha" requerid="true"/>
            </div>
            <div class="campo">
                <label for="file">Avatar</label><br>
                <input name="file" type="file" requerid="true"/>
            </div>
            <div class="campo">
                <form:label path="perfil">Perfil</form:label><br>
                <form:select path="perfil" requerid="true">
                    <form:option value="ADMIN" label="ADMIN"/>
                    <form:option value="AUTOR" label="AUTOR"/>
                    <form:option value="LEITOR" label="LEITOR"/>
                </form:select>
            </div>
            <div>
                <input type="submit" value="Salvar">
                <input type="reset" value="Limpar">
            </div>
        </fieldset>
    </form:form>
</body>
</html>
