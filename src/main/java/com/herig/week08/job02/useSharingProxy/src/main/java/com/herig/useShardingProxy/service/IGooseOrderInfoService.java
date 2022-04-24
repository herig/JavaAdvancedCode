package com.herig.useShardingProxy.service;

import com.herig.useShardingProxy.dto.GooseOrderInfo;

import java.util.List;

public interface IGooseOrderInfoService {

    public List<GooseOrderInfo> queryAllOrder();

    public List<GooseOrderInfo> insertOrderInfo(List<GooseOrderInfo> gooseOrderInfoList);

    public void updateOrderInfo(GooseOrderInfo gooseOrderInfo);

    public void deleteOrderInfo(GooseOrderInfo gooseOrderInfo);
}
