<!DOCTYPE html>
<html>
<head>
    <title>Forwarding Example</title>
</head>
<body>
    <h2>Select an Option</h2>
    <form action="forwarder" method="post">
        <label for="destination">Choose where to go:</label><br>
        <select id="destination" name="destination">
            <option value="welcome">Go to Welcome Page</option>
            <option value="goodbye">Go to Goodbye Page</option>
        </select><br><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
