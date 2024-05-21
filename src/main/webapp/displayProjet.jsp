<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 20/05/2024
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Projets</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f0f4f8;
            margin: 0;
            padding: 20px;
            display: flex;
            justify-content: center;
            flex-wrap: wrap;
        }
        .card {
            background: #fff;
            border-radius: 10px;
            box-shadow: 0 6px 12px rgba(0, 0, 0, 0.1);
            margin: 15px;
            width: 320px;
            padding: 20px;
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            transition: transform 0.3s, box-shadow 0.3s;
        }
        .card:hover {
            transform: translateY(-5px);
            box-shadow: 0 12px 24px rgba(0, 0, 0, 0.2);
        }
        .card-header {
            font-size: 22px;
            font-weight: bold;
            color: #007bff;
            margin-bottom: 15px;
        }
        .card-body {
            flex-grow: 1;
        }
        .card-body p {
            margin: 10px 0;
            color: #333;
            line-height: 1.6;
        }
        .card-footer {
            text-align: right;
        }
        a.btn {
            text-decoration: none;
            padding: 8px 15px;
            border-radius: 5px;
            font-size: 14px;
            margin-left: 5px;
            display: inline-block;
            transition: background-color 0.3s, color 0.3s;
        }
        .btn-outline-danger {
            color: #dc3545;
            border: 1px solid #dc3545;
        }
        .btn-outline-danger:hover {
            background-color: #dc3545;
            color: white;
        }
        .btn-outline-primary {
            color: #007bff;
            border: 1px solid #007bff;
        }
        .btn-outline-primary:hover {
            background-color: #007bff;
            color: white;
        }
        i {
            margin-right: 5px;
        }
    </style>
</head>
<body>

<c:forEach items="${shows}" var="projet">
    <div class="card">
        <div class="card-header">
                ${projet.projet_Name}
        </div>
        <div class="card-body">
            <p><strong>Description:</strong> ${projet.projet_Description}</p>
            <p><strong>Start Date:</strong> ${projet.startDate}</p>
            <p><strong>End Date:</strong> ${projet.endDate}</p>
            <p><strong>Budget:</strong> ${projet.budget}</p>
        </div>
        <div class="card-footer">
            <a href="deleteProjet?projet_Id=${projet.getProjet_Id()}" class="btn btn-outline-danger">
                <i class='bx bx-message-rounded-x'></i> Delete
            </a>
            <a href="editProjet?id=${projet.getProjet_Id()}" class="btn btn-outline-primary">
                <i class="fa fa-edit"></i> Edit
            </a>
        </div>
    </div>
</c:forEach>

</body>
</html>

