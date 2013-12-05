package com.ixxus.stu;

import java.util.*;

import org.springframework.extensions.webscripts.*;
import org.alfresco.service.cmr.repository.*;
import org.alfresco.service.cmr.search.*;

public class AllFilesWebScript extends DeclarativeWebScript
{
	private SearchService searchService;
	
	public AllFilesWebScript(SearchService searchService)
	{
		this.searchService = searchService;
	}
	
	@Override
	protected Map<String, Object> executeImpl(WebScriptRequest req, Status status, Cache cache)
	{
		Map<String, Object> webScriptResults = new HashMap<String, Object>();
		StoreRef workspaceStore = StoreRef.STORE_REF_WORKSPACE_SPACESSTORE;
		
//		String query = "+PATH:\"/app:company_home//*\" +TYPE:\"cm:content\" -TYPE:\"cm:systemfolder\"";
		String query = "+PATH:\"/app:company_home//*\" +TYPE:\"cm:content\" -TYPE:\"cm:systemfolder\" +@cm\\:modified:2013-11-12";
		
		ResultSet results = null;
		List<NodeRef> nodeRefResults = new ArrayList<NodeRef>();
		try
		{
			results = searchService.query(workspaceStore, SearchService.LANGUAGE_SOLR_ALFRESCO, query);
			nodeRefResults = results.getNodeRefs();
		}
		finally
		{
			if (results != null)
			{
				results.close();
			}
		}
		
		webScriptResults.put("results", nodeRefResults);
		return webScriptResults;
	}
	
	/**
	 * For dependency injection by Spring
	 */
	/*public SearchService getSearchService()
	{
        return searchService;
    }
	public void setSearchService(SearchService searchService)
    {
        this.searchService = searchService;
    }*/
}
