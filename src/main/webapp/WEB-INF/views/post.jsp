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
                <p>Autor: <a href="<c:url value="/autor/${postagem.autor.id}/page/1"/>"> ${postagem.autor.nome} </a> |
                    Data: <fmt:formatDate value="${postagem.dataPostagem}" type="both"/> </p>
            </div>
            <div>
                <p>${postagem.texto}</p>
            </div>
            <div>
                <p>
                    <c:forEach var="c" items="${postagem.categorias}">
                        | <a href="<c:url value="/categoria/${c.permalink}/page/1"/>" title="${c.descricao}">${c.descricao}</a>
                    </c:forEach>
                </p>
            </div>
        </div>
        <div class="post-autor">
            <img class="post-avatar" src="<c:url value="/avatar/load/${postagem.autor.usuario.avatar.id}"/>"/>
            <p><strong>${postagem.autor.nome}</strong></p>
            <p>${postagem.autor.biografia}</p>
        </div>
        <c:import url="coments.jsp"/>
    </fieldset>
</body>
</html>
