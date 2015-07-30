<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>

<portlet:defineObjects />

<p>Hello from view.jsp!</p>

<c:if test="<%= true %>">
    <p>Hello from JSTL!</p>
</c:if>

<p>Hello from <aui:a href="http://alloyui.com">AlloyUI</aui:a>!</p>

<%
String abc = GetterUtil.getString(request.getAttribute("ABC"));
%>

<p>Abc is <%= abc %>.</p>