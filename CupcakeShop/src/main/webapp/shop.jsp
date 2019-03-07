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
                    <a href="Controller?origin=shop"><img src="IMG/logo.png" alt=""/></a>
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
                                <option value="Choose a bottom" disabled>Choose a bottom</option>

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
        </main>
    </body>
</html>