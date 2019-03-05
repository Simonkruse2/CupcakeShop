
<%-- 
    Document   : index
    Created on : 04-Mar-2019, 12:49:15
    Author     : simon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
<link href="Styling.css" rel="stylesheet" type="text/css"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body> 
         <main class="container-fluid">
             <img class="header_pic" src="IMG/Cup_!.png" alt=""/>
            <section class="row index col-md-3">
                <!-- Form -->
                <form class="text-center" style="color: #757575;">
                    <!-- Email -->
                    <div> 
                        <label>E-mail</label>
                        <input type="email" id="materialLoginFormEmail" class="form-control" placeholder="Email">

                    </div>

                    <!-- Password -->
                    <div>
                        <label>Password</label>
                        <input type="password" id="materialLoginFormPassword" class="form-control" placeholder="Password">

                    </div>

                    <!-- Sign in button -->
                    <button class="btn btn-outline-info btn-rounded btn-block my-4 waves-effect z-depth-0" type="submit">Sign in</button>

                    <!-- Register -->
                    <p>Not a member?
                        <br>
                        <a href="Controller?origin=createCustomer" >click here if you're not already a user</a>
                    </p>
                </form>
                <!-- Form -->
            </section>
        </main>
    </body>
</html>