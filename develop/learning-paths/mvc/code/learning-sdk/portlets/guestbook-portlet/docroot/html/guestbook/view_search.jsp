<%@include file="/html/init.jsp"%>

<%@ page import="com.liferay.portal.kernel.search.BooleanQuery" %>
<%@ page import="com.liferay.portal.kernel.search.BooleanQueryFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.search.ParseException" %>
<%@ page import="com.liferay.portal.kernel.search.SearchEngineUtil" %>
<%@ page import="com.liferay.portal.kernel.search.SearchException" %>

<%
    String keywords = ParamUtil.getString(request, "keywords");
%>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value="/html/guestbook/view_search.jsp" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="viewURL">
	<portlet:param name="mvcPath" value="/html/guestbook/view.jsp" />
</liferay-portlet:renderURL>

<aui:form action="<%= searchURL %>" method="get" name="fm">
    <liferay-portlet:renderURLParams varImpl="searchURL" />

    <liferay-ui:header
        backURL="<%= viewURL.toString() %>"
        title="search"
    />
    
    <div class="search-form">
		<span class="aui-search-bar">
		    <aui:input inlineField="<%= true %>" label="" name="keywords" size="30" title="search-entries" type="text" />
		
		    <aui:button type="submit" value="search" />
		</span>
    </div>
</aui:form>

<%
	SearchContext searchContext = SearchContextFactory
	.getInstance(request);

	searchContext.setAttribute("paginationType", "more");
	searchContext.setStart(0);
	searchContext.setEnd(10);
	
	BooleanQuery booleanQuery = BooleanQueryFactoryUtil.create(searchContext);
	
	String[] terms = {"message", "name", "email"};
	
	try {
		booleanQuery.addTerms(terms, keywords);
	}
	catch (ParseException pe) {
		_log.error(pe.getLocalizedMessage());
	}

	Hits hits = null;
	
	try {
		hits = SearchEngineUtil.search(searchContext, booleanQuery);
	}
	catch (SearchException se) {
		_log.error(se.getLocalizedMessage());
	}
	
	List<Entry> entries = new ArrayList<Entry>();
	
	if (hits != null) {
		for (int i = 0; i < hits.getDocs().length; i++) {
			Document doc = hits.doc(i);

			long entryId = GetterUtil.getLong(doc
					.get(Field.ENTRY_CLASS_PK));

			Entry entry = null;

			try {
				entry = EntryLocalServiceUtil.getEntry(entryId);
			} catch (PortalException pe) {
				_log.error(pe.getLocalizedMessage());
			} catch (SystemException se) {
				_log.error(se.getLocalizedMessage());
			}

			entries.add(entry);
		}
	}

	List<Guestbook> guestbooks = GuestbookLocalServiceUtil
			.getGuestbooks(scopeGroupId);

	Map<String, String> guestbookMap = new HashMap<String, String>();

	for (Guestbook guestbook : guestbooks) {
		guestbookMap.put(Long.toString(guestbook.getGuestbookId()),
				guestbook.getName());
	}
%>

<liferay-ui:search-container delta="10" emptyResultsMessage="no-entries-were-found">
	<liferay-ui:search-container-results
		results="<%= entries %>"
		total="<%= entries.size() %>"
	/>

	<liferay-ui:search-container-row
		className="com.liferay.docs.guestbook.model.Entry"
		keyProperty="entryId" modelVar="entry" escapedModel="<%=true%>">
		<liferay-ui:search-container-column-text name="guestbook"
			value="<%=guestbookMap.get(Long.toString(entry.getGuestbookId()))%>" />
		
		<liferay-ui:search-container-column-text property="message" />

		<liferay-ui:search-container-column-text property="name" />

		<liferay-ui:search-container-column-jsp
			path="/html/guestbook/guestbook_actions.jsp" align="right" />
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>

<%
	if (Validator.isNotNull(keywords)) {
		String currentURL = PortalUtil.getCurrentURL(request);
		PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(
				pageContext, "search") + ": " + keywords, currentURL);
	}
%>

<%!
	private static Log _log = LogFactoryUtil.getLog("docroot.html.guestbook.view_search_jsp");
%>
