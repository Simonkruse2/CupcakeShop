
<%-- 
    Document   : index
    Created on : 04-Mar-2019, 12:49:15
    Author     : simon
--%>

<!DOCTYPE html>
<link href="normalize.css" rel="stylesheet" type="text/css"/>
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
                <form action="Controller?origin=checkLogin" method="post" class="text-center login" style="color: #757575;">
                    <div class="col-md-12"> 
                        <input type="text" class="form-control" name="username" placeholder="Username">
                    </div>
                    <div class="col-md-12">
                        <input type="password" class="form-control" name="password" placeholder="Password">
                    </div>
                    <button class="btn btn-outline-info btn-rounded btn-block my-4 waves-effect z-depth-0" type="submit">Sign in</button>
                    <span style="color:black;">Not a member?
                        <br>
                        <a href="Controller?origin=createCustomer" >click here if you're not already a user</a>
                    </span>
                </form>
            </section>
        </main>
    </body>
</html>