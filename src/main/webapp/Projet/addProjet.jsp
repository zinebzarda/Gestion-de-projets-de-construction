<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 20/05/2024
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: url('https://img.freepik.com/psd-gratuit/constructeur-porte-poutre-acier-son-epaule-generative-ai_587448-1880.jpg')  no-repeat top right/cover;
            background-size: cover;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        form {
            background: rgba(255, 255, 255, 0.3);
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            width: 550px;
        }
        form div {
            margin-bottom: 20px;
            position: relative;
        }
        label {
            position: absolute;
            top: -12px;
            left: 15px;
            background: rgba(255, 255, 255, 0.9); /* Match form background */
            padding: 0 5px;
            font-size: 14px;
            color: #333;
        }
        input[type="text"],
        input[type="date"],
        input[type="number"],
        textarea {
            width: calc(100% - 30px);
            padding: 12px 15px;
            margin: 5px 0;
            border: 1px solid #ccd1d9;
            border-radius: 5px;
            font-size: 16px;
            transition: border-color 0.3s;
        }
        input[type="text"]:focus,
        input[type="date"]:focus,
        input[type="number"]:focus,
        textarea:focus {
            border-color: #007bff;
        }
        button {
            width: 100%;
            padding: 12px;
            background: #007bff;
            border: none;
            border-radius: 5px;
            color: white;
            font-size: 16px;
            cursor: pointer;
            transition: background 0.3s;
        }
        button:hover {
            background: #0056b3;
        }
    </style>
</head>
<body>
<form action="addProjet" method="post">
    <div>
        <input type="text" class="" id="projet_Name" name="projet_Name">
        <label for="projet_Name"> projet Name</label>
    </div>
    <div>
        <textarea id="projet_Description" name="projet_Description" style="height: 150px;"></textarea>
        <label for="projet_Description">Projet Description</label>
    </div>
    <div>
        <input type="date"  id="startDate" name="startDate">
        <label for="startDate"> Start Date </label>
    </div>
    <div>
        <input type="date"  id="endDate" name="endDate">
        <label for="endDate"> End Date </label>
    </div>
    <div>
        <input type="number"  id="budget" name="budget">
        <label for="budget"> End Date </label>
    </div>
    <button type="submit">Add Projet</button>
</form>

</body>
</html>
