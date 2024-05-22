<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Task</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-size: cover;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #f0f2f5;
        }
        form {
            background: #fff;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 600px;
            box-sizing: border-box;
        }
        form div {
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
            color: #333;
        }
        input[type="text"],
        input[type="date"],
        input[type="number"],
        textarea,
        select {
            width: 100%;
            padding: 12px;
            margin-top: 5px;
            border: 1px solid #ccd1d9;
            border-radius: 5px;
            font-size: 16px;
            box-sizing: border-box;
            transition: border-color 0.3s;
        }
        input[type="text"]:focus,
        input[type="date"]:focus,
        input[type="number"]:focus,
        textarea:focus,
        select:focus {
            border-color: #007bff;
            outline: none;
        }
        textarea {
            height: 150px;
        }
        button {
            width: 100%;
            padding: 15px;
            background: #007bff;
            border: none;
            border-radius: 5px;
            color: white;
            font-size: 18px;
            cursor: pointer;
            transition: background 0.3s;
        }
        button:hover {
            background: #0056b3;
        }
    </style>
</head>
<body>
<form action="editTache" method="post">
    <div>
        <input type="hidden" id="tache_Id" name="tache_Id" value="${tache.getTache_Id()}">
    </div>
    <div>
        <label for="tache_Description">Task Description</label>
        <textarea id="tache_Description" name="tache_Description" required>${tache.tache_Description}</textarea>
    </div>
    <div>
        <label for="name_tache">Task Name</label>
        <input type="text" id="name_tache" name="name_tache" value="${tache.name_tache}" required>
    </div>
    <div>
        <label for="startDate">Start Date</label>
        <input type="date" id="startDate" name="startDate" value="${tache.startDate}" required>
    </div>
    <div>
        <label for="endDate">End Date</label>
        <input type="date" id="endDate" name="endDate" value="${tache.endDate}" required>
    </div>
    <div>
        <label for="status">Status</label>
        <select name="status" id="status" required>
            <option value="To do" ${tache.status == 'To do' ? 'selected' : ''}>To do</option>
            <option value="in progress" ${tache.status == 'in progress' ? 'selected' : ''}>In progress</option>
            <option value="Finish" ${tache.status == 'Finish' ? 'selected' : ''}>Finish</option>
        </select>
    </div>
    <div>
        <label for="projet_Id">Project ID</label>
        <input type="number" id="projet_Id" name="projet_Id" value="${tache.getProjet_Id()}" readonly required>
    </div>
    <button type="submit">Edit Task</button>
</form>
</body>
</html>
