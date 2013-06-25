Liferay.Service.register("Liferay.Service.SimpleBlog", "com.liferay.portlet.simpleblog.service", "simple-blog-portlet");

Liferay.Service.registerClass(
	Liferay.Service.SimpleBlog, "Author",
	{
		addAuthor: true,
		updateAuthor: true,
		deleteAuthor: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.SimpleBlog, "Post",
	{
		addPost: true,
		updatePost: true,
		deletePost: true
	}
);