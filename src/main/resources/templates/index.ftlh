<!DOCTYPE html>
<html lang="RU">
<head>

    <title>Student</title>

</head>
<body>

<h1>Университет</h1><hr>

<hr>
<h3>Добавить студента</h3>
<form action="/create" method="POST">
    ID: <input type="number"/><br><br>
    Имя студента: <input type="text", name="StudentName"/><br><br>
    Название университета : <input type="text", name="UniversityName"/><br><br>
    Код специальности : <input type="text", name="CodeSpeciality"/><br><br>
    Статус академа: <input type="text", name="StatusAcademy"/><br><br>
    <input type="submit" value="Добавить студента"/>
</form>
</body>
</html>