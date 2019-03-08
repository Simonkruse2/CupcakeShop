<%@page import="Data.CakeBottom"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Logic.DataAccessObject_Impl"%>
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
        <header class="container-fluid">
            <nav class="col-md-6 col-md-offset-3 shopnav">
                <ul>
                    <a href="Controller?origin=shop"><img src="IMG/Crown Bakery.png" alt=""/></a>
                    <li style="float:right"><a href="Controller?origin=Invoice"><button>Invoice</button></a></li>
                    <li style="float:right"><p>Who is logged in</p></li>
                    <li style="float:right"><p>Show balance</p></li>
                </ul>
            </nav>
        </header>
        <main class="col-md-6 col-md-offset-3 forside">
            <h1>Shop</h1>
            <section class="row col-md-12 forsec">
                <table class="col-md-12 fortab">
                    <tr>
                        <th>
                            Bottom 
                        </th>
                        <th>
                            Topping
                        </th>
                        <th>
                            Quantity
                        </th>
                        <th>
                            Select
                        </th>
                    </tr>
                    <tr>
                        <td>
                            <select class="mdb-select md-form selection java.util.ArrayList" id="bottom" name="bottom">
                                <option  value = "Choose a bottom" disabled > Choose a bottom</option >
                                <% HttpSession session1 = request.getSession();
                                    ArrayList<CakeBottom> listBottom = (ArrayList<CakeBottom>) session1.getAttribute("listBottom");
                                    for (Object bottom : listBottom) {
                                        int i = 1;
                                %>
                                <option value="<% out.print(i); %>"> <% out.print(bottom); %> </option >
                                <% i++;
                                    }%>
                            </select>
                        </td>
                        <td>
                            <select class="mdb-select md-form selection" name="topping">
                                <option value="">Choose topping</option>
                                <option value="1">Chocolate: 5.0</option>
                                <option value="2">Vanilla: 5.0</option>
                                <option value="3">Nutmeg: 5.0</option>
                                <option value="4">Pistacio: 6.0</option>
                                <option value="5">Almond: 7.0</option>
                            </select>
                        </td> 
                        <td>
                            <input type="text" placeholder="indtast antal">
                        </td>
                        <td>
                            <button class="col-md-8 col-md-offset-2" type="button" value="Select">Select</button>
                        </td>
                    </tr>
                </table>
                <table class="col-md-12 fortab">
                    <tr>
                        <th>
                            Bottom 
                        </th>
                        <th>
                            Topping
                        </th>
                        <th>
                            Price
                        </th>
                        <th>
                            Total
                        </th>
                        <th>
                            Remove
                        </th>
                    </tr>
                    <tr>
                        <td>
                            Chocolate
                        </td>
                        <td>
                            Strawberry
                        </td> 
                        <td>
                            5
                        </td>
                        <td>
                            5
                        </td>
                        <td>
                            <button class="col-md-8 col-md-offset-2" type="button" value="Select">Add to cart</button>
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