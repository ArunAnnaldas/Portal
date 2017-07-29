<%-- 
    Document   : home
    Created on : Jul 16, 2017, 11:27:27 PM
    Author     : aannaldas
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@page import="com.TIAA.login"%>
<%@page import="com.TIAA.welcome"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>TIAA Portal</title>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <!-- Custom CSS -->
        <link href="css/simple-sidebar.css" rel="stylesheet">

    </head>

    <body>

        <div id="wrapper">

            <!-- Sidebar -->
            <div id="sidebar-wrapper">
                <ul class="sidebar-nav">
                    <li class="sidebar-brand">
                        <a href="#">Nav Links</a>
                    </li>
                    <li>
                        <a href="#">Dashboard</a>
                    </li>
                    <li>
                        <a href="#">Shortcuts</a>
                    </li>
                    <li>
                        <a href="#">Overview</a>
                    </li>
                    <li>
                        <a href="#">Events</a>
                    </li>
                    <li>
                        <a href="#">About</a>
                    </li>
                    <li>
                        <a href="#">Services</a>
                    </li>
                    <li>
                        <a href="#">Contact</a>
                    </li>
                </ul>
            </div>
            <!-- /#sidebar-wrapper -->


            <!-- Page Content -->
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <form name="getdata" action="/Portal/login" method="post">
                            <h1 class="page-header">
                                TIAA Images 

                                <c:set var="username" value="${sessionScope.username}"/>

                                <%
                                    try {
                                        if (!pageContext.getAttribute("username").equals("")) {%>
                                            <c:if test="${requestScope.isManager}">
                                          <%  out.print("<form action='logout'>"
                                                    + " <button name='logout' class='btn btn-primary btn-sm pull-right'>"
                                                    + "Logout"
                                                    + " </button>"
                                                    + "</form>");%>
                                            </c:if>
                                      <%  }
                                    }
                                    catch(Exception e)
                                    {
                                           out.print("<button type='submit' name='login' class='btn btn-primary btn-sm pull-right'>Login</button>");
                                    }
                                %>





                                <!--                                <button type="submit" class="btn btn-primary btn-sm pull-right">
                                                                    Login
                                                                </button>-->
                            </h1>

                        </form>

                    </div>

                    <div class="col-lg-3 col-md-4 col-xs-6 thumb">
                        <a class="thumbnail" href="#">
                            <img class="img-responsive" src="http://placehold.it/400x300" alt="">
                        </a>
                    </div>
                    <div class="col-lg-3 col-md-4 col-xs-6 thumb">
                        <a class="thumbnail" href="#">
                            <img class="img-responsive" src="http://placehold.it/400x300" alt="">
                        </a>
                    </div>

                </div>

                <hr>

                <!-- Footer -->
                <footer>
                    <div class="row">
                        <div class="col-lg-12">
                            <p>Copyright &copy; www.tiaa.org 2017</p>
                        </div>
                    </div>
                </footer>

            </div>
            <!-- /#page-content-wrapper -->

        </div>
        <!-- /#wrapper -->


    </body>
</html>