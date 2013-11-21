<#assign contentLength = results?size>
{ "contentLength":"${contentLength}", "content":[
<#list results as item>
{
	"cmName":${item.properties.name}",
	"cmTitle":${item.properties.title!''}",
}
	<#if (item_has_next)>,</#if>
</#list>
]
}