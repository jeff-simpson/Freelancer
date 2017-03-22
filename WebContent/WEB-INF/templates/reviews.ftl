<#include "header.ftl">
<div class ="wrapper">
   <div class="movieInfo">
      <table class id="reviewInfo">
         <tr>
            <th>Name</th>
            <th>Year</th>
            <th>Rank</th>
            <th>Genres </th>
            <th>Manage Information </th>
         </tr>
         <tr>
            <td> ${movie.name} </td>
            <td> ${movie.year?c} </td>
            <td> ${movie.rank} </td>
            <td> 
               <#list genres as genre>
               ${genre}
               <br/>
               </#list>  
            </td>
            <td>
               <form action="IMDBBoundary" method="POST">
                  <input name="movieID" value ="${movie.id?c}" type ="hidden">
                  <input name="manageMovie" value ="manageMovie" type ="hidden">
                  <input type="submit" value="Manage" class="button" />
               </form>
            </td>
         </tr>
      </table>
   </div>
   <h2 align="center"> Reviews </h2>
   <table>
      <#list reviews as review>
      <tr>
         <td>
            ${review.review}
            <br/>
            <span class ="alignRight">
               <form action="IMDBBoundary" method="POST">
                  <input name="reviewID" value ="${review.id}" type ="hidden">
                  <input name="movieName" value ="${movie.name}" type ="hidden">
                  <input name="deleteReview" value ="deleteReview" type ="hidden">
                  <input type="submit" value="Delete" class="button" />
               </form>
            </span>
         </td>
      </tr>
      <#else>
      <h3> There are no reviews, please go below to write one </h3>
      </#list>
   </table>
   <div class ="writeReview">
      <h2> Write Your Review for ${movie.name}</h2>
      <form action="IMDBBoundary" method="POST" id ="newReview">
         <input name="movieID" value =${movie.id?c} type ="hidden">
         <input name="createReview" value ="createReview" type ="hidden">
         <textarea rows="4" cols="50" name="review" form="newReview" required> </textarea>
         <input type="submit" value="Create" class="button" />
      </form>
      <br/>
   </div>
   <a class="button alignLeft" href="index.html">Back</a>
</div>