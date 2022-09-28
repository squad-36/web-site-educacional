<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.Notificacao" import="java.util.List"%>

<%
@SuppressWarnings("unchecked")
List<Notificacao> lista = (List<Notificacao>) request.getAttribute("notificacao");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Notificacao</title>

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
	<section class="container-fluid bg-nav-container py-2">
		<header class="container">
			<nav class="navbar-nav navbar-dark">
				<div class="row">
					<div class="col">
						<h1 class="navbar-brand title-logo">Notificacoes</h1>
					</div>
				</div>
				<div class="row">
					<div class="col">
						<ul class="list-group list-group-horizontal  ajust-nav-sm">

							<li class="list-group-item"><a class="link"
								href="./index.html">Home</a></li>
							<li class="list-group-item"><a class="link"
								href="./permissao">Permissoes</a></li>
							<li class="list-group-item"><a class="link" href="./usuario">Usuarios</a>
							</li>
							<li class="list-group-item"><a class="link"
								href="./atividades">Atividades</a></li>
							<li class="list-group-item"><a class="link" href="./jogos">Jogos</a>
							</li>
							<li class="list-group-item"><a class="link"
								href="./notificacao">Notificacoes</a></li>
						</ul>
					</div>
				</div>
			</nav>
		</header>
	</section>
	<!-- final Menu Nav -->

	<header class="container-fluid bg-danger p-2">
		<h1 class="h3">Notificacoes</h1>
	</header>

	<header class="container my-4">
		<div class="row">
			<div class="col">
				<a class="btn btn-info" href="./view/notificacao/cadastrar.html">Cadastrar
					Notificacoes</a>

			</div>

		</div>
	</header>



	<!-- Tabelas -->

	<table class="table container">
		<thead class="thead-dark">
			<tr>
				<th scope="col">ID da Notificacao</th>
				<th scope="col">Nome da Notificacao</th>
				<th scope="col">Mensagem</th>

			</tr>
		</thead>
		<tbody>


			
			<% for (Notificacao n : lista) { %>
			

			<tr>


				<td><%=n.getId_notificacao()%></td>
				<td><%=n.getnome_notificacao()%></td>
				<td><%=n.getMensagem()%></td>

				<td><a class="btn btn-success"
					href="editar-notificacao?id=<%=n.getId_notificacao()%>">Atualizar
						Notificacoes</a> <a class="btn btn-danger"
					href="deletar-notificacao?id=<%=n.getId_notificacao()%>">Deletar
						Notificacoes</a></td>
						
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