<#include "header.ftl">
<table>
   <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Year</th>
      <th>Rank</th>
      <th>More Info </th>
   </tr>
   <#list movies as movie>
   <tr>
      <td> ${movie.id?c} </td>
      <td> ${movie.name} </td>
      <td> ${movie.year?c} </td>
      <td> ${movie.rank} </td>
      <td>
         <form action="IMDBBoundary" method="POST">
            <input name="movieName" value ="${movie.name}" type ="hidden">
            <input type="submit" value="Reviews" class="button" />
         </form>
      </td>
   </tr>
   </#list>
</table>
<a class="button" href="index.html">Back</a>