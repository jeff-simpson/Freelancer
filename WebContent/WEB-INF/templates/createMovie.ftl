<#include "header.ftl">
<#if error??>
<h1> ${error} </h1>
</#if>
<#if movieTitle??>
<h2> We did not find a movie by the name ${movieTitle}. Would you like to create one?</h2>
</#if>
<form action="IMDBBoundary" method="POST">
   <label for="title">Title</label>
   <input type="text" name="title" required />
   <label for="year">Year</label>
   <input type="text" name="year" required />
   <label for="rank">Rank</label>
   <input type="text" name="rank" required />
   <label for="movieGenre">  Genre </label>
   <#include "genreCheckbox.ftl">
   <input name="createMovie" value ="createMovie" type ="hidden">
   <input type="submit" value="Submit" class="button" />
</form>
<br/>
<a class="button" href="index.html">Back</a>