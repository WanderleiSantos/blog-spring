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
    <title>Home</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/css/style.css"/>">
</head>
<body>
    <fieldset class="header">
        <h1>Blog curso</h1>
    </fieldset><br>

    <c:import url="./menu.jsp"/>
    <br>

    <fieldset>
        <c:forEach var="p" items="${postagens}">
            <div>
                <div>
                    <h2> <a href="<c:url value="/${p.permalink}"/>" title="${p.titulo}"> ${p.titulo} </a></h2>
                    <p>Autor: <a href="<c:url value="/autor/${p.autor.nome}"/>"> ${p.autor.nome} </a> |
                        Data: <fmt:formatDate value="${p.dataPostagem}" type="both"/> </p>
                </div>
                <div>
                    <p>
                        <c:forTokens var="resumo" items="${p.texto}" delims=" " begin="0" end="60">
                           ${resumo}
                        </c:forTokens><a href="<c:url value="/${p.permalink}"/>"> [ Leia mais... ] </a></h2>
                    </p>
                </div>
                <div>
                    <p>
                        <c:forEach var="c" items="${p.categorias}">
                            | <a href="<c:url value="/categoria/${c.permalink}"/>" title="${c.descricao}">${c.descricao}</a>
                        </c:forEach>
                    </p>
                </div>
            </div>
        </c:forEach>
    </fieldset>
</body>
</html>
