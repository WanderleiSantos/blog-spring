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
    <title>Perfil</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/css/style.css"/>">
</head>
<body>
    <c:import url="../menu.jsp"/>
    <br>
    <fieldset>

        <legend>Perfil</legend>
        <table class="table">
            <tr>
                <th>Avatar</th>
                <th>Nome</th>
                <th>E-mail</th>
                <th>Data Cadastro</th>
                <th>Perfil</th>
                <th>Ação</th>
            </tr>
            <tr>
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
        </table>

    </fieldset>

</body>
</html>
