<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
<link href="styling.css" rel="stylesheet" type="text/css"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body> 
        <header class="container-fluid">
            <nav class="col-md-6 col-md-offset-3 shopnav">
                <ul>
                    <a href><img src="logo.png" alt=""/></a>
                    <li style="float:right"><a href=""><button>Invoice</button></a></li>
                    <li style="float:right"><p>Who is logged in</p></li>
                    <li style="float:right"><p>Show balance</p></li>
                </ul>
            </nav>
        </header>
        <main class="col-md-6 col-md-offset-3 forside">
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
                            <select class="mdb-select md-form" name="bottom " id="bottomSelect">
                                <option value="">Choose bottom</option>
                                <option value="1">Chocolate: 5.0</option>
                                <option value="2">Blueberry: 5.0</option>
                                <option value="3">Raspberry: 5.0</option>
                                <option value="4">Crispy: 6.0</option>
                                <option value="5">Strawberry: 6.0</option>
                                <option value="6">Rum/Raisin: 7.0</option>
                                <option value="7">Orange: 8.0</option>
                                <option value="8">Lemon: 8.0</option>
                                <option value="9">Blue cheese: 9.0</option>
                            </select>
                        </td>
                        <td>
                            <select class="mdb-select md-form" name="topping" id="toppingSelect">
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