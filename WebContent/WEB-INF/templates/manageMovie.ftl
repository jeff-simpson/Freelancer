<#include "header.ftl">

<#if error??>
	<h1> ${error} </h1>
</#if>
<h1> Edit ${movie.name} </h1>
<table>
   <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Year</th>
      <th>Rank</th>
      <th>Genre </th>
      <th> Update? </th>
      <th> Delete? </th>
   </tr>
   <tr>
      <form action="IMDBBoundary" method="POST">
         <td> ${movie.id?c} </td>
         <td><input name="title" value ="${movie.name}" required>  </td>
         <td><input name="year" value ="${movie.year?c}" required>  </td>
         <td> <input name="rank" value ="${movie.rank}" required> </td>
         <td> <#include "manageGenreCheckbox.ftl"> </td>
         <td>
            <input name="movieID" value ="${movie.id?c}" type = "hidden"> 
            <input name="updateMovie" value ="updateMovie" type ="hidden">
            <input type="submit" value="Update" class="button" />
         </td>
      </form>
      </td>
      <td>
         <form action="IMDBBoundary" method="POST">
            <input name="movieID" value ="${movie.id?c}" type = "hidden"> 
            <input name="deleteMovie" value ="deleteMovie" type ="hidden">
            <input type="submit" value="Delete" class="button" />    
         </form>
      </td>
   </tr>
</table>
<a class="button" href="index.html">Back</a>