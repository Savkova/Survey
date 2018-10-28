<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>survey</title>
</head>
<body>
<h1>Survey research</h1>

<form action="form" method="post">

    <p><strong>First name:</strong></p>
    <input required type="text" name="name">

    <p><strong>Last name: </strong></p>
    <input required type="text" name="surname">

    <p><strong>Year of Birth:</strong></p>
    <input required type="number" name="year" min="1900" value="1900">

    <p><strong>How would you rate our product?</strong></p>
    <input type="radio" name="q1" value="10"> low
    <input type="radio" name="q1" value="50" checked> average
    <input type="radio" name="q1" value="100"> high

    <p><strong>What about our service?</strong></p>
    <input type="radio" name="q2" value="0"> low
    <input type="radio" name="q2" value="60" checked> average
    <input type="radio" name="q2" value="100"> high

    <p><strong>Would you recommend us?</strong></p>
    <input type="radio" name="q3" value="20"> no
    <input type="radio" name="q3" value="50" checked> maybe later
    <input type="radio" name="q3" value="100"> yes

    <p><input type="submit"></p>

</form>
</body>
</html>
