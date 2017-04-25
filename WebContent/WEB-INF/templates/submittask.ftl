<!DOCTYPE html>
<html data-wf-page="58e132f3ae9dd36872ccd41d" data-wf-site="58e132f3ae9dd36872ccd41c">
<head>
  <meta charset="utf-8">
  <title>Freelancr</title>
  <meta content="width=device-width, initial-scale=1" name="viewport">
  <meta content="Webflow" name="generator">
  <link href="css/normalize_CA.css" rel="stylesheet" type="text/css">
  <link href="css/createAccount.css" rel="stylesheet" type="text/css">
  <link href="css/createAccount.webflow.css" rel="stylesheet" type="text/css">
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
  <h1 class="heading-2 w-clearfix"><strong data-ix="new-interaction-8" class="important-text-5">Freelanc</strong></h1><a class="button w-button" href="index.html">Home</a>
  <h1 class="heading-3" data-ix="new-interaction-7">r</h1>
  <div class="div-block">
    <div class="form-wrapper w-form">
      <form method="post" action="FreelancerBoundary" class="form" data-name="login" id="wf-form-login" name="wf-form-login">
        <h1 class="heading" data-ix="new-interaction-5">Submit Task</h1>
       
         <label class="field-label" for="name"><strong class="important-text-3 important-text-4">Description:</strong> </label>
        	<input class="text-field w-input" data-ix="new-interaction-2" data-name="description" id="description" maxlength="256" name="description" placeholder="description" type="text">
       
         <label class="field-label" for="name"><strong class="important-text-3 important-text-4">Price:</strong></label>
        	 <input class="text-field w-input" data-ix="new-interaction-2" data-name="Price" id="price" maxlength="256" name="price" placeholder="price" type="text">
       
         <label for="field">Difficulty:</label>
        	<select name = "difficulty">
  				<option value="1">1</option>
  				<option value="2">2</option>
  				<option value="3">3</option>
  				<option value="4">4</option>
  				<option value="5">5</option>
			</select>
			
        <label for="email"><strong class="important-text important-text-2">Location:</strong></label>
        	<input class="text-field-3 w-input" data-ix="new-interaction-4" id="field" maxlength="256" name="location" placeholder="location" name = "location">
       
        <input class="submit-button w-button" data-wait="Please wait..." type="submit" value="Submit Task" name="button">
      </form>
      
      <div class="w-form-done">
        <div>Thank you! Your submission has been received!</div>
      </div>
      <div class="w-form-fail">
        <div>Oops! Something went wrong while submitting the form</div>
      </div>
    </div>
  </div>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js" type="text/javascript"></script>
  <script src="js/createAccount.js" type="text/javascript"></script>
  <!-- [if lte IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif] -->
</body>
</html>