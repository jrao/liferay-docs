<%@ include file="/init.jsp" %>

<p>Hello from view.jsp!</p>

<c:if test="<%= true %>">
    <p>Hello from JSTL!</p>
</c:if>

<p>Hello from <aui:a href="http://alloyui.com">AlloyUI</aui:a>!</p>