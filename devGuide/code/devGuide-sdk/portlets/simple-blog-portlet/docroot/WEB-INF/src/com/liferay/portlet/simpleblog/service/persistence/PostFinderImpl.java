package com.liferay.portlet.simpleblog.service.persistence;

import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portlet.simpleblog.model.Post;
import com.liferay.portlet.simpleblog.model.impl.PostImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class PostFinderImpl extends BasePersistenceImpl<Post> implements PostFinder {
	
	public List<Post> findByTitleContentAuthor(String title, String content, String author, int begin, int end) {
		
        Session session = null;
        try {
            session = openSession();

            String sql = CustomSQLUtil.get(FIND_BY_TITLE_CONTENT_AUTHOR);
            
            SQLQuery q = session.createSQLQuery(sql);
            q.setCacheable(false);
            q.addEntity("SimpleBlog_Post", PostImpl.class);

            QueryPos qPos = QueryPos.getInstance(q);  
            qPos.add(title);
            qPos.add(content);
            qPos.add(author);
            
            return (List<Post>) QueryUtil.list(q, getDialect(), begin, end);
        } catch (Exception e) {
            try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
        } finally {
            closeSession(session);
        }
        
        return null;
    }	
	
	public static final String FIND_BY_TITLE_CONTENT_AUTHOR = PostFinder.class.getName() + ".findByTitleContentAuthor";
		
}
