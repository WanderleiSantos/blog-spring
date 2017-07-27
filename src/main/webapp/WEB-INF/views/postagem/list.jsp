<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Postagens</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/css/style.css"/>">
    <script type="text/javascript" src="<c:url value="/js/jquery-3.2.1.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/postagem.js"/>"></script>
</head>
<body>
<c:import url="../menu.jsp"/>
<br>
<fieldset>

    <legend>Postagens</legend>
    <table class="table">
        <tr>
            <th>Código</th>
            <th>Titulo</th>
            <th>Permalink</th>
            <th>Data </th>
            <th>Autor</th>
            <th>Categorias</th>
            <th>Ação</th>
        </tr>
        <tbody id="tbody">
            <jsp:include page="table-rows.jsp"/>
        </tbody>
    </table>
    <div align="center">
    <c:forEach var="p" begin="1" end="${page.totalPages}">
        <c:choose>
            <c:when test="${ (p - 1) eq page.number }">
                <button id="button_${p}" value="${p}" disabled="disabled">${p}</button>
            </c:when>
            <c:otherwise>
                <button id="button_${p}" value="${p}">${p}</button>
            </c:otherwise>
        </c:choose>
    </c:forEach>
    </div>

    <div id="info">

    </div>

</fieldset>

</body>

</html>
