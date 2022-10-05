<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.Jogos" import="java.util.List"%>

<%
@SuppressWarnings("unchecked")
List<Jogos> lista = (List<Jogos>) request.getAttribute("jogos");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jogos</title>

<link rel="stylesheet" href="./css/style.css">

<!-- CDN CSS Bootstrap v-5.1 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>



	<!-- Inicio Menu Nav -->
	<header class="container-fluid bg-primary p-4 text-light">
		<h1>Jogos</h1>
	</header>
	
	

<nav class="navbar navbar-dark bg-dark">
  <ul class="nav justify-content-center">
		<li class="nav-item">
			<a class="nav-link active text-light fs-4" aria-current="page" href="./index.html">Home</a>
		</li>
		<li class="nav-item">
			<a class="nav-link active text-light fs-4" href="./permissao">Permissões</a>
		</li>
		<li class="nav-item">
			<a class="nav-link text-light fs-4" href="./usuario">Usuarios</a>
		</li>
		<li class="nav-item">
			<a class="nav-link text-light fs-4" href="./atividades">Atividades</a>
		</li>
		<li class="nav-item">
			<a class="nav-link text-light fs-4" href="./jogos">Jogos</a>
		</li>
		<li class="nav-item">
			<a class="nav-link text-light fs-4" href="./notificacao">Notificações</a>
		</li>
	</ul>
</nav>

	<!-- final Menu Nav -->

	<header class="container my-4">
		<div class="row">
			<div class="col">
				<a class="btn btn-info" href="./view/jogos/cadastrar.html">Cadastrar
					Jogos</a>

			</div>

		</div>
	</header>



	<!-- Tabelas -->

	<table class="table container">
		<thead class="thead-dark">
			<tr>
				<th scope="col">ID do Jogo</th>
				<th scope="col">Nome do Jogo</th>
				<th scope="col">Pontos</th>

			</tr>
		</thead>
		<tbody>


			
			<% for (Jogos j : lista) { %>
			

			<tr>


				<td><%=j.getId_jogos()%></td>
				<td><%=j.getnome_jogos()%></td>
				<td><%=j.getPontos()%></td>

				<td><a class="btn btn-success"
					href="editar-jogos?id=<%=j.getId_jogos()%>">Atualizar
						Jogos</a> <a class="btn btn-danger"
					href="deletar-jogos?id=<%=j.getId_jogos()%>">Deletar
						Jogos</a></td>
						
			<% }; %>
				
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