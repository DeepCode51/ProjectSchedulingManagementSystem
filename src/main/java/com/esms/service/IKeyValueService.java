package com.esms.service;

import com.esms.po.KeyValue;

public interface IKeyValueService {
    public KeyValue getKeyValueById(int id) throws Exception;
    public KeyValue selectBykvKey(String key)throws Exception;
    public int updateByPrimaryKey(KeyValue kv)throws Exception;
}
