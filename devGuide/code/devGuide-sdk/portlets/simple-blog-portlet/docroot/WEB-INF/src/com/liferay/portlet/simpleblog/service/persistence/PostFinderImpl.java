package com.liferay.portlet.simpleblog.service.persistence;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portlet.simpleblog.model.Post;
import com.liferay.portlet.simpleblog.model.impl.PostImpl;

public class PostFinderImpl extends BasePersistenceImpl<Post> implements PostFinder {
	
	public List<Post> findByTitleContentAuthor(String title, String content, String author, int begin, int end) {
		
		/// This stuff is basic set up
        Session session = null;
        try {
            session = openSession();
            // Here ends the basic set up; 

            // Now we build the query. Note that we use the name of the tables from the database!
            String base = "SELECT SimpleBlog_Post.* FROM SimpleBlog_Post " +
                    "JOIN SimpleBlog_Author " +
                    "ON SimpleBlog_Post.authorId = SimpleBlog_Author.authorId ";
            StringBuffer sqlBuilder = new StringBuffer(base);
            List<String> criteria = new ArrayList<String>();
            if (Validator.isNotNull(title)) {
                criteria.add("SimpleBlog_Post.title like ?");
            }
            if (Validator.isNotNull(content)) {
                criteria.add("SimpleBlog_Post.content like ?");
            }
            if (Validator.isNotNull(author)) {
                criteria.add("SimpleBlog_Author.name like ?");
            }
            if (!criteria.isEmpty()) {
                sqlBuilder.append("WHERE ");
                sqlBuilder.append(criteria.remove(0) + " ");
                for (String criterion : criteria) {
                    sqlBuilder.append(" AND "+criterion);
                }
            }
            /* If all the parameters was given, the "sql" variable content should be something like
                 SELECT {SimpleBlog_Post.*} FROM SimpleBlog_Post
                  JOIN SimpleBlog_Author
                   ON SimpleBlog_Post.authorId = SimpleBlog_Author.authorId
                 WHERE SimpleBlog_Post.title like ?
                      AND SimpleBlog_Post.content like ?
                      AND SimpleBlog_Author.name like ?//
             */
             String sql = sqlBuilder.toString();
            // Now that we have built the query, we can do all the usual stuff.
            SQLQuery q = session.createSQLQuery(sql);
            q.setCacheable(false);
            q.addEntity("SimpleBlog_Post", PostImpl.class);

            QueryPos qPos = QueryPos.getInstance(q);
            // Setting the positions
            if (Validator.isNotNull(title)) {
                qPos.add("%"+title+"%");
            }
            if (Validator.isNotNull(content)) {
                qPos.add("%"+content+"%");
            }
            if (Validator.isNotNull(author)) {
                qPos.add("%"+author+"%");
            }

            //execute the query and return a list from the db
            return (List<Post>) QueryUtil.list(q, getDialect(), begin, end);
        } catch (Exception e) {
            try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
        } finally {
            //must have this to close the hibernate session..
            // if you fail to do this.. you will have a lot of open sessions… 
            closeSession(session);
        }
        
        return null;
    }	
		
}
