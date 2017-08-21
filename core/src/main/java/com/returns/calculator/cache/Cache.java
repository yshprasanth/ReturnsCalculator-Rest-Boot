package com.returns.calculator.cache;

import com.returns.calculator.domain.server.Trade;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * Cache implementation for the application.
 *
 * Stores the objects in a ConcurrentHashMap
 * @param <S>  String (ProductType)
 * @param <T>  Implementation of Trade Interface
 */

@Component
@Qualifier("cache")
@Scope("singleton")
public class Cache<S extends String, T extends Trade> implements Serializable {

    private static final long serialVersionUID = 14L;

    private static Cache<String, Trade> cacheInstance;
    static {
        cacheInstance = new Cache<>();
    }

    private Map<S, Map<Integer, T>> cacheMap;

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

    private Map<Integer, T> getMap(S productType) {
        Map<Integer, T> map = null;

        if(cacheMap!=null)
            map = cacheMap.putIfAbsent(productType, new ConcurrentHashMap<>());

        return map;
    }

    private Collection<T> getAllTrades(S productType)  {
        Map<Integer, T> map = getMap(productType);

        return map.values();
    }

    public void put(S productType, T trade)  {
        Map<Integer, T> map = getMap(productType);
        map.putIfAbsent(trade.getTradeId(), trade);
    }

    public List<T> getAllTradesForClient(S clientName) {
        List<T> fullList = new ArrayList<>();
        for(Map<Integer, T> map : cacheMap.values()) {
            List<T> clientList = map.values().parallelStream().filter(t -> t.getClientName().equals(clientName)).collect(Collectors.toList());
            fullList.addAll(clientList);
        }

        return fullList;
    }

    public List<T> getTradesPerProductType(S productType) {
        List<T> fullList = getAllTrades(productType).stream().collect(Collectors.toList());
        return fullList;
    }


}
