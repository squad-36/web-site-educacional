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
<title>Permissao</title>

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
		<h1>Permissoes</h1>
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
				<a class="btn btn-info" href="./view/permissao/cadastrar.html">Cadastrar
					Permissao</a>

			</div>

		</div>
	</header>



	<!-- Tabelas -->

	<table class="table container">
		<thead class="thead-dark">
			<tr>
				<th scope="col">ID da Permissao</th>
				<th scope="col">Nome da Permissao</th>

			</tr>
		</thead>
		<tbody>



			<%
			for (Permissao p : lista) {
			%>


			<tr>


				<td><%=p.getId_permissao()%></td>
				<td><%=p.getnome_permissao()%></td>

				<td><a class="btn btn-success"
					href="editar-permissao?id=<%=p.getId_permissao()%>">Atualizar
						Permissao</a> <a class="btn btn-danger"
					href="deletar-permissao?id=<%=p.getId_permissao()%>">Deletar
						Permissao</a></td>

				<%
				}
				;
				%>

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