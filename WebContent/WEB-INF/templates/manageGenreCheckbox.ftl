<#list allGenres as allGenre>
	<#assign x = 0> 
	<#list movieGenres as movieGenre>
		<#if allGenre == movieGenre>
			<input type="checkbox" name="${allGenre}" value="${allGenre}" checked />${allGenre}<br />
			<#assign x = 1> 
			<#break>
			
		</#if>
	</#list>
	<#if x == 0>
		<input type="checkbox" name="${allGenre}" value="${allGenre}" />${allGenre}<br />
	</#if>
</#list>
