<%-- 
    Document   : Invoice
    Created on : 06-Mar-2019, 12:53:22
    Author     : Renz
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
<link href="Styling.css" rel="stylesheet" type="text/css"/>
<link href="https://fonts.googleapis.com/css?family=Karla" rel="stylesheet"> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body> 
        <header class="container-fluid">
            <nav class="col-md-6 col-md-offset-3 shopnav">
                <ul>
                    <a href="Controller?origin=shop"><img src="IMG/Crown Bakery.png" alt=""/></a>
                    <li style="float:right"><a href=""><button>Invoice - show only if admin</button></a></li>
                </ul>
            </nav>
        </header>
        <main class="col-md-6 col-md-offset-3 forside">
            <h1>Customer page</h1>
            <section class="row col-md-12 forsec">
                <table class="col-md-12 fortab">
                    <tr>
                        <th>
                            Customer ID 
                        </th>
                        <th>
                            Invoice nr. 
                        </th>
                        <th>
                            Status
                        </th>
                        <th>
                            Date
                        </th>
                        <th>
                            Info
                        </th>
                    </tr>
                    <tr>
                        <td>
                            1
                        </td>
                        <td>
                            1
                        </td> 
                        <td>
                            Not paid
                        </td>
                        <td>
                            05-03-2019
                        </td>
                        <td>
                            <button class="col-md-8 col-md-offset-2" type="button" value="Select">Info</button>
                        </td>
                    </tr>
                </table>

                <table class="col-md-8 col-md-offset-2 fortab">
                    <tr>
                        <th>
                            INVOICE NR
                        </th>
                        <th>
                            DATE & TIME
                        </th>
                        <th>
                            CUSTOMER ID 

                        </th>
                        <th>
                            Recipe
                        </th>
                        <th>
                            TOTAL COST
                        </th>

                    </tr>
                    <tr>
                        <td>
                            1
                        </td>
                        <td>
                            19:54:00 / 05-03-2019
                        </td> 
                        <td>
                            1
                        </td>
                        <td>
                            lorem ipsum
                        </td>
                        <td>
                            30
                        </td>
                    </tr>
                </table>
            </section>
                        <footer class="footer">
                <h1>Contacts</h1>
                <table class="col-md-5">
                    <tr>
                        <td>
                            <p><img src="IMG/placeholder.png" alt=""/></p>
                        </td>
                        <td>
                            <p>Nørgaardsvej 30, <b>2800 Kongens Lyngby</b></p>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <p><img src="IMG/mobile-phone.png" alt=""/></p>
                        </td>
                        <td>
                            <p><b>+45 36 15 45 04</b></p>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <p><img src="IMG/email.png" alt=""/></p>
                        </td>
                        <td>
                            <p><a href="mailto:Group_5@example.com?Subject=Hello%20again" target="_top">Send Mail</a></p>
                        </td>
                    </tr>
                </table>
                <table class="col-md-5 col-md-offset-2">
                    <tr>
                        <td>
                            <p><b>ABOUT THE COMPANY</b></p>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <p>Lorem Ipsum er ganske enkelt fyldtekst fra print-
                                og typografiindustrien. Lorem Ipsum har været standard 
                                fyld</p>

                        </td>
                    </tr>
                    <tr>
                        <td>
                            <p>
                                <img src="IMG/placeholder.png" alt=""/>
                                <img src="IMG/placeholder.png" alt=""/>
                                <img src="IMG/placeholder.png" alt=""/>
                                <img src="IMG/placeholder.png" alt=""/>
                            </p>
                        </td>
                    </tr>
                </table>
            </footer>
        </main>
    </body>
</html>