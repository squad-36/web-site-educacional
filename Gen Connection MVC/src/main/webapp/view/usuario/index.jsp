<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.Usuario" import="java.util.List"%>

<%
@SuppressWarnings("unchecked")
List<Usuario> lista = (List<Usuario>) request.getAttribute("usuario");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Usuario</title>

<!-- CDN CSS Bootstrap v-5.1 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>

	<header class="container-fluid bg-primary p-4 text-light">
		<h1>Usuarios</h1>
	</header>

	<!-- Menu -->
	<ul class="nav justify-content-center">
		<li class="nav-item"><a class="nav-link active text-dark fs-4"
			aria-current="page" href="./index.html">Home</a></li>
		<li class="nav-item"><a class="nav-link active text-dark fs-4"
			href="../permissoes/index.jsp">Permissões</a></li>
		<li class="nav-item"><a class="nav-link text-dark fs-4"
			href="./usuario">Usuarios</a></li>
		<li class="nav-item"><a class="nav-link text-dark fs-4"
			href="../atividades/index.jsp">Atividades</a></li>
		<li class="nav-item"><a class="nav-link text-dark fs-4"
			href="../jogos/index.jsp">Jogos</a></li>
		<li class="nav-item"><a class="nav-link text-dark fs-4"
			href="../notificacoes/index.jsp">Notificações</a></li>
	</ul>

	<header class="container my-4">
		<div class="row">
			<div class="col">
				<a class="btn btn-info" href="./view/usuario/cadastrar.html">Cadastrar
					Usuario</a>

			</div>

		</div>
	</header>



	<!-- Tabelas -->

	<table class="table container">
		<thead class="thead-dark">
			<tr>
				<th scope="col">ID do Usuario</th>
				<th scope="col">Nome do Usuario</th>
				<th scope="col">Email do Usuario</th>
				<th scope="col">Senha do Usuario</th>
				<th scope="col">Imagem do Usuario</th>

			</tr>
		</thead>
		<tbody>

			<%
			for (Usuario a : lista) {
			%>
			<tr>


				<td><%=a.getId_usuario()%></td>
				<td><%=a.getNome()%></td>
				<td><%=a.getEmail()%></td>
				<td><%=a.getSenha()%></td>
				<td><%=a.getImagem()%></td>

				<td><a class="btn btn-success"
					href="editar-usuario?id=<%=a.getId_usuario()%>">Atualizar
						Usuario</a> <a class="btn btn-danger"
					href="deletar-usuario?id=<%=a.getId_usuario()%>">Deletar
						Usuario</a></td>

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