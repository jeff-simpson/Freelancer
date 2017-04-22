<!DOCTYPE html>
<!--  This site was created in Webflow. http://www.webflow.com -->
<!--  Last Published: Fri Apr 21 2017 16:20:42 GMT+0000 (UTC)  -->
<html data-wf-page="58da6cb49c18796e5402b196" data-wf-site="58da6cb49c18796e5402b195">
<head>
  <meta charset="utf-8">
  <title>Final Proj Freemarkers</title>
  <meta content="width=device-width, initial-scale=1" name="viewport">
  <meta content="Webflow" name="generator">
  <link href="css/normalize_dashboard.css" rel="stylesheet" type="text/css">
  <link href="css/dashboard.css" rel="stylesheet" type="text/css">
  <link href="css/final-proj-freemarkers.webflow.css" rel="stylesheet" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/webfont/1.4.7/webfont.js"></script>
  <script type="text/javascript">
    WebFont.load({
      google: {
        families: ["Varela Round:400","Exo:100,100italic,200,200italic,300,300italic,400,400italic,500,500italic,600,600italic,700,700italic,800,800italic,900,900italic","Bitter:400,700,400italic"]
      }
    });
  </script>
  <script src="js/modernizr_dashboard.js" type="text/javascript"></script>
  <link href="https://daks2k3a4ib2z.cloudfront.net/img/favicon.ico" rel="shortcut icon" type="image/x-icon">
  <link href="https://daks2k3a4ib2z.cloudfront.net/img/webclip.png" rel="apple-touch-icon">
</head>
<body class="body">
  <div class="section w-clearfix">
    <h1 class="heading">Welcome bla bla</h1>
    <div class="w-form">
      <form class="form w-clearfix" form method="POST" action="FreelancerBoundary" data-name="Email Form" id="email-form" name="email-form">
         <input class="submit-button-5 w-button" name = "button" type="submit" value="Sign Out">
        <input class="submit-button-5 w-button"  name = "button"   type="submit" value="My Profile">
        <input class="submit-button-5 w-button"  name = "button"  type="submit" value="Create Task">
        <input class="submit-button-7 w-button"  name = "button"  type="submit" value="Home">
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
   	 <ul>
      <li> <strong><em class="emphasized-text">Description: ${task.description}</em></strong></li>
      <li> Time:  ${task.time}</li>
   	  <li>Difficulty:  ${task.difficulty}</li>
      <li>Location:  ${task.location}</li>
      <li>Status: </li>
      <li> Price:</li>
      <li>
      <div class="w-form">
        <form class="w-clearfix" data-name="Email Form 4"  method="POST" action="FreelancerBoundary" id="email-form-4" name="email-form-4"
          <input class="submit-button-9 w-button" name = "button" type="submit" value= "**status**"}>
        </form>
      </div>
       </li>
      </ul>
    </li>
   
    </#list>
  </ul>
  <ul class="unordered-list">
    <#assign m = tasks_given>
    <#list m as task>
    <li class="list-item w-clearfix">
      <h3 class="heading-3"><strong><em class="emphasized-text">Description: ${task.description}</em></strong></h3>
      <h3 class="heading-3">Time: ${task.time}</h3>
      <h3 class="heading-3">Price: ${task.price}</h3>
      <h3 class="heading-3">Difficulty: ${task.difficulty}</h3>
      <h3 class="heading-3">Location: ${task.location}</h3>
      <h3 class="heading-3">Status:</h3>
      <div class="form-wrapper-2 w-form">
        <form class="form-4" data-name="Email Form 3" id="email-form-3" name="email-form-3" method="POST" action="FreelancerBoundary">
          <input class="submit-button-8 w-button" type="submit" value="In Progress">
          <input class="pay_button w-button"  type="submit" value="PAY">
        </form>
       
      </div>
    </li>
   
    </#list>
  </ul>
  <div class="text-block-3">TASKS AVAILABLE:</div>
  <div class="form-wrapper w-clearfix w-form">
    <form method="POST" action="FreelancerBoundary" class="form-2" data-name="Email Form 2" id="email-form-2" name="email-form-2">
      <select class="filter-by w-select" data-name="filterBy" id="filterBy" name="filterBy">
        <option value="">Filter By: Price</option>
        <option value="Second">Filter By: A-Z</option>
        <option value="Third">Filter By: Z-A</option>
      </select>
    </form>
  
  </div>
  <ul class="unordered-list-3">
    <#assign m = tasks_available>
    <#list m as task>
    <li class="list-item-7 w-clearfix">
      <h3 class="heading-12">Description: ${task.description} </h3> </li> 
      <div class="w-form">
        <form method="POST" action="FreelancerBoundary" class="w-clearfix" data-name="Email Form 5" id="email-form-5" name="email-form-5">
          <input class="submit-button-10 w-button"  type="submit" value="Offer Your Services">
        </form>
       
      </div>
      <h3 class="heading-3">Time: ${task.time}</h3>
      <h3 class="heading-3">Price: ${task.price}</h3>
      <h3 class="heading-3">Difficulty: ${task.difficulty}</h3>
      <h3 class="heading-3">Location: ${task.location}</h3>
    </li>
 
    </#list>
  </ul>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js" type="text/javascript"></script>
  <script src="js/dashboard.js" type="text/javascript"></script>
  <!-- [if lte IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif] -->
</body>
</html>