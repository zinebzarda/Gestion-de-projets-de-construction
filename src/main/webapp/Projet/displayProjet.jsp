<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Real Estate Dashboard</title>
    <link rel="stylesheet" href="style.css">

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
            width: 267px;
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
        .card-body img {
            width: 100%;
            height: 150px;
            object-fit: cover;
        }
        .card-body p {
            margin: 10px 0;
            color: #333;
            line-height: 1.6;
        }
        .card-footer {
            text-align: right;
        }
        .card-footer .btn {
            display: inline-block;
            margin-left: 5px;
            text-decoration: none;
            padding: 8px 15px;
            border-radius: 5px;
            font-size: 14px;
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
        .btn-outline-success {
            color: #28a745;
            border: 1px solid #28a745;
        }
        .btn-outline-success:hover {
            background-color: #28a745;
            color: white;
        }
        i {
            margin-right: 5px;
        }
    </style>
</head>
<body>
<div class="container">
    <aside class="sidebar">
        <div class="profile">
            <img src="profile.jpg" alt="Indica Watson">
            <h2>Indica Watson</h2>
            <p>Real Estate Builders</p>
        </div>
        <nav class="menu">
            <ul>
                <li><a href="#">Dashboard</a></li>
                <li><a href="#">Discover</a></li>
                <li><a href="#">Inbox <span class="badge">3</span></a></li>
                <li><a href="#">My Wallet</a></li>
                <li><a href="#">Analytics</a></li>
                <li><a href="#">Notifications <span class="badge">5</span></a></li>
                <li><a href="#">Settings</a></li>
            </ul>
        </nav>
        <div class="support">
            <a href="#">Help & Support</a>
            <a href="#">Log Out</a>
        </div>
    </aside>
    <main class="main-content">
        <header class="header">
            <nav class="top-nav">
                <ul>
                    <li><a href="#">Buy</a></li>
                    <li><a href="#">Sell</a></li>
                    <li><a href="#">Rent</a></li>
                    <li><a href="#">Compare</a></li>
                </ul>
            </nav>
            <div class="search-filters">
                <input type="text" placeholder="Search Here...">
                <select>
                    <option>$$</option>
                </select>
                <select>
                    <option>2-4 Beds</option>
                </select>
                <select>
                    <option>Property Type</option>
                </select>
                <button>Filters</button>
            </div>
        </header>
        <section class="property-list">

            <c:forEach items="${showP}" var="projet">
                <div class="card">

                    <div class="card-body">
                        <img src="https://img.freepik.com/psd-gratuit/constructeur-porte-poutre-acier-son-epaule-generative-ai_587448-1880.jpg" alt="">
                        <div class="card-header">
                                ${projet.projet_Name}
                        </div>
                        <p style="overflow: hidden" ><strong>Description:</strong> ${projet.projet_Description}</p>
                        <p><strong>Start Date:</strong> ${projet.startDate}</p>
                        <p><strong>End Date:</strong> ${projet.endDate}</p>
                        <p><strong>Budget:</strong> ${projet.budget}</p>
                    </div>
                    <div class="card-footer">
                        <a href="showT?projet_Id=${projet.getProjet_Id()}" class="btn btn-outline-success">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eye" viewBox="0 0 16 16">
                                <path d="M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8M1.173 8a13 13 0 0 1 1.66-2.043C4.12 4.668 5.88 3.5 8 3.5s3.879 1.168 5.168 2.457A13 13 0 0 1 14.828 8q-.086.13-.195.288c-.335.48-.83 1.12-1.465 1.755C11.879 11.332 10.119 12.5 8 12.5s-3.879-1.168-5.168-2.457A13 13 0 0 1 1.172 8z"/>
                                <path d="M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5M4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0"/>
                            </svg>
                        </a>
                        <a href="editProjet?id=${projet.getProjet_Id()}" class="btn btn-outline-primary">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
                                <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
                                <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5z"/>
                            </svg>
                        </a>
                        <a href="deleteProjet?projet_Id=${projet.getProjet_Id()}" class="btn btn-outline-danger">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash3" viewBox="0 0 16 16">
                                <path d="M6.5 1h3a.5.5 0 0 1 .5.5v1H6v-1a.5.5 0 0 1 .5-.5M11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3A1.5 1.5 0 0 0 5 1.5v1H1.5a.5.5 0 0 0 0 1h.538l.853 10.66A2 2 0 0 0 4.885 16h6.23a2 2 0 0 0 1.994-1.84l.853-10.66h.538a.5.5 0 0 0 0-1zm1.958 1-.846 10.58a1 1 0 0 1-.997.92h-6.23a1 1 0 0 1-.997-.92L3.042 3.5zm-7.487 1a.5.5 0 0 1 .528.47l.5 8.5a.5.5 0 0 1-.998.06L5 5.03a.5.5 0 0 1 .47-.53Zm5.058 0a.5.5 0 0 1 .47.53l-.5 8.5a.5.5 0 1 1-.998-.06l.5-8.5a.5.5 0 0 1 .528-.47M8 4.5a.5.5 0 0 1 .5.5v8.5a.5.5 0 0 1-1 0V5a.5.5 0 0 1 .5-.5"/>
                            </svg>
                        </a>
                    </div>
                </div>
            </c:forEach>
        </section>
        <section class="right-sidebar">
            <section class="messages">
                <h2>Recent Messages</h2>
                <ul>
                    <li><img src="user1.jpg" alt="James Benny"> <p>Hey, Let me know if you’re still available...</p></li>
                    <li><img src="user2.jpg" alt="William Chynita"> <p>Okay thanks</p></li>
                    <li><img src="user3.jpg" alt="Henry David"> <p>Alright I’ll get back to you ASAP</p></li>
                    <li><img src="user4.jpg" alt="Charlotte Flair"> <p>Sounds good buddy</p></li>
                </ul>
            </section>
        </section>
    </main>
</div>
</body>
</html>
