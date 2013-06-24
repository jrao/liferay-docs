package com.liferay.portlet.simpleblog.service.persistence;

import java.util.List;

import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portlet.simpleblog.model.Post;

public class PostFinderImpl extends BasePersistenceImpl<Post> implements PostFinder {
	
	public List<Post> findByTitleContentAuthor(String title, String content, String author, int begin, int end) {
		
		return null;
	}

}
