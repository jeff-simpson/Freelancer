<!DOCTYPE html>
<html data-wf-page="58f81dacaa1ab6491f480ec1" data-wf-site="58f81dacaa1ab6491f480ec0">
   <head>
      <meta charset="utf-8">
      <title>Transactions Page</title>
      <meta content="width=device-width, initial-scale=1" name="viewport">
      <meta content="Webflow" name="generator">
      <link href="css/transactions.css" rel="stylesheet" type="text/css">
      <link href="css/transactions-page.webflow.css" rel="stylesheet" type="text/css">
      <script src="https://ajax.googleapis.com/ajax/libs/webfont/1.4.7/webfont.js"></script>
      <script src ="js/jeff.js"> </script> 
      <script type="text/javascript">
         WebFont.load({
           google: {
             families: ["Exo:100,100italic,200,200italic,300,300italic,400,400italic,500,500italic,600,600italic,700,700italic,800,800italic,900,900italic","Bitter:400,700,400italic"]
           }
         });
      </script>
      <link href="https://daks2k3a4ib2z.cloudfront.net/img/favicon.ico" rel="shortcut icon" type="image/x-icon">
      <link href="https://daks2k3a4ib2z.cloudfront.net/img/webclip.png" rel="apple-touch-icon">
   </head>
   <body class="body">
      <div class="section w-clearfix">
         <h1 class="heading">Freelanc</h1>
         <h1 class="heading-2" data-ix="new-interaction">r</h1>
         <div class="w-form">
            <form method="POST" action="FreelancerBoundary" class="w-clearfix" data-name="Email Form" id="email-form" name="email-form">
               <input class="submit-button w-button" name="Button" type="submit" value="Sign Out">
               <input class="submit-button-2 w-button" name ="Button" type="submit" value="Home">
            </form>
         </div>
      </div>
      <div class="container w-container">
         <img class="image" src="img/lock.png" width="131">
         <h1 class="heading-3">SECURE</h1>
         <h1 class="heading-4"><strong class="important-text">PAY</strong></h1>
      </div>
      <div class="div-block w-clearfix">
         <h1 class="heading-5">Pay To: </h1>
         <h1 class="heading-6">${receiver.firstName}</h1>
         <h1 class="heading-7">Amount:</h1>
         <h1 id ="amount" class="heading-9">${task.price}</h1>
         <h1  class="heading-10">Current Balance:</h1>
         <h1 id ="accountBalance"class="heading-11">${giver.balance}</h1>
         <input class="submit-button-2 w-button" name="button" onclick="payUser(${receiver.id}, ${giver.id}, ${task.id})" value="Pay">
         <div class="w-form">
            <form method="POST" action="FreelancerBoundary" class="form w-clearfix" data-name="Email Form 3" id="email-form-3" name="email-form-3">
               <label class="field-label-2" for="rating">Rating:</label>
               <select name="rating">
                  <option selected value="1">1/option>
                  <option value="2">2</option>
                  <option value="3">3</option>
                  <option value="4">4</option>
                  <option value="5">5</option>
               </select>
               <input type =hidden" name ="user_id" value ="${user.id}">
               <input class="submit-button-2 w-button" name="button" value="Rate">
            </form>
         </div>
      </div>
      <div class="w-form">
      </div>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js" type="text/javascript"></script>
      <script src="js/transactions.js" type="text/javascript"></script>
      <!-- [if lte IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif] -->
   </body>
</html>