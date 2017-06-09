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
                    <h2>${p.titulo}</h2>
                    <p>Autor: ${p.autor.nome} | Data: ${p.dataPostagem}</p>
                </div>
                <div>
                    <p>${p.texto}</p>
                </div>
                <div>
                    <p>
                        <c:forEach var="c" items="${p.categorias}">
                            | ${c.descricao}
                        </c:forEach>
                    </p>
                </div>
            </div>
        </c:forEach>
    </fieldset>
</body>
</html>
