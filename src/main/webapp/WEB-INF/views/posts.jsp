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
        <div>
            <form action="<c:url value="/search"/>" method="get">
                <input name="texto" type="search" placeholder="busca por palavra chave">
                <input type="submit" value="Localizar">
            </form>
        </div>
        <c:forEach var="p" items="${page.content}">
            <div>
                <div>
                    <h2> <a href="<c:url value="/${p.permalink}"/>" title="${p.titulo}"> ${p.titulo} </a></h2>
                    <p>Autor: <a href="<c:url value="/autor/${p.autor.id}/page/1"/>"> ${p.autor.nome} </a> |
                       Data: <fmt:formatDate value="${p.dataPostagem}" type="both"/>
                       # ${fn:length(p.comentarios)}
                    </p>
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
                            | <a href="<c:url value="/categoria/${c.permalink}/page/1"/>" title="${c.descricao}">${c.descricao}</a>
                        </c:forEach>
                    </p>
                </div>
            </div>
        </c:forEach>
        <c:import url="paginacao.jsp"/>
    </fieldset>
</body>
</html>
