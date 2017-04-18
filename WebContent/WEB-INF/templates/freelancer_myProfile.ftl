<!DOCTYPE html>
<!--  This site was created in Webflow. http://www.webflow.com -->
<!--  Last Published: Tue Apr 18 2017 19:11:13 GMT+0000 (UTC)  -->
<html data-wf-page="58f64cd4f5bb8549330b66cb" data-wf-site="58f64cd4f5bb8549330b66ca">
<head>
  <meta charset="utf-8">
  <title>client_myProfile</title>
  <meta content="width=device-width, initial-scale=1" name="viewport">
  <meta content="Webflow" name="generator">
  <link href="css/normalize_lancer_profile.css" rel="stylesheet" type="text/css">
  <link href="css/lancer_profile.css" rel="stylesheet" type="text/css">
  <link href="css/lancer_profile.webflow.css" rel="stylesheet" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/webfont/1.4.7/webfont.js"></script>
  <script type="text/javascript">
    WebFont.load({
      google: {
        families: ["Bitter:400,700,400italic","Exo:100,100italic,200,200italic,300,300italic,400,400italic,500,500italic,600,600italic,700,700italic,800,800italic,900,900italic"]
      }
    });
  </script>
  <script src="js/modernizr_lancer_profile.js" type="text/javascript"></script>
  <link href="https://daks2k3a4ib2z.cloudfront.net/img/favicon.ico" rel="shortcut icon" type="image/x-icon">
  <link href="https://daks2k3a4ib2z.cloudfront.net/img/webclip.png" rel="apple-touch-icon">
</head>
<body class="body">
  <div class="section-2">
    <div class="div-block-3 w-clearfix">
      <h1 class="heading-10">Freelanc</h1>
      <h1 class="heading-11" data-ix="new-interaction">r</h1>
      <div class="w-form">
        <form class="form w-clearfix" data-name="Email Form" id="email-form" name="email-form">
          <input class="submit-button-2 w-button" data-wait="Please wait..." type="submit" name="signOut" value="Sign Out">
          <input class="submit-button w-button" data-wait="Please wait..." type="submit" name="dashboard" value="Dashboard">
        </form>
        <div class="w-form-done">
          <div>Thank you! Your submission has been received!</div>
        </div>
        <div class="w-form-fail">
          <div>Oops! Something went wrong while submitting the form</div>
        </div>
      </div>
    </div>
    <div class="div-block-4">
      <h1 class="heading">${Name}</h1><img class="image" src="img/star.png" width="224">
      <h1 class="heading-8">${Rank}</h1>
      <div class="div-block-5 w-clearfix">
        <h1 class="heading-6">Contact Information:</h1>
        <h1 class="heading-7">${Email}</h1>
      </div>
    </div>
  </div>
  <div class="div-block-6 w-clearfix">
    <h1 class="heading-12">Skills:</h1>
      <!--FOR LOOP GOING THROUGH SKILLS LIST FROM DATABASE-->
    <ul class="unordered-list">
      <li></li>
      <li></li>
      <li></li>
    </ul>
  </div>
  <div class="div-block-8">
    <h1 class="heading-15">Task History:</h1>
    <ul class="unordered-list-2">
        <!--FOR LOOP GOING THROUGH TASK HISTORY FROM DATABASE-->
      <li></li>
      <li></li>
      <li></li>
    </ul>
  </div>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js" type="text/javascript"></script>
  <script src="js/lancer_profile.js" type="text/javascript"></script>
  <!-- [if lte IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif] -->
</body>
</html>