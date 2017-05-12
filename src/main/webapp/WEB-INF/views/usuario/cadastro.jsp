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
    <title>Usuário</title>
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
    <c:url var="save" value="/usuario/save"/>
    <form:form modelAttribute="usuario" action="${save}" method="post" enctype="multipart/form-data">
        <form:hidden path="id"/>
        <fieldset>
            <legend>Cadastro de Usuário</legend>
            <div>
                <form:label path="nome">Nome</form:label><br>
                <form:input path="nome" type="text" requerid="true"/>
            </div>
            <br>
            <div>
                <form:label path="email">E-mail</form:label><br>
                <form:input path="email" type="email" requerid="true"/>
            </div>
            <br>
            <div>
                <form:label path="senha">Senha</form:label><br>
                <form:password path="senha" requerid="true"/>
            </div>
            <br>
            <div>
                <label for="file">Avatar</label><br>
                <input name="file" type="file" requerid="true"/>
            </div>
            <br>
            <div>
                <form:label path="perfil">Perfil</form:label><br>
                <form:select path="perfil" requerid="true">
                    <form:option value="ADMIN" label="ADMIN"/>
                    <form:option value="AUTOR" label="AUTOR"/>
                    <form:option value="LEITOR" label="LEITOR"/>
                </form:select>
            </div>
            <br>
            <div>
                <input type="submit" value="Salvar">
                <input type="reset" value="Limpar">
            </div>
        </fieldset>
    </form:form>
</body>
</html>
