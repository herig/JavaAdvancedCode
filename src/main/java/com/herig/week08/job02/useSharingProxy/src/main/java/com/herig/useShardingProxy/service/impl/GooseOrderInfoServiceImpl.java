package com.herig.useShardingProxy.service.impl;

import com.herig.useShardingProxy.dto.GooseOrderInfo;
import com.herig.useShardingProxy.mapper.GooseOrderInfoMapper;
import com.herig.useShardingProxy.service.IGooseOrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GooseOrderInfoServiceImpl implements IGooseOrderInfoService {

    @Autowired
    private GooseOrderInfoMapper gooseOrderInfoMapper;

    @Override
    public List<GooseOrderInfo> queryAllOrder() {
        return gooseOrderInfoMapper.queryAllOrder();
    }

    @Override
    public List<GooseOrderInfo> insertOrderInfo(List<GooseOrderInfo> gooseOrderInfoList) {
        for (GooseOrderInfo gooseOrderInfo : gooseOrderInfoList) {
            gooseOrderInfoMapper.insertOrderInfo(gooseOrderInfo);
        }
        return gooseOrderInfoList;
    }

    @Override
    public void updateOrderInfo(GooseOrderInfo gooseOrderInfo) {
        gooseOrderInfoMapper.updateOrderInfo(gooseOrderInfo);
    }

    @Override
    public void deleteOrderInfo(GooseOrderInfo gooseOrderInfo) {
        gooseOrderInfoMapper.deleteOrderInfo(gooseOrderInfo);
    }
}
