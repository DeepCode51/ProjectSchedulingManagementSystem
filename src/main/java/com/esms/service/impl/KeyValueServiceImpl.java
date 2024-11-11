package com.esms.service.impl;

import com.esms.dao.KeyValueMapper;
import com.esms.po.KeyValue;
import com.esms.service.IKeyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeyValueServiceImpl implements IKeyValueService {
    @Autowired
    private KeyValueMapper keyValueMapper = null;

    public KeyValue getKeyValueById(int id) throws Exception{
        return keyValueMapper.selectByPrimaryKey(id);
    }

    @Override
    public KeyValue selectBykvKey(String key) throws Exception {
        return keyValueMapper.selectBykvKey(key);
    }

    @Override
    public int updateByPrimaryKey(KeyValue kv) throws Exception {
        return keyValueMapper.updateByPrimaryKey(kv);
    }
}
