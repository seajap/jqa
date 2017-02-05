package icom.jessieray.jqa.yh.web.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import icom.jessieray.jqa.yh.web.utils.ReflectionUtils;


@Repository
public class BaseDao {

	@Resource
    private SessionFactory sessionFactory;

	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public Serializable save(Object o) {
		return getSession().save(o);
	}

	public void update(Object o) {
		getSession().update(o);
	}

	public void saveOrUpdate(Object o) {
		getSession().saveOrUpdate(o);
	}

	public <T> void saveOrUpdateAll(Collection<T> c) {
		for(T t : c)
			getSession().saveOrUpdate(t);
	}

	public void delete(Object o) {
		getSession().delete(o);
	}

	public <T> boolean delete(Class<T> clazz, Serializable id) {
		T t = (T)get(clazz, id);
		if(null != t){
			getSession().delete(t);
			return true;
		}
		return false;
	}

	public Integer delete(String hql, Object... values) {
		int i = createQuery(hql, values).executeUpdate();
		return i;
	}

	public <T> void deleteAll(Collection<T> c) {
		for(T t : c)
			getSession().delete(t);
	}

	public int update(String hql, Object... values) {
		int i = createQuery(hql, values).executeUpdate();
		return i;
	}

	public <T> T get(Class<T> clazz, Serializable id) {
		return (T)getSession().get(clazz, id);
	}

	public <T> T load(Class<T> clazz, Serializable id) {
		return (T)getSession().load(clazz, id);
	}

	public Long total(String hql, Map<String, ?> values) {
		Long total = findUnique(hql, values);
		return total;
	}

	public Long total(String hql, Object... values) {
		Long total = findUnique(hql, values);
		return total;
	}
	
	public long total(Criteria c) {
		Long totalCountObject = (Long) c.setProjection(Projections.rowCount()).uniqueResult();
		long total = (totalCountObject != null) ? totalCountObject : 0;
		return total;
	}

	public <T> List<T> getAll(Class<T> entityClass, String orderByProperty, boolean isAsc) {
		Criteria c = createCriteria(entityClass);
		if (isAsc) {
			c.addOrder(Order.asc(orderByProperty));
		} else {
			c.addOrder(Order.desc(orderByProperty));
		}
		return c.list();
	}

	public <T> List<T> findBy(Class<T> entityClass, String propertyName, Object value) {
		Criterion criterion = Restrictions.eq(propertyName, value);
		return find(entityClass, criterion);
	}

	public <T> T findUniqueBy(Class<T> entityClass, String propertyName, Object value) {
		Criterion criterion = Restrictions.eq(propertyName, value);
		return (T)createCriteria(entityClass, criterion).uniqueResult();
	}

	public <T> List<T> find(String hql, Object... values) {
		return createQuery(hql, values).list();
	}
	
	public <T> List<T> findSplit(String hql, int currentPage, int pageSize, Object... values) {
		return setPageParameterToQuery(createQuery(hql, values), currentPage, pageSize).list();
	}
	
	public <T> List<T> find(String hql, Map<String, ?> values) {
		return createQuery(hql, values).list();
	}

	public <T> List<T> findBySql(Class<T> clazz, String sql, Object... values){
		List<T> list = createSQLQuery(sql, values)
		.setResultTransformer(Transformers.aliasToBean(clazz))
		.list();
		return list;
	}

	public <T> List<T> findBySqlSplit(Class<T> clazz, String sql, int currentPage, int pageSize, Object... values){
		List<T> list = createSQLQuery(sql, values)
		.setFirstResult((currentPage - 1) * pageSize)
		.setMaxResults(pageSize)
		.setResultTransformer(Transformers.aliasToBean(clazz))
		.list();
		return list;
	}
	
	public <T> List<T> findBySql(Class<T> clazz, String sql, Map<String, ?> values){
		List<T> list = createSQLQuery(sql, values)
		.setResultTransformer(Transformers.aliasToBean(ReflectionUtils.getSuperClassGenricType(clazz)))
		.list();
		return list;
	}
	
	public <T> T findUnique(String hql, Object... values) {
		return (T)createQuery(hql, values).uniqueResult();
	}

	public <T> T findUnique(String hql, Map<String, ?> values) {
		return (T)createQuery(hql, values).uniqueResult();
	}

	public int batchExecute(String hql, Object... values) {
		return createQuery(hql, values).executeUpdate();
	}

	public int batchExecute(String hql, Map<String, ?> values) {
		return createQuery(hql, values).executeUpdate();
	}

	public Query createQuery(String queryString, Object... values) {
		Query query = getSession().createQuery(queryString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return query;
	}

	public SQLQuery createSQLQuery(String sqlQueryString, Object... values) {
		SQLQuery query = getSession().createSQLQuery(sqlQueryString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return query;
	}

	public Query createQuery(String queryString, Map<String, ?> values) {
		Query query = getSession().createQuery(queryString);
		if (values != null) {
			query.setProperties(values);
		}
		return query;
	}
	
	public SQLQuery createSQLQuery(String sqlQueryString, Map<String, ?> values) {
		SQLQuery query = getSession().createSQLQuery(sqlQueryString);
		if (values != null) {
			query.setProperties(values);
		}
		return query;
	}

	public <T> List<T> find(Class<T> entiryClass, Criterion... criterions) {
		return createCriteria(entiryClass, criterions).list();
	}

	public <T> T findUnique(Class<T> entiryClass, Criterion... criterions) {
		return (T)createCriteria(entiryClass, criterions).uniqueResult();
	}

	public <T> Criteria createCriteria(Class<T> entityClass, Criterion... criterions) {
		Criteria criteria = getSession().createCriteria(entityClass);
		for (Criterion c : criterions) {
			criteria.add(c);
		}
		return criteria;
	}
	
	/**
	 * 涓篞uery娣诲姞distinct transformer.
	 * 棰勫姞杞藉叧鑱斿璞＄殑HQL浼氬紩璧蜂富瀵硅薄閲嶅, 锟�?瑕佽繘琛宒istinct澶勭悊.
	 */
	public Query distinct(Query query) {
		query.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		return query;
	}

	/**
	 * 涓篊riteria娣诲姞distinct transformer.
	 * 棰勫姞杞藉叧鑱斿璞＄殑HQL浼氬紩璧蜂富瀵硅薄閲嶅, 锟�?瑕佽繘琛宒istinct澶勭悊.
	 */
	public Criteria distinct(Criteria criteria) {
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		return criteria;
	}

	/**
	 * 鍒ゆ柇瀵硅薄鐨勫睘鎬э拷?锟藉湪鏁版嵁搴撳唴鏄惁鍞竴.
	 * 
	 * 鍦ㄤ慨鏀瑰璞＄殑鎯呮櫙锟�?,濡傛灉灞烇拷?锟芥柊淇敼鐨勶拷??(value)绛変簬灞烇拷?锟藉師鏉ョ殑锟�?(orgValue)鍒欎笉浣滄瘮锟�?.
	 */
	public boolean isPropertyUnique(final String propertyName, final Object newValue, final Object oldValue) {
	/*	if (newValue == null || newValue.equals(oldValue)) {
			return true;
		}
		Object object = findUniqueBy(propertyName, newValue);*/
		return false;//(object == null);
	}
	
	/**
	 * 璁剧疆鍒嗛〉鍙傛暟鍒癚uery瀵硅薄,杈呭姪鍑芥暟.
	 */
	protected <T> Query setPageParameterToQuery(final Query q, int currentPage, int pageSize) {
		q.setFirstResult((currentPage - 1) * pageSize);
		q.setMaxResults(pageSize);
		return q;
	}
	
	/**
	 * 璁剧疆鍒嗛〉鍙傛暟鍒癈riteria瀵硅薄,杈呭姪鍑芥暟.
	 */
/*	protected <T> Criteria setPageParameterToCriteria(final Criteria c, final Page<T> page) {
		if(page.getPageSize() > 0) {
			//hibernate鐨刦irstResult鐨勫簭鍙蜂粠0锟�?锟�?
			c.setFirstResult(page.getFirst() - 1);
			c.setMaxResults(page.getPageSize());
		}
		if (page.isOrderBySetted()) {
			String[] orderByArray = StringUtils.split(page.getOrderBy(), ',');
			String[] orderArray = StringUtils.split(page.getOrder(), ',');
			for (int i = 0; i < orderByArray.length; i++) {
				if (Page.ASC.equals(orderArray[i])) {
					c.addOrder(Order.asc(orderByArray[i]));
				} else {
					c.addOrder(Order.desc(orderByArray[i]));
				}
			}
		}
		return c;
	}*/

}