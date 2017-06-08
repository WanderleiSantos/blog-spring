<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Autor</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/css/style.css"/>">
</head>
<body>
<c:import url="../menu.jsp"/>
<br>
<c:url var="save" value="/autor/save"/>
<form:form modelAttribute="autor" action="${save}" method="post" >
    <form:hidden path="id"/>
    <fieldset>
        <legend>Cadastro de Autor</legend>
        <div class="campo">
            <form:label path="nome">Nome</form:label><br>
            <form:input path="nome" type="text" requerid="true"/>
        </div>
        <div class="campo">
            <form:label path="biografia">Biografia</form:label><br>
            <form:textarea path="biografia" cols="50" rows="10" requerid="true"/>
        </div>
        <div>
            <input type="submit" value="Salvar">
            <input type="reset" value="Limpar">
        </div>
    </fieldset>
</form:form>
</body>
</html>
