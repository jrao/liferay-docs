<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="guestbook_GuestbookPortlet.caption"/></b>
</p>

<%
	int guestbooksCount = GetterUtil.getInteger(renderRequest.getAttribute("GUESTBOOKS_COUNT"));
%>

<p>
	There are <%= guestbooksCount %> guestbooks!
</p>