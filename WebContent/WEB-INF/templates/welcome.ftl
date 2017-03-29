<!DOCTYPE html>
<html data-wf-page="58da6cb49c18796e5402b196" data-wf-site="58da6cb49c18796e5402b195">
<head>
  <meta charset="utf-8">
  <title>Freelancer</title>
  <meta content="width=device-width, initial-scale=1" name="viewport">
  <meta content="Webflow" name="generator">
  <link href="css/normalize.css" rel="stylesheet" type="text/css">
  <link href="css/webflow.css" rel="stylesheet" type="text/css">
  <link href="css/final-proj-freemarkers.webflow.css" rel="stylesheet" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/webfont/1.4.7/webfont.js"></script>
  <script type="text/javascript">
    WebFont.load({
      google: {
        families: ["Varela Round:400","Exo:100,100italic,200,200italic,300,300italic,400,400italic,500,500italic,600,600italic,700,700italic,800,800italic,900,900italic"]
      }
    });
  </script>
  <script src="js/modernizr.js" type="text/javascript"></script>
  <link href="https://daks2k3a4ib2z.cloudfront.net/img/favicon.ico" rel="shortcut icon" type="image/x-icon">
  <link href="https://daks2k3a4ib2z.cloudfront.net/img/webclip.png" rel="apple-touch-icon">
</head>
<body class="body">
  <div class="section w-clearfix">
    <h1 class="heading">Welcome bla bla</h1>
    <div class="w-form">
      <form class="form w-clearfix" data-name="Email Form" id="email-form" name="email-form">
        <input class="submit-button-2 w-button" data-wait="Please wait..." type="submit" value="My Profile">
        <input class="submit-button w-button" data-wait="Please wait..." type="submit" value="Sign Out">
      </form>
      <div class="w-form-done">
        <div>Thank you! Your submission has been received!</div>
      </div>
      <div class="w-form-fail">
        <div>Oops! Something went wrong while submitting the form</div>
      </div>
    </div>
  </div>
  <div class="div-block w-clearfix">
    <div class="text-block-2 w-clearfix"><strong class="important-text-2">TASKS TAKEN:</strong>
    </div>
    <div class="text-block w-clearfix"><strong class="important-text"> &nbsp;&nbsp;&nbsp;TASKS GIVEN:</strong>
    </div>
  </div>
  <ul class="unordered-list-2">
    <li class="list-item-4">${task-given.get()}</li>
    <li class="list-item-5">${task-given.get()}</li>
    <li class="list-item-6">${task-given.get()}</li>
  </ul>
  <ul class="unordered-list">
    <li class="list-item">${task-taken.get()}</li>
    <li class="list-item-2">${task-taken.get()}</li>
    <li class="list-item-3">${task-taken.get()}</li>
  </ul>
  <div class="text-block-3">Tasks Available:</div>
  <div class="w-clearfix w-form">
    <form class="form-2" data-name="Email Form 2" id="email-form-2" name="email-form-2">
      <select class="filter-by w-select" data-name="filterBy" id="filterBy" name="filterBy">
        <option value="">Filter By: Price</option>
        <option value="First">Filter By: Location</option>
        <option value="Second">Filter By: A-Z</option>
        <option value="Third">Filter By: Z-A</option>
      </select>
    </form>
    <div class="w-form-done">
      <div>Thank you! Your submission has been received!</div>
    </div>
    <div class="w-form-fail">
      <div>Oops! Something went wrong while submitting the form</div>
    </div>
  </div>
  <ul class="unordered-list-3">
    <li class="list-item-7">${task-available.get()}</li>
    <li class="list-item-8">${task-available.get()}</li>
    <li class="list-item-9">${task-available.get()}</li>
  </ul>
  <div class="div-block-2">
    <h1 class="heading-2">&nbsp;Create Task:</h1>
    <div class="w-form">
      <form class="form-3 w-clearfix" data-name="Email Form 3" id="email-form-3" name="email-form-3">
        <label for="name"><strong>&nbsp;&nbsp;&nbsp;Task Name:</strong>
        </label>
        <input class="text-field w-input" data-name="Name" id="name" maxlength="256" name="name" placeholder="Enter Task Name" type="text">
        <label for="field"><strong>&nbsp;&nbsp;&nbsp;Task Description:</strong>
        </label>
        <textarea class="textarea w-input" id="field" maxlength="5000" name="field" placeholder="Enter Description"></textarea>
        <div class="text-block-4"><strong class="important-text-3"> &nbsp;&nbsp;&nbsp;Task Price:</strong>
        </div>
        <input class="text-field-2 w-input" data-name="Email" id="email" maxlength="256" name="email" placeholder="Enter $" required="required" type="email">
        <input class="submit-button-4 w-button" data-wait="Please wait..." type="submit" value="Submit">
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
  <script src="js/webflow.js" type="text/javascript"></script>
  <!-- [if lte IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif] -->
</body>
</html>