<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editar Avatar</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/css/style.css"/>">
</head>
<body>
<c:import url="../menu.jsp"/>
<br>
    <c:url var="save" value="/avatar/update"/>
    <form:form modelAttribute="avatar" action="${save}" method="post" enctype="multipart/form-data">
        <form:hidden path="id"/>
        <fieldset class="grupo">
            <legend>Editar</legend>
            <div class="campo">
                <label>Avatar</label>
                <input type="file" name="file" required="true">
            </div>
            <div>
                <input type="submit" value="Salvar">
                <input type="reset" value="Limpar">
            </div>
        </fieldset>
    </form:form>
</body>
</html>
