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
    <style type="text/css">

        .campo{
            margin-bottom: 1em;
        }

        .campo input:FOCUS, .campo select:FOCUS {
            background: blanchedalmond;
        }

        .table {
            width: 640px;
            text-align: center;
        }

        fieldset{
            width: 640px;
            margin: 0 auto;
        }

        fieldset.group .campo {
            float: left;
            margin-right: 2em;
        }

        .master {
            width: 960px;
            margin: 0 auto;
        }
    </style>
</head>
<body>
    <fieldset>
        <legend>Perfil</legend>
        <table class="table">
            <tr>
                <th>Nome</th>
                <th>E-mail</th>
                <th>Data Cadastro</th>
                <th>Perfil</th>
                <th>Ação</th>
            </tr>
            <tr>
                <td>${usuario.nome}</td>
                <td>${usuario.email}</td>
                <td>${usuario.dataCadastro}</td>
                <td>${usuario.perfil}</td>
                <td>
                    <a href="#" title="Editar">&#9445</a>
                    <a href="#" title="Excluir">&#9447</a>
                </td>
            </tr>
        </table>
    </fieldset>
</body>
</html>
