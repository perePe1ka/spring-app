<!DOCTYPE html>
<html lang="ru">
<head><title>BeeBeeTaxi Manager</title></head>
<body>
<h1>Manager</h1>
<form action="/drivers/add" method="POST">
    Бренд: <input type="text" name="brand" id="brand" placeholder="Введите модель" required>
    Модель: <input type="text" name="model" id="carModel" placeholder="Введите модель машины" required>
    Год выпуска:<input type="number" name="yearOfIssue" id="yearOfIssue" placeholder="Введите год выпуска" required>
    Пробег <input type="number" name="run" id="run" placeholder="Введите пробег машины(км)"  required>
    Повреждения: <input type="text" name="faults" id="faults" placeholder="Расскажите про повреждения" required>
    Стутус: <input type="checkbox" name="status" id="status" placeholder="Машина в движении/ в ожидании" required>
    <button type="submit">ADD</button>
</form>
</body>
</html>