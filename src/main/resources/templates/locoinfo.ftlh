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
<b>Серийный номер: </b>${locomotive.serialNumber}<br>
<b>Модель локомотива: </b>${locomotive.model}<br>
<b>Осевая формула локомотива: </b>${locomotive.axFormule}<br>
<b>Мощность по дизелю локомотива: </b>${locomotive.powerOnDiesel}<br>
<b>Конструктивная скорсоть локомотива: </b>${locomotive.structuralSpeed}<br>
<b>Запас топлива локомотива: </b>${locomotive.fuelReserve}<br>
<b>Минимальный радиус прохождения кривых локомотива: </b>${locomotive.minRadius}<br>
<b>Габаритные размеры локомотива: </b>${locomotive.dimensions}<br>
<b>Пробег локомотива: </b>${locomotive.mileage}<br>
<b>Объём бака локомотива: </b>${locomotive.tankVolume}<br>
<b>Статус локомотива(двигается/стоит): </b>${locomotive.isMoving}<br>
<hr>
<#--<form action="/loco/delete/${locomotive.ID}" method="post">-->
<#--    <input type="submit" value="Удалить"/>-->
<#--</form>-->
<#--<form action="/loco/edit/${locomotive.ID}" method="get">-->
<#--    <input type="submit" value="Изменить"/>-->
<#--</form>-->
<a href="/">Вернуться на главную страницу</a>
</body>
</html>