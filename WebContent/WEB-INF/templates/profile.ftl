<!DOCTYPE html>
<html data-wf-page="58f64cd4f5bb8549330b66cb" data-wf-site="58f64cd4f5bb8549330b66ca">
<head>
  <meta charset="utf-8">
  <title>Profile</title>
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
       <form method="POST" action="FreelancerBoundary" class="form w-clearfix" data-name="Email Form" id="email-form" name="email-form">
          <input class="submit-button-2 w-button" name = "button" type="submit" value="Sign Out">
          <input class="submit-button w-button"  name = "button" type="submit" value="Create Task">
          <input class="submit-button w-button"  name = "button" type="submit" value="Home">
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
      <h1 class="heading">${NAME}</h1><img class="image" src="img/star.png" width="224">
      <h1 class="heading-8" data-ix="new-interaction-7">${RANK}</h1>
      <div class="div-block-5 w-clearfix">
        <h1 class="heading-6">Contact Information:</h1>
        <h1 class="heading-7">${EMAIL}</h1>
      </div>
     <#if status == "Pending Approval">
    
      <div class="w-form">
        <form method="POST" action="FreelancerBoundary" class="form-4 w-clearfix" data-name="Email Form 2" id="email-form-2" name="email-form-2">
          <input class="submit-button-6 w-button" name = "button"  type="submit" value="Decline Offer">
          <input class="submit-button-7 w-button" name = "button" type="submit" value="Accept Offer">
          <input type=hidden name="taskID" value =${taskid}>
          <input type=hidden name="performerID" value =${userofferer.id}>
        </form>
         <#else>
      </#if>
      </div>
    </div>
  </div>
  <div class="div-block-6 w-clearfix">
    <!--SKILLS LIST FROM DATABASE-->
    <h1 class="heading-12">Skills:</h1>
   <ul class="unordered-list">
    <#assign m = skills>
    <#list m as skill>
    <li> ${skill} </li>
    </#list>
    </ul>
  </div>
  <div class="div-block-8">
    <!--TASK HISTORY LIST FROM DATABASE-->
    <h1 class="heading-15">Task History:</h1>
    <ul>
   <#assign m = task_history>
    <#list m as task>
    <li class="list-item-7 w-clearfix">
      <h3 class="heading-47">Description:</h3>
      <h3 class="heading-48">${task.description}</h3>
      <h3 class="heading-49">Time:</h3>
      <h3 class="heading-50">${task.time}</h3>
      <h3 class="heading-51">Price:</h3>
      <h3 class="heading-52">${task.price}</h3>
      <h3 class="heading-53">Difficulty:</h3>
      <h3 class="heading-54">${task.difficulty}</h3>
      <h3 class="heading-55">Location:</h3>
      <h3 class="heading-56">${task.location}</h3>
    </li>
    </#list>
    </ul>
  </div>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js" type="text/javascript"></script>
  <script src="js/lancer_profile.js" type="text/javascript"></script>
  <!-- [if lte IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif] -->
</body>
</html>
