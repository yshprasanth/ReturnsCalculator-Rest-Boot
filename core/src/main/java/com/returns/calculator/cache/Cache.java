package com.returns.calculator.cache;

import com.returns.calculator.domain.Trade;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class Cache<S extends String, T extends Trade> {

    private static final long serialVersionUID = 14L;

    private Map<S, Map<Integer, T>> cacheMap;

    private static Cache<String, Trade> cacheInstance;

    static {
        cacheInstance = new Cache<>();
    }

    private Cache() {
        cacheMap = new ConcurrentHashMap<>();
    }

    public static Cache getInstance() {
        if(cacheInstance==null) {
            synchronized (Cache.class) {
                cacheInstance = new Cache<>();
            }
        }
        return cacheInstance;
    }

    private Map<Integer,T> get(S productType)  {
        Map<Integer, T> map = null;

        if(cacheMap!=null)
            map = cacheMap.putIfAbsent(productType, new ConcurrentHashMap<>());

        return map;
    }

    public void put(S productType, T trade)  {
        Map<Integer, T> map = get(productType);
        map.putIfAbsent(trade.getCompoundFrequency(), trade);
    }



}
