package com.herig.useShardingProxy.mapper;


import com.herig.useShardingProxy.dto.GooseOrderInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GooseOrderInfoMapper {

    List<GooseOrderInfo> queryAllOrder();
    int insertOrderInfo(GooseOrderInfo gooseOrderInfo);
    int updateOrderInfo(GooseOrderInfo gooseOrderInfo);
    int deleteOrderInfo(GooseOrderInfo gooseOrderInfo);


}
