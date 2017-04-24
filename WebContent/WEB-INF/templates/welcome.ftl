<!DOCTYPE html>
<html data-wf-page="58da6cb49c18796e5402b196" data-wf-site="58da6cb49c18796e5402b195">
<head>
  <meta charset="utf-8">
  <title>Final Proj Freemarkers</title>
  <meta content="width=device-width, initial-scale=1" name="viewport">
  <meta content="Webflow" name="generator">
  <link href="css/welcome.css" rel="stylesheet" type="text/css">
  <link href="css/welcome.webflow.css" rel="stylesheet" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/webfont/1.4.7/webfont.js"></script>
  <script src="js/jeff.js"></script>
  <script type="text/javascript">
    WebFont.load({
      google: {
        families: ["Varela Round:400","Exo:100,100italic,200,200italic,300,300italic,400,400italic,500,500italic,600,600italic,700,700italic,800,800italic,900,900italic","Bitter:400,700,400italic"]
      }
    });
  </script>
  <link href="https://daks2k3a4ib2z.cloudfront.net/img/favicon.ico" rel="shortcut icon" type="image/x-icon">
  <link href="https://daks2k3a4ib2z.cloudfront.net/img/webclip.png" rel="apple-touch-icon">
</head>
<body class="body">
  <div class="section w-clearfix">
    <h1 class="heading">Welcome ${user.firstName}</h1>
       <div class="w-form">
      <form method="POST" action="FreelancerBoundary" class="form w-clearfix" data-name="Email Form" id="email-form" name="email-form">
      <input class="submit-button-5 w-button" data-wait="Please wait..." type="submit" name = "button" id ="Sign Out" value="Sign Out">
        <input class="submit-button-5 w-button" data-wait="Please wait..." type="submit" name = "button" id ="My Profile" value="My Profile">
        <input class="submit-button-5 w-button" data-wait="Please wait..." type="submit" name = "button" id ="Create Task" value="Create Task">
        <input class="submit-button-7 w-button" data-wait="Please wait..." type="submit" name = "button" id ="Home" value="Home">
      </form>
    </div>
  </div>
  <div class="div-block w-clearfix">
    <div class="text-block-2 w-clearfix"><strong class="important-text-2">TASKS TAKEN:</strong>
    </div>
    <div class="text-block w-clearfix"><strong class="important-text"> &nbsp;&nbsp;&nbsp;TASKS GIVEN:</strong>
    </div>
  </div>
  <ul class="unordered-list-2">
    <#assign m = tasks_taken>
    <#list m as task>
    <li class="list-item-4 w-clearfix">
      <h3 class="heading-36">Description:</h3>
      <h3 class="heading-37">${task.description}</h3>
      <h3 class="heading-38">Time:</h3>
      <h3 class="heading-39">${task.time}</h3>
      <h3 class="heading-40">Price:</h3>
      <h3 class="heading-41">${task.price}</h3>
      <h3 class="heading-42">Difficulty:</h3>
      <h3 class="heading-43">${task.difficulty}</h3>
      <h3 class="heading-44">Location:</h3>
      <h3 class="heading-45">${task.location}</h3>
      <h3 class="heading-46">Status:</h3>
      <h3 class="heading-45">${task.taskStatus}</h3>
      <div class="w-form">
		<form class="w-clearfix" method="POST" action="FreelancerBoundary" data-name="Email Form 7" id="email-form-7" name="email-form-7">
		  <input type=hidden name="taskID" value =${task.id}>
		  
          <input class="submit-button-13 w-button" name = "button" type="submit" value="Mark Complete">
        </form>
      </div>
    </li>
    </#list>
  </ul>
  <ul class="unordered-list">
    <#assign m = tasks_given>
    <#list m as task>
    <li class="list-item w-clearfix">
      <h2 class="heading-19">Description:</h2>
      <h3 class="heading-20">${task.description}</h3>
      <h3 class="heading-27">Time:</h3>
      <h3 class="heading-28">${task.time}</h3>
      <h3 class="heading-29">Price:</h3>
      <h3 class="heading-30">${task.price}</h3>
      <h3 class="heading-31">Difficulty:</h3>
      <h3 class="heading-32">${task.difficulty}</h3>
      <h3 class="heading-33">Location:</h3>
      <h3 class="heading-34">${task.location}</h3>
     
      
	  <div class="w-form">
        <form method="POST" action="FreelancerBoundary" class="w-clearfix" data-name="Email Form 6" id="email-form-6" name="email-form-6">
          <input class="submit-button-11 w-button" name = "button" type="submit" value=${task.taskStatus}>
          <input type=hidden name="gtaskID" value =${task.id}>
          <input class="submit-button-12 w-button" name = "button" type="submit" value="Pay">
        </form>
       
      </div>
    </li>
    </#list>
  </ul>
  <div class="text-block-3">TASKS AVAILABLE:</div>
  <ul class="unordered-list-3">
    <#assign m = tasks_available>
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
  
    <form class="w-clearfix" method="post" action="FreelancerBoundary" data-name="Email Form 7" id="email-form-7" name="email-form-7">
		  <input type=hidden name="taskID" value =${task.id}>
		  <input type=hidden name="userID" value =${user.id}>
		  <input type=hidden id = "welcomeTakeTaskID" name ="offerToTakeTask" value=${task.id} >
          <input class="submit-button-13 w-button" name ="button" data-wait="Please wait..." type="submit" value="Offer Your Services">
        </form>
    </li>
    </#list>
  </ul>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js" type="text/javascript"></script>
  <script src="js/welcome.js" type="text/javascript"></script>
  <!-- [if lte IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif] -->
</body>
</html>
