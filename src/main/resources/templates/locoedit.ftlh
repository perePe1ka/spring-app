<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Locomotive</title>
</head>
<body>
<h1>Локомотив</h1>
<hr>
<h4>Подробная информация о локомотиве</h4>
<p>${locomotive.id}</p>
<b>Серийный номер локомотива: </b>${locomotive.serialNumber}<br>
<b>Модель локомотива: </b>${locomotive.model}<br>
<b>Осевая формула локомотива: </b>${locomotive.axFormule}<br>
<b>Мощность по дизелю локомотива: </b>${locomotive.powerOnDiesel}<br>
<b>Конструкционная скорость локомотива: </b>${locomotive.structuralSpeed}<br>
<b>Запас топлива локомотива: </b>${locomotive.fuelReserve}<br>
<b>Минимальный радиус прохождения прямых локомотива: </b>${locomotive.minRadius}<br>
<b>Габаритные размеры локомотива: </b>${locomotive.dimensions}<br>
<b>Пробег локомотива: </b>${locomotive.mileage}<br>
<b>Объём бака локомотива: </b>${locomotive.tankVolume}<br>
<b>Статус локомотива (двигается/стоит): </b>${locomotive.isMoving}<br>
<hr>
<form  action="/edit" method="post">
    <input type="hidden" name="id" value="${locomotive.id}"/>
    <input type="text" name="serialNumber" value="${locomotive.serialNumber}"/>
    <input type="text" name="model" value="${locomotive.model}"/>
    <input type="text" name="axFormule" value="${locomotive.axFormule}"/>
    <input type="text" name="powerOnDiesel" value="${locomotive.powerOnDiesel}"/>
    <input type="text" name="structuralSpeed" value="${locomotive.structuralSpeed}"/>
    <input type="text" name="fuelReserve" value="${locomotive.fuelReserve}"/>
    <input type="text" name="minRadius" value="${locomotive.minRadius}"/>
    <input type="text" name="dimensions" value="${locomotive.dimensions}"/>
    <input type="text" name="mileage" value="${locomotive.mileage}"/>
    <input type="text" name="tankVolume" value="${locomotive.tankVolume}"/>
    <input type="text" name="isMoving" value="${locomotive.isMoving}"/>
    <input type="submit" value="Подтвердить"/>

</form>
</form>
<a href="/">Вернуться на главную страницу</a>
</body>
</body>
</html>