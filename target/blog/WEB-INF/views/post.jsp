<%--
  Created by IntelliJ IDEA.
  User: wanderlei
  Date: 09/06/17
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${postagem.titulo}</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/css/style.css"/>">
</head>
<body>
<fieldset class="header">
    <h1>Blog curso</h1>
</fieldset><br>

<c:import url="./menu.jsp"/>
<br>

<fieldset>
    <div>
        <div>
            <h2>${postagem.titulo}</h2>
            <p>Autor: <a href="<c:url value="/autor/${postagem.autor.nome}"/>"> ${postagem.autor.nome} </a> |
                Data: <fmt:formatDate value="${postagem.dataPostagem}" type="both"/> </p>
        </div>
        <div>
            <p>${postagem.texto}</p>
        </div>
        <div>
            <p>
                <c:forEach var="c" items="${postagem.categorias}">
                    | <a href="<c:url value="/categoria/${c.permalink}"/>" title="${c.descricao}">${c.descricao}</a>
                </c:forEach>
            </p>
        </div>
    </div>
</fieldset>
</body>
</html>
