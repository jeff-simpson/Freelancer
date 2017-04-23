<!DOCTYPE html>

<html data-wf-page="58e132f3ae9dd36872ccd41d" data-wf-site="58e132f3ae9dd36872ccd41c">
<head>
  <meta charset="utf-8">
  <title>login</title>
  <meta content="width=device-width, initial-scale=1" name="viewport">
  <meta content="Webflow" name="generator">
  <link href="css/normalize_login.css" rel="stylesheet" type="text/css">
  <link href="css/login.css" rel="stylesheet" type="text/css">
  <link href="css/login.webflow.css" rel="stylesheet" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/webfont/1.4.7/webfont.js"></script>
  <script type="text/javascript">
    WebFont.load({
      google: {
        families: ["Exo:100,100italic,200,200italic,300,300italic,400,400italic,500,500italic,600,600italic,700,700italic,800,800italic,900,900italic","Varela Round:400"]
      }
    });
  </script>
  <link href="https://daks2k3a4ib2z.cloudfront.net/img/favicon.ico" rel="shortcut icon" type="image/x-icon">
  <link href="https://daks2k3a4ib2z.cloudfront.net/img/webclip.png" rel="apple-touch-icon">
</head>
<body class="body">
  
  <h1> ${task.description} </h1> 
  <table> 
  	<tr> 
  		<td> time: ${task.time} </td> 
  		<td> price: ${task.price} </td> 
  		<td> difficulty: ${task.difficulty}</td> 
  		<td> location: ${task.location}</td> 
  	</tr> 
  </table> 
  
</body>
</html>