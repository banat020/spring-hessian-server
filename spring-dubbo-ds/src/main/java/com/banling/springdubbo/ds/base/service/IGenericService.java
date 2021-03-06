package com.banling.springdubbo.ds.base.service;

import java.util.List;
import java.util.Map;

/**Hibernate数据操作通用工具接口。<br>
 * @author Ban
 *
 * @param <T>
 */
public interface IGenericService<T> {
	
	/** 保存实体
	 * @param entity
	 * @return
	 */
	T save(T entity);
	
	/** 更新实体
	 * @param entity
	 * @return
	 */
	T update(T entity);
	
	/**批量更新
	 * @param list List<T>
	 * @return boolean,成功返回true,失败返回false
	 */
	boolean updateByBatch(List<T> list);
	
	/** 根据ID删除实体.<br>
	 * 注意：删除不存在的实体会报错
	 * @param id	主键
	 */
	void remove(Object id);
	
	/** 根据多个ID删除实体<br>
	 * 注意：删除不存在的实体会报错
	 * @param Object... ids	主键数组
	 */
	void removeByIds(Object... ids);
	
	/** 查找实体
	 * @param id	主键
	 * @return
	 */
	T find(Object id);
	
	/** 查找无重复的实体
	 * @param distinct	去除重复
	 * @return
	 */
	List<T> findAll(boolean distinct);
	
	/** 分页查找无重复的实体
	 * @param distinct	去除重复
	 * @param skip 起始记录
	 * @param size 返回记录条数
	 * @return
	 */
	List<T> findAll(boolean distinct, int skip, int size);
	
	/** 分页按单个字段查找实体
	 * @param field		字段名
	 * @param value		字段值
	 * @return
	 */
	List<T> findByProperty(String field, Object value);
	
	/** 按单个字段查找实体
	 * @param field		字段名
	 * @param value		字段值
	 * @param skip 起始记录
	 * @param size 返回记录条数
	 * @return
	 */
	List<T> findByProperty(String field, Object value, int skip, int size);
	

	/**条件查询<br>
	 * 等同于findByJPQLQuery
	 * @param jpql String, 完整的JPA QL
	 * @param paramsMap, Where中的条件参数，要与jpql对应
	 * @return
	 */
	List<T> findByWhere(String jpql,Map<String,Object> paramsMap);
	
	/**分页条件查询<br>
	 * 等同于findByJPQLQuery
	 * @param jpql String, 完整的JPA QL
	 * @param paramsMap, Where中的条件参数，要与jpql对应
	 * @param skip 起始记录
	 * @param size 返回记录条数
	 * @return
	 */
	List<T> findByWhere(String jpql,Map<String,Object> paramsMap, int skip, int size);
	
	/**	获取无重复的记录数
	 * @param distinct	去除重复
	 * @return
	 */
	int countAll(boolean distinct);
	
	/** 按单个字段获取的记录数
	 * @param field		字段名
	 * @param value		字段值
	 * @return
	 */
	int countByProperty(String field, Object value);
	
	
//
//	以下是通用操作方法
//	（不局限当前实体）
//
	
	/**	获取代理实体<br>
	 * （通用操作方法，不局限当前实体）
	 * @param clazz	实体类型
	 * @param id	主键
	 * @return
	 */
	<X> X getReference(Class<X> clazz, Object id);
	
	/** 使用JPQL语句查找实体<br>
	 * （通用操作方法，不局限当前实体）
	 * @param jpql
	 * @param clazz
	 * @param skip 起始记录
	 * @param size 返回记录条数
	 * @param params	位置参数
	 * @return
	 */
	<X> List<X> findByJPQLQuery(String jpql, Class<X> clazz, int skip, int size, Object... params);
	
	/** 使用JPQL语句查找实体<br>
	 * （通用操作方法，不局限当前实体）
	 * @param jpql
	 * @param clazz
	 * @param skip 起始记录
	 * @param size 返回记录条数
	 * @param paramsMap	命名参数
	 * @return
	 */
	<X> List<X> findByJPQLQuery(String jpql, Class<X> clazz, int skip, int size, Map<String, Object> paramsMap);
	
	/** 使用命名查询查找实体<br>
	 * （通用操作方法，不局限当前实体）
	 * @param name
	 * @param clazz
	 * @param skip 起始记录
	 * @param size 返回记录条数
	 * @param params	位置参数
	 * @return
	 */
	<X> List<X> findByNamedQuery(String name, Class<X> clazz, int skip, int size, Object... params);
	
	/** 使用命名查询查找实体<br>
	 * （通用操作方法，不局限当前实体）
	 * @param name
	 * @param clazz
	 * @param skip 起始记录
	 * @param size 返回记录条数
	 * @param paramsMap	命名参数
	 * @return
	 */
	<X> List<X> findByNamedQuery(String name, Class<X> clazz, int skip, int size, Map<String, Object> paramsMap);
	
	/**	使用原生SQL查找实体（实体类型为null时返回List<Map>）<br>
	 * （通用操作方法，不局限当前实体）
	 * @param sql
	 * @param clazz
	 * @param skip 起始记录
	 * @param size 返回记录条数
	 * @param params	位置参数
	 * @return
	 */
	<X> List<X> findByNativeQuery(String sql, Class<X> clazz, int skip, int size, Object... params);
	
	/** 使用原生SQL查找实体（实体类型为null时返回List<Map>）<br>
	 * （通用操作方法，不局限当前实体）
	 * @param sql
	 * @param clazz
	 * @param skip 起始记录
	 * @param size 返回记录条数
	 * @param paramsMap	命名参数
	 * @return
	 */
	<X> List<X> findByNativeQuery(String sql, Class<X> clazz, int skip, int size, Map<String, Object> paramsMap);
	
	/** 使用JPQL语句获取条数
	 * @param jpql
	 * @param params	位置参数
	 * @return
	 */
	int countByJPQLQuery(String jpql, Object... params);
	
	/** 使用JPQL语句获取条数
	 * @param jpql
	 * @param paramsMap	命名参数
	 * @return
	 */
	int countByJPQLQuery(String jpql, Map<String, Object> paramsMap);
	
	/** 使用命名查询获取条数
	 * @param name
	 * @param params	位置参数
	 * @return
	 */
	int countByNamedQuery(String name, Object... params);
	
	/** 使用命名查询获取条数
	 * @param name
	 * @param paramsMap	命名参数
	 * @return
	 */
	int countByNamedQuery(String name, Map<String, Object> paramsMap);
	
	/** 使用原生SQL获取条数
	 * @param sql
	 * @param params	位置参数
	 * @return
	 */
	int countByNativeQuery(String sql, Object... params);
	
	/** 使用原生SQL获取条数
	 * @param sql
	 * @param paramsMap	命名参数
	 * @return
	 */
	int countByNativeQuery(String sql, Map<String, Object> paramsMap);
	
	/** 执行JPQL语句（常用于批量操作更新、删除）
	 * @param jpql
	 * @param params	位置参数
	 * @return
	 */
	int executeByJPQL(String jpql, Object... params);
	
	/** 执行JPQL语句（常用于批量操作更新、删除）
	 * @param jpql
	 * @param paramsMap	命名参数
	 * @return
	 */
	int executeByJPQL(String jpql, Map<String, Object> paramsMap);
	
	/** 执行原生SQL（常用于批量操作更新、删除）
	 * @param sql
	 * @param params	位置参数
	 * @return
	 */
	int executeBySQL(String sql, Object... params);
	
	/** 执行原生SQL（常用于批量操作更新、删除）
	 * @param sql
	 * @param paramsMap	命名参数
	 * @return
	 */
	int executeBySQL(String sql, Map<String, Object> paramsMap);
	
}
