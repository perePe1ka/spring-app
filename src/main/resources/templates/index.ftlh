<!DOCTYPE html>
<html lang="RU">
<link rel="stylesheet" type="text/css" href="~/static/style.css">
<head>

    <title>Сосай</title>

</head>
<body>

<h1>Локомотивное депо</h1>
<hr>

<#list locomotives as locomotive>
    <div>
        <p><b><a href="/locomotive/${locomotive.id}">${locomotive.serialNumber}</a></b><br> ${locomotive.model} ${locomotive.axFormule} ${locomotive.powerOnDiesel}</p>
    </div>
</#list>

<hr>
<h3>Добавить локомотив</h3>
<form action="/create" method="post">
    <div class="">
        <label for="serialNumber">Serial Number:</label>
        <input type="number" id="serialNumber" name="serialNumber" required>
    </div>
    <div>
        <label for="model">Model:</label>
        <input type="text" id="model" name="model" required>
    </div>
    <div>
        <label for="axFormule">Ax Formule:</label>
        <input type="text" id="axFormule" name="axFormule" required>
    </div>
    <div>
        <label for="powerOnDiesel">Power On Diesel:</label>
        <input type="number" id="powerOnDiesel" name="powerOnDiesel" required>
    </div>
    <div>
        <label for="structuralSpeed">Structural Speed:</label>
        <input type="number" id="structuralSpeed" name="structuralSpeed" required>
    </div>
    <div>
        <label for="fuelReserve">Fuel Reserve:</label>
        <input type="number" id="fuelReserve" name="fuelReserve" required>
    </div>
    <div>
        <label for="minRadius">Min Radius:</label>
        <input type="number" id="minRadius" name="minRadius" required>
    </div>
    <div>
        <label for="dimensions">Dimensions:</label>
        <input type="text" id="dimensions" name="dimensions" required>
    </div>
    <div>
        <label for="mileage">Mileage:</label>
        <input type="number" id="mileage" name="mileage" required>
    </div>
    <div>
        <label for="tankVolume">Tank Volume:</label>
        <input type="number" id="tankVolume" name="tankVolume" required>
    </div>
    <div>
        <label for="isMoving">Is Moving:</label>
        <input type="checkbox" id="isMoving" name="isMoving" value="false">
    </div>
    <div>
        <button type="submit">Create Locomotive</button>
    </div>
</form>







<a href="/locomotive">Go back</a>

</body>
</html>