<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Postagens</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/css/style.css"/>">
</head>
<body>
    <c:import url="../menu.jsp"/>
    <br>
    <c:url var="save" value="/postagem/save"/>
    <form:form modelAttribute="postagem" action="${save}" method="post">
        <form:hidden path="id"/>
        <fieldset>
            <legend>Cadastro de Postagens</legend>
            <div class="campo">
                <form:label path="titulo">Titulo</form:label><br>
                <form:input path="titulo" type="text" requerid="true"/>
            </div>
            <div class="campo">
                <form:label path="texto">Post</form:label><br>
                <form:textarea path="texto" rows="15" cols="80"/>
            </div>
            <div class="campo">
                <form:label path="categorias">Categorias</form:label>
                <form:select path="categorias" multiple="true">
                    <form:options items="${categorias}" itemValue="id" itemLabel="descricao"/>
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
