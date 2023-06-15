<!DOCTYPE html>
<head>
  <link rel="stylesheet" href="style.css">
  <title>Quiz</title>
</head>

<body>
  <div class="quiz">
    <img src="quiz.png" alt="quiz">
  </div>
  <h1>Merci de remplir ce formulaire :</h1>
  <div id="errorMessages" class="center">
    <?php
    if (isset($_GET["error"]) && $_GET["error"] === "1") {
      echo '<p style="color: blue; font-weight: bold;">Essaie encore</p>';
    }
    ?>
  </div>

  <form id="myForm" action="traitement.php" method="POST"> 
    <label for="prenom">Prénom* :</label><br>
    <input type="text" id="prenom" name="prenom"><br><br>
    <label for="nom">Nom* :</label><br>
    <input type="text" id="nom" name="nom"><br><br>
    <label for="email">e-Mail* :</label><br>
    <input type="text" id="email" name="email"><br><br>
    *Champs obligatoires

    <div class="quiz">

      <div class="question">
        Combien y a-t-il de carrés ?
        <img class="images" src="carres.png">
        <select name="carres">
          <option value="">-</option>
          <option value="37">37</option>
          <option value="40">40</option>
          <option value="42">42</option>
          <option value="38">38</option>
        </select>

      </div>

      <div class="question">
        Les lignes horizontales sont-elles parallèles ?
        <img class="images" src="horizontaux.png">
        <div class="bradio">
          <input type="radio" name="horizontaux" value="Oui">
          <label for="html">Oui</label><br>
          <input type="radio" id="css" name="horizontaux" value="Non">
          <label for="css">Non</label><br>

        </div>
      </div>
    </div>

    <input type="submit" value="Vérifier">
    <input type="reset" value="effacer les réponses">

  </form>

  <script>
    var form = document.getElementById("myForm");
    var errorMessagesContainer = document.getElementById("errorMessages");

    function confirmSubmission(event) {
      event.preventDefault();
      var confirmation = confirm("Êtes-vous sûr de vouloir soumettre les réponses ?");
      if (confirmation) {
        validateForm();
      }
    }

    function validateForm() {
      var firstNameInput = document.getElementById("prenom");
      var lastNameInput = document.getElementById("nom");
      var emailInput = document.getElementById("email");

      var errorMessages = [];

      if (firstNameInput.value === "" && lastNameInput.value === "" && emailInput.value === ""){
        errorMessages.push("Tous les champs doivent être remplis");
      }

      
      if (firstNameInput.value === "") {
        errorMessages.push("Prénom doit être rempli");
      }

      if (lastNameInput.value === "") {
        errorMessages.push("Nom doit être rempli");
      }

      if (emailInput.value === "") {
        errorMessages.push("e-Mail doit être rempli");
      }
      
      

      if (errorMessages.length > 0) {
        errorMessagesContainer.innerHTML = "";
        for (var i = 0; i < errorMessages.length; i++) {
          var errorMessage = document.createElement("p");
          errorMessage.style.color = "red";
          errorMessage.style.fontWeight = "bold";
          errorMessage.textContent = errorMessages[i];
          errorMessagesContainer.appendChild(errorMessage);
        }
      } else {
        form.submit();
      }
    }

    form.addEventListener("submit", confirmSubmission);
  </script>

</body>
</html>
