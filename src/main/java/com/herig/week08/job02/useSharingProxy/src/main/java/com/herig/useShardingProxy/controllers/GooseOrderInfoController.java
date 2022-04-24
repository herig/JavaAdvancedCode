package com.herig.useShardingProxy.controllers;

import com.herig.useShardingProxy.dto.GooseOrderInfo;
import com.herig.useShardingProxy.service.IGooseOrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class GooseOrderInfoController {

    @Autowired
    private IGooseOrderInfoService iGooseOrderInfoService;

    @GetMapping(value = "/goose/query/allOrder")
    public List<GooseOrderInfo> queryAllOrderMaster() {
        return iGooseOrderInfoService.queryAllOrder();
    }


    @PostMapping(value = "/goose/insert/insertOrder")
    public List<GooseOrderInfo> insertOrderInfo(HttpServletRequest request, @RequestBody GooseOrderInfo gooseOrderInfo) {
        List<GooseOrderInfo> gooseOrderInfoList = new ArrayList<>();
        gooseOrderInfoList.add(gooseOrderInfo);
        return iGooseOrderInfoService.insertOrderInfo(gooseOrderInfoList);
    }


    @PostMapping("/goose/update/updateOrder")
    public void updateOrderInfo(@RequestBody GooseOrderInfo gooseOrderInfo) {
        iGooseOrderInfoService.updateOrderInfo(gooseOrderInfo);

    }


    @PostMapping("/goose/delete/deleteOrder")
    public void deleteOrderInfo(@RequestBody GooseOrderInfo gooseOrderInfo) {
        iGooseOrderInfoService.deleteOrderInfo(gooseOrderInfo);

    }


}
