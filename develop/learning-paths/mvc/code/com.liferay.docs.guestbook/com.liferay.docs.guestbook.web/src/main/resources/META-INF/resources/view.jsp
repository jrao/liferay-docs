<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="guestbook_GuestbookPortlet.caption"/></b>
</p>

<%
	int guestbooksCount = GetterUtil.getInteger(renderRequest.getAttribute("GUESTBOOKS_COUNT"));

	String guestbookString = GetterUtil.getString(renderRequest.getAttribute("GUESTBOOKS_STRING"));
%>

<p>
	There are <%= guestbooksCount %> guestbooks!
</p>

<p>
	Guestbook string: "<%= guestbookString %>"
</p>