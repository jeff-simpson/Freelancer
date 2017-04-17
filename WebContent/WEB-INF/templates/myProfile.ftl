<!DOCTYPE html>
<!--  This site was created in Webflow. http://www.webflow.com -->
<!--  Last Published: Mon Apr 17 2017 19:36:56 GMT+0000 (UTC)  -->
<html data-wf-page="58e25e9515fd90376605bed7" data-wf-site="58e25e9515fd90376605bed6">
<head>
  <meta charset="utf-8">
  <title>sort-javascript</title>
  <meta content="width=device-width, initial-scale=1" name="viewport">
  <meta content="Webflow" name="generator">
  <link href="css/normalize_myPro.css" rel="stylesheet" type="text/css">
  <link href="css/myProfile.css" rel="stylesheet" type="text/css">
  <link href="css/myProfile.webflow.css" rel="stylesheet" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/webfont/1.4.7/webfont.js"></script>
  <script type="text/javascript">
    WebFont.load({
      google: {
        families: ["Bitter:400,700,400italic","Exo:100,100italic,200,200italic,300,300italic,400,400italic,500,500italic,600,600italic,700,700italic,800,800italic,900,900italic"]
      }
    });
  </script>
  <script src="js/modernizr_myPro.js" type="text/javascript"></script>
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
      <h1 class="heading">(Name)</h1><img class="image" src="img/star.png" width="224">
      <h1 class="heading-8">${RANK}</h1>
      <div class="div-block-5 w-clearfix">
        <h1 class="heading-6">Contact Information:</h1>
        <h1 class="heading-7">${EMAIL}</h1>
      </div>
    </div>
  </div>
  <div class="div-block-6 w-clearfix">
    <h1 class="heading-12">Skills:</h1><a class="button-2 w-button" data-ix="new-interaction-2" href="#">Add Skill</a>
    <div class="w-form">
      <form class="form-2 w-clearfix" data-name="Email Form 2" id="email-form-2" name="email-form-2">
        <input class="text-field w-input" data-ix="new-interaction-3" data-name="Name" id="name" maxlength="256" name="skill" placeholder="Enter your skill" required="required" type="text">
        <input class="submit-button-3 w-button" data-ix="new-interaction-3" data-wait="Please wait..." type="submit" name="submitSkill" value="Submit">
      </form>
      <div class="w-form-done">
        <div>Thank you! Your submission has been received!</div>
      </div>
      <div class="w-form-fail">
        <div>Oops! Something went wrong while submitting the form</div>
      </div>
    </div>
      <!--FOR LOOP THAT GOES THROUGH THE NUMBER OF SKILLS-->
    <ul class="unordered-list">
      <li></li>
      <li></li>
      <li></li>
    </ul>
  </div>
  <div class="div-block-7 w-clearfix">
    <h1 class="heading-13">Bank Information:</h1>
    <div class="w-form">
      <form class="w-clearfix" data-name="Email Form 3" id="email-form-3" name="email-form-3">
        <input class="text-field-2 w-input" data-ix="new-interaction-3" data-name="Email" id="email" maxlength="256" name="bankAmount" placeholder="Enter Amount" required="required" type="text">
        <input class="submit-button-4 w-button" data-ix="new-interaction-3" data-wait="Please wait..." type="submit" name="submitAmount" value="Submit">
      </form>
      <div class="w-form-done">
        <div>Thank you! Your submission has been received!</div>
      </div>
      <div class="w-form-fail">
        <div>Oops! Something went wrong while submitting the form</div>
      </div>
    </div>
    <h1 class="heading-14">Balance:</h1>
    <div class="text-block">This is some text inside of a div block.</div><a class="button-3 w-button" data-ix="new-interaction-4" href="#">Add Money</a>
  </div>
  <div class="div-block-8">
    <h1 class="heading-15">Task History:</h1>
      <!--FOR LOOP THAT GOES THROUGH THE NUMBER OF TASKS DONE-->
    <ul class="unordered-list-2">
      <li></li>
      <li></li>
      <li></li>
    </ul>
  </div>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js" type="text/javascript"></script>
  <script src="js/myProfile.js" type="text/javascript"></script>
  <!-- [if lte IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif] -->
</body>
</html>