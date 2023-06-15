<!DOCTYPE HTML>
<html>
	<head>
		<title>Liste des utilisateurs</title>
	</head>
	<body>


<h1>Exemple simple de site en PHP</h1>


<?php
$db = new PDO("mysql:host=localhost;dbname=app_exemple", "root", "root");


if(isset($_GET["action"]) && $_GET["action"]=="save") {
	if(isset($_GET["id"]) &&  $_GET["id"]!=null) {
		$reponse = $db->prepare("update users set nom = ?, prenom = ? where id = ?");
		$reponse->execute(array($_GET["nom"],$_GET["prenom"], $_GET["id"] ));
		
	} else {
		$reponse = $db->prepare("insert into users (nom,prenom) values (?,?)");
		$reponse->execute(array($_GET["nom"], $_GET["prenom"]));
		
	}
}


if(isset($_GET["action"]) && ($_GET["action"]=="ajouter" || $_GET["action"]=="modifier")) {
	$nom = "";
	$prenom = "";
	$id = "";
	
	if($_GET["action"]=="modifier") {
		$reponse = $db->prepare("select * from users where id=?");
		$reponse->execute(array($_GET["id"]));

    while($user = $reponse->fetch()){
		$nom = $user["nom"];		
		$prenom = $user["prenom"];		
		$id = $user["id"];
	}
}
	
	?>	
	
	<form action="index.php" method="get">
		Nom : <input type="text" name="nom" value="<?php echo $nom; ?>"/>
		Prenom : <input type="text" name="prenom" value="<?php echo $prenom; ?>"/>
		<input type="hidden" name="id" value="<?php echo $id; ?>"/>
		<input type="hidden" name="action" value="save"/>
		<input type="submit"/>
	</form>

<?php	
} else { 
	$reponse = $db->prepare("select * from users ");
		$reponse->execute();


?>

<table border=1px>
	<?php
	while($user = $reponse->fetch()) {
	?>				
	<tr>
		<td>
			<?php echo $user["nom"]; ?>
		</td>
		<td>
			<?php echo $user["prenom"]; ?>
		</td>
		<td>
			<?php echo '<a href="index.php?action=modifier&id='.$user["id"].'">modifier</a>' ?>
		</td>
	</tr>
	<?php } ?>	
	
</table>

<a href="index.php?action=ajouter">ajouter</a>

<?php } ?>	
	</body>
</html>


