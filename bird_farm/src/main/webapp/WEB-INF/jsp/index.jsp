<%--<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
            integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
            integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
            crossorigin="anonymous"></script>
    <title>Add bird</title>
</head>
<body>
<div class="container-fluid">
    <h4>Add Bird</h4>
    <h5>Types birds: duck,chicken,quail,turkey</h5>
    <form action="/bird/add">
        <div class="form gp">
            <div class="col-4">
                <label for="typeBird" class="col-form-label-sm">Type:</label>
                <input type="text" class="form-control col-form-label-sm" id="typeBird" name="type"
                       placeholder="enter type">
                <label for="totalWeight" class="col-form-label-sm">Weight:</label>
                <input type="text" class="form-control col-form-label-sm" id="totalWeight" name="weight"
                       placeholder="enter weight">
                <label for="totalPrice" class="col-form-label-sm">Price per unit:</label>
                <input type="text" class="form-control col-form-label-sm" id="totalPrice" name="pricePerUnit"
                       placeholder="enter price per unit">
            </div>
        </div>
        <br>
        <input class=" btn btn-outline-primary btn-sm" type="submit" value="Add Bird">
    </form>
    <h4>Descounts:</h4>

    for 10 kg - price not change
    from 10 to 30 - price = price -5 percent per unit;
    from 30 to 50 - price = price -10 percent per unit;
    <br>

    <br>
    <c:if test="${!empty birdList}">
    <h4>All Bird</h4>
    <div class="row">
        <div class="col-6">
            <div class="table-responsive-sm">
                <table class="table table-sm table-bordered">
                    <thead>
                    <tr align="center" class="table-active">
                        <th>Type</th>
                        <th>Weight</th>
                        <th>PricePerUnit</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${birdList}" var="bird">
                        <tr align="center">
                            <td>${bird.type}</td>
                            <td>${bird.weight}</td>
                            <td>${bird.pricePerUnit}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                </c:if>
            </div>
        </div>
    </div>
</div>
<form action="/magazine/getAllBirdToShop">
    <div class="form group">
        <div class="col-4">
            <input class=" btn btn-outline-primary btn-sm" type="submit" value="Get all bird to shop">
        </div>
    </div>
</form>
</body>
</html>