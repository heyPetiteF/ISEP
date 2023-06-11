<?php
if ($_SERVER["REQUEST_METHOD"] === "POST") {
    $prenom = $_POST["prenom"];
    $nom = $_POST["nom"];
    $email = $_POST["email"];
    $carres = $_POST["carres"];
    $horizontaux = $_POST["horizontaux"];

    $errorMessages = [];

    if (empty($prenom) || empty($nom) || empty($email)) {
        $errorMessages[] = "Tous les champs doivent être remplis";
    }

    if (empty($prenom)) {
        $errorMessages[] = "Prénom doit être rempli";
    }

    if (empty($nom)) {
        $errorMessages[] = "Nom doit être rempli";
    }

    if (empty($email)) {
        $errorMessages[] = "e-Mail doit être rempli";
    }

    $quiz = 0;

    if ($carres === "40" && $horizontaux === "Oui") {
        $quiz = 1;

        $servername = "localhost";
        $username = "root";
        $password = "";
        $dbname = "quiz";

        $conn = new mysqli($servername, $username, $password, $dbname);

        if ($conn->connect_error) {
            die("Erreur de connexion à la base de données : " . $conn->connect_error);
        }

        $timestamp = date("Y-m-d H:i:s");
        $sql = "INSERT INTO quiz_results (score, timestamp) VALUES ($quiz, '$timestamp')";
        if ($conn->query($sql) !== true) {
            echo "Erreur lors de l'insertion du résultat du quiz : " . $conn->error;
        }

        $conn->close();
    } else {
        // Redirection vers index.php en cas de réponse incorrecte
        header("Location: index.php?error=1");
        exit();
    }

    $errorCount = count($errorMessages);

    if ($errorCount > 0) {
        foreach ($errorMessages as $errorMessage) {
            echo '<p style="color: red; font-weight: bold;">' . $errorMessage . '</p>';
        }
    } else {
        echo '<p style="color: green; font-weight: bold;">Félicitations ! Vous avez répondu correctement au quiz.</p>';
        echo '<img src="bravo.png" alt="Bravo">';

        echo "Prénom : " . $prenom . "<br>";
        echo "Nom : " . $nom . "<br>";
        echo "Email : " . $email . "<br>";

        // 创建与数据库的连接
        $conn = new mysqli($servername, $username, $password, $dbname);

        // 检查连接是否成功
        if ($conn->connect_error) {
            die("La connexion à la base de données a échoué: " . $conn->connect_error);
        }

        // 将用户输入的数据插入到数据库中
        $sql = "INSERT INTO quiz_results (prenom, nom, email) VALUES ('$prenom', '$nom', '$email')";
        if ($conn->query($sql) !== true) {
            echo "Echec de l'insertion de données: " . $conn->error;
        }
        // 关闭数据库连接
        $conn->close();
    }
} else {
    header("Location: index.php");
    exit();
}
?>
