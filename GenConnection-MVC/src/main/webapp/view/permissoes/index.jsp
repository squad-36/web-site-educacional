<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.Permissao" import="java.util.List"%>

<%
@SuppressWarnings("unchecked")
List<Permissao> lista = (List<Permissao>) request.getAttribute("permissao");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Permissões</title>



<!-- CDN CSS Bootstrap v-5.1 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>



	<header class="container-fluid bg-primary p-4 text-light">
		<h1>Permissões</h1>
	</header>



	<!-- Menu -->
	<ul class="nav justify-content-center">
		<li class="nav-item"><a class="nav-link active text-dark fs-4"
			aria-current="page" href="../../index.html">Home</a></li>
		<li class="nav-item"><a class="nav-link active text-dark fs-4"
			href="./index.jsp">Permissões</a></li>
		<li class="nav-item"><a class="nav-link text-dark fs-4"
			href="../usuario/index.jsp">Usuarios</a></li>
		<li class="nav-item"><a class="nav-link text-dark fs-4"
			href="../atividades/index.jsp">Atividades</a></li>
		<li class="nav-item"><a class="nav-link text-dark fs-4"
			href="../jogos/index.jsp">Jogos</a></li>
		<li class="nav-item"><a class="nav-link text-dark fs-4"
			href="../notificacoes/index.jsp">Notificações</a></li>
	</ul>


	<!-- Tabelas -->

	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th scope="col">ID da permissão</th>
				<th scope="col">Nome da permissão</th>

			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Id</td>
				<td>Nome</td>
				<td><a class="btn btn-info" href="./cadastrar.html">Inserir</a></td>
				<td><a class="btn btn-success" href="./atualizar.html">Atualizar</a></td>
				<td><a class="btn btn-warning" href="./visualizar.html">Visualizar</a></td>
				<td><a class="btn btn-danger" href="./deletar.html">Deletar</a></td>
			</tr>
		</tbody>
	</table>



	<!-- CDN JS Bootstrap v-5.1 -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>