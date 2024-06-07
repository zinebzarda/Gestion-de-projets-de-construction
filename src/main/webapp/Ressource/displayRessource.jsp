<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 22/05/2024
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Affichage des Ressources</title>
    <link rel="stylesheet" href="styles.css">
    <style>
        body {
            margin: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f0f0f0;
            display: flex;
            min-height: 100vh;
        }

        .container {
            flex: 1;
            display: flex;
            padding: 20px;
            box-sizing: border-box;
        }

        .sidebar {
            background: #9fa500;
            color: #ffffff;
            width: 200px;
            padding: 20px;
            position: fixed;
            height: 100%;
            overflow-y: auto;
        }

        .profile h2 {
            margin: 0 0 10px;
            font-size: 22px;
            color: #ffffff;
        }

        nav ul {
            list-style: none;
            padding: 0;
        }

        nav ul li {
            margin-bottom: 15px;
        }

        nav ul li a {
            color: #ffffff;
            text-decoration: none;
            display: block;
            padding: 10px 15px;
            border-radius: 5px;
            transition: background 0.3s;
        }

        nav ul li a:hover {
            background: #73bc1a;
        }

        nav ul li.active a {
            background: #8ea016;
        }

        .table-container {
            flex: 1;
            margin-left: 240px;
            padding: 20px;
            box-sizing: border-box;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
        }

        thead {
            background-color: #9fa500;
            color: #ffffff;
        }

        thead th {
            padding: 15px;
            text-align: left;
            font-weight: normal;
        }

        tbody tr {
            border-bottom: 1px solid #ddd;
        }

        tbody tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tbody td {
            padding: 15px;
            color: #333333;
        }

        tbody tr:hover {
            background-color: #f1f1f1;
        }

        .btn {
            background-color: #007bff;
            color: white;
            border: none;
            padding: 10px 20px;
            margin-right: 5px;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .btn:hover {
            background-color: #0056b3;
        }

        .btn-outline-primary {
            background-color: transparent;
            border: 2px solid #007bff;
            color: #007bff;
        }

        .btn-outline-primary:hover {
            background-color: #007bff;
            color: #ffffff;
        }

        .btn-outline-danger {
            background-color: transparent;
            border: 2px solid #dc3545;
            color: #dc3545;
        }

        .btn-outline-danger:hover {
            background-color: #dc3545;
            color: #ffffff;
        }
        .btn-outline {
            background-color: transparent;
            border: 2px solid #73bc1a;
            color: #9fa500;
        }

        .btn-outline:hover {
            background-color: #73bc1a;
            color: #ffffff;
        }

        .modal {
            display: none;
            position: fixed;
            z-index: 1;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: rgba(0, 0, 0, 0.5);
            justify-content: center;
            align-items: center;
        }
        .modal-content {
            background-color: #fefefe;
            margin: auto;
            padding: 30px;
            border: 1px solid #888;
            width: 80%;
            max-width: 500px;
            border-radius: 10px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
            position: relative;
        }
        .close-button {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
            cursor: pointer;
        }
        .close-button:hover,
        .close-button:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
        }
        form {
            background: rgba(255, 255, 255, 0.9);
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
            width: 100%;
            box-sizing: border-box;
        }
        form div {
            margin-bottom: 20px;
            position: relative;
        }
        label {
            position: absolute;
            top: -12px;
            left: 15px;
            background: rgba(255, 255, 255, 0.9);
            padding: 0 5px;
            font-size: 14px;
            color: #333;
            transition: all 0.3s;
        }
        input[type="text"],
        input[type="date"],
        input[type="number"],
        textarea,
        select {
            width: calc(100% - 30px);
            padding: 12px 15px;
            margin: 5px 0;
            border: 1px solid #ccd1d9;
            border-radius: 5px;
            font-size: 16px;
            transition: border-color 0.3s, box-shadow 0.3s;
        }
        input[type="text"]:focus,
        input[type="date"]:focus,
        input[type="number"]:focus,
        textarea:focus,
        select:focus {
            border-color: #007bff;
            box-shadow: 0 0 8px rgba(0, 123, 255, 0.2);
        }
        button {
            width: 100%;
            padding: 15px;
            background: #007bff;
            border: none;
            border-radius: 5px;
            color: white;
            font-size: 16px;
            cursor: pointer;
            transition: background 0.3s, box-shadow 0.3s;
        }
        button:hover {
            background: #0056b3;
        }
.profile img{
    width: 100px;
    height: 100px;
    padding: 51px;
}
    </style>
</head>

<body>
<div class="container">
    <aside class="sidebar">
        <div class="profile">
            <img src="https://i.ibb.co/Zhs5kNZ/Capture-d-cran-2024-05-24-170551-removebg-preview.png">
        </div>
        <nav>
            <ul>
                <li class="active"><a href="index.html">Home</a></li>
                <li><a href="showP">Discover</a></li>
                <li><a href="#" onclick="openForm('modalFormTask')">Add Ressource</a></li>
                <li><a href="#">Log Out</a></li>
            </ul>
        </nav>
    </aside>

    <div class="table-container">
        <table>
            <thead>
            <tr>
                <th>Nom de la Ressource</th>
                <th>Type de Ressource</th>
                <th>Quantité</th>
                <th>Informations du Fournisseur</th>
                <th>Tache id</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${showR}" var="ressource">
                <tr>
                    <td>${ressource.ressource_name}</td>
                    <td>${ressource.type}</td>
                    <td>${ressource.quantite}</td>
                    <td>${ressource.fournisseur}</td>
                    <td>${ressource.tache_Id}</td>
                    <td>
                        <a href="editRessource?id=${ressource.getRessource_Id()}" class="btn btn-outline-primary">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
                                <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
                                <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5z"/>
                            </svg>
                        </a>
                        <a href="deleteRessource?ressource_Id=${ressource.getRessource_Id()}" class="btn btn-outline-danger">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash3" viewBox="0 0 16 16">
                                <path d="M6.5 1h3a.5.5 0 0 1 .5.5v1H6v-1a.5.5 0 0 1 .5-.5M11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3A1.5 1.5 0 0 0 5 1.5v1H1.5a.5.5 0 0 0 0 1h.538l.853 10.66A2 2 0 0 0 4.885 16h6.23a2 2 0 0 0 1.994-1.84l.853-10.66h.538a.5.5 0 0 0 0-1zm1.958 1-.846 10.58a1 1 0 0 1-.997.92h-6.23a1 1 0 0 1-.997-.92L3.042 3.5zm-7.487 1a.5.5 0 0 1 .528.47l.5 8.5a.5.5 0 0 1-.998.06L5 5.03a.5.5 0 0 1 .47-.53Zm5.058 0a.5.5 0 0 1 .47.53l-.5 8.5a.5.5 0 1 1-.998-.06l.5-8.5a.5.5 0 0 1 .528-.47M8 4.5a.5.5 0 0 1 .5.5v8.5a.5.5 0 0 1-1 0V5a.5.5 0 0 1 .5-.5"/>
                            </svg>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<!--    add Ressource -->
<div id="modalFormTask" class="modal">
    <div class="modal-content">
<span class="close-button" onclick="closeForm('modalFormTask')">&times;</span>
<form action="addRessource" method="post">
    <div>
        <input type="text"  id="ressource_name" name="ressource_name">
        <label for="ressource_name"> Nom de ressource </label>
    </div>
    <div>
        <input type="text"  id="type" name="type">
        <label for="type"> type </label>
    </div>
    <div>
        <input type="number"  id="quantite" name="quantite">
        <label for="quantite"> Quantite </label>
    </div>
    <div>
        <input type="text"  id="fournisseur" name="fournisseur">
        <label for="fournisseur"> Fournisseur</label>
    </div>

    <div class="form-group">
        <label for="tache_Id">Projet ID</label>
        <select class="form-control" id="tache_Id" name="tache_Id" required>
            <c:forEach var="tache" items="${showT}">tache_Id
                <option value="${tache.getTache_Id()}">${tache.getName_tache()} (ID: ${tache.getTache_Id()})</option>
            </c:forEach>
        </select>
    </div>
    <button type="submit">Add Projet</button>
</form>
    </div>
</div>

<script>
    function openForm(formId) {
        document.getElementById(formId).style.display = "flex";
    }

    function closeForm(formId) {
        document.getElementById(formId).style.display = "none";
    }
</script>

</body>
</html>
