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
    <title>Usuários</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/css/style.css"/>">
</head>
<body>
    <c:import url="../menu.jsp"/>
    <br>
    <fieldset>

        <legend>Usuários</legend>
        <table class="table">
            <tr>
                <th>Avatar</th>
                <th>
                    <a href="<c:url value="/usuario/sort/asc/nome/page/1"/>"> &darr; </a>
                    Nome
                    <a href="<c:url value="/usuario/sort/desc/nome/page/1"/>"> &uarr; </a>
                </th>
                <th>E-mail</th>
                <th>Data Cadastro</th>
                <th>Perfil</th>
                <th>Ação</th>
            </tr>
            <c:forEach var="usuario" items="${ page.content }" varStatus="i">
            <tr bgcolor='${i.count % 2 != 0 ? '#f1f1f1' : 'white'}'>
                <td>
                    <a href="<c:url value="/avatar/update/${usuario.avatar.id}"/>" title="Alterar imagem">
                        <img src="<c:url value="/avatar/load/${usuario.avatar.id}"/>" style="width:25px; height: 25px"/>
                    </a>
                </td>
                <td>${usuario.nome}</td>
                <td>${usuario.email}</td>
                <td>${usuario.dataCadastro}</td>
                <td>${usuario.perfil}</td>
                <td>
                    <c:url var="update" value="/usuario/update/${usuario.id}"/>
                    <a href="${update}" title="Editar">&#9445</a>
                    <a href="#" title="Excluir">&#9447</a>
                </td>
            </tr>
            </c:forEach>
        </table>
        <div align="center">
            [
            <c:forEach var="p" begin="1" end="${page.totalPages}">
                <c:choose>
                    <c:when test="${(p-1) eq page.number}">
                        <label style="font-size: 18pt">${p}</label>
                    </c:when>
                    <c:otherwise>
                        <label>
                            <a href="<c:url value="${urlPagination}/${p}"/>" title="Go to ${p}">${p}</a>
                        </label>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            ]
        </div>
    </fieldset>

</body>

</html>
