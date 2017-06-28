package com.wish.action.dao;

/**
 * 基础Mapper类
 * @author fqh
 * @email fanqinghui100@126.com
 * @date 2017/6/26 14:29
 */
public interface BaseMapper<T> {

    int deleteByPrimaryKey(Long id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}
