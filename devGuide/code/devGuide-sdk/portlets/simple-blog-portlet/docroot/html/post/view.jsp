<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ page import="com.liferay.portlet.simpleblog.service.PostLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.simpleblog.model.Post" %>

<%@ page import="java.util.List"%>

<portlet:defineObjects />

This is the <b>Post Portlet</b> portlet in View mode.

<%
	List<Post> posts = PostLocalServiceUtil.findByTitleContentAuthor("First Post", "First post", "Bob", 0, 10);
%>

<h3>Posts</h3>
<% if (posts != null) {
	for (Post post : posts) { %>
		<h2><%= post.getTitle() %></h2>
		<% if (post.getAuthor() != null) { %>
		<p><small>By <%= post.getAuthor().getName() %></small></p>
		<% } %>
		<div>
			<%= post.getContent() %>
		</div>
<% }
} %>