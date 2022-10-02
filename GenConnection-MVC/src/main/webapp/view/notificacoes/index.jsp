<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="model.Notificacao"
	import="java.util.List" %>

	<% @SuppressWarnings("unchecked") List<Notificacao> lista = (List<Notificacao>) request.getAttribute("notificacao");
			%>

			<!DOCTYPE html>
			<html>

			<head>
				<meta charset="UTF-8">
				<title>Notificações</title>

				<!-- CDN CSS Bootstrap v-5.1 -->
				<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
					integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
					crossorigin="anonymous">
			</head>

			<body>

				<header class="container-fluid bg-primary p-4 text-light">
					<h1>Notificações</h1>
				</header>

				<!-- Menu -->
				<ul class="nav justify-content-center">
					<li class="nav-item">
						<a class="nav-link active text-dark fs-4" aria-current="page" href="../../index.html">Home</a>
					</li>
					<li class="nav-item">
						<a class="nav-link active text-dark fs-4" href="../permissoes/index.jsp">Permissões</a>
					</li>
					<li class="nav-item">
						<a class="nav-link text-dark fs-4" href="../usuario/index.jsp">Usuarios</a>
					</li>
					<li class="nav-item">
						<a class="nav-link text-dark fs-4" href="../atividades/index.jsp">Atividades</a>
					</li>
					<li class="nav-item">
						<a class="nav-link text-dark fs-4" href="../jogos/index.jsp">Jogos</a>
					</li>
					<li class="nav-item">
						<a class="nav-link text-dark fs-4" href="./index.jsp">Notificações</a>
					</li>
				</ul>

				<!-- Tabelas -->
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">#</th>
							<th scope="col">Tipo</th>
							<th scope="col">mensagem</th>
						</tr>
					</thead>
					<tbody>

						<% for (Notificacao n : lista) { %>
							<tr>

								<td>
									<%=n.getId_notificacao()%>
								</td>
								<td>
									<%=n.getnome_notificacao()%>
								</td>
								<td>
									<%=n.getMensagem()%>
								</td>
								<td>
									<a class="btn btn-success"
										href="editar-notificacao?id=<%=n.getId_notificacao()%>">Atualizar Usuario</a>
									<a class="btn btn-danger"
										href="deletar-notificacao?id=<%=n.getId_notificacao()%>">Deletar Usuario</a>
								</td>

								<% } %>
					</tbody>
				</table>

				<!-- CDN JS Bootstrap v-5.1 -->
				<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
					integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
					crossorigin="anonymous"></script>
			</body>

			</html>