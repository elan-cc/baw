package com.ruoyi.web.service.scheduled;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.web.controller.wx.utils.Utils;
import com.ruoyi.web.domain.BawMessageCenterWx;
import com.ruoyi.web.domain.BawOrderManagement;
import com.ruoyi.web.mapper.BawMessageCenterWxMapper;
import com.ruoyi.web.mapper.BawOrderManagementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @author sunyun
 * @date 2022年06月10日17:54
 */
@Component("time")
public class scheduledTask {
    @Autowired
    private BawOrderManagementMapper bawOrderManagementMapper;
    @Autowired
    private BawMessageCenterWxMapper bawMessageCenterWxMapper;

    /**
     * 定时任务
     */
    public void timing() {
        BawOrderManagement bawOrderManagement = new BawOrderManagement();
        bawOrderManagement.setOrderStatus("1");
        List<BawOrderManagement> bawOrderManagements1 = bawOrderManagementMapper.selectBawOrderManagementList(bawOrderManagement);
        for (BawOrderManagement orderManagement : bawOrderManagements1) {
            String timeLeft = Utils.calculatingTime(orderManagement.getCreatyTime());// 剩余支付时间
            System.err.println("timeLeft : " + timeLeft);
            if (StringUtils.isBlank(timeLeft)){
                // 设置状态为已取消
                orderManagement.setOrderStatus("3");
                bawOrderManagementMapper.updateBawOrderManagement(orderManagement);
                BawMessageCenterWx bawMessageCenterWx = new BawMessageCenterWx();
                bawMessageCenterWx.setReminderContent("您的订单" + orderManagement.getCarSeriesName() + "已取消！");
                bawMessageCenterWx.setAmount(orderManagement.getPrice());
                bawMessageCenterWx.setUserId(orderManagement.getUserId());
                bawMessageCenterWx.setCraeteTime(new Date());
                bawMessageCenterWx.setName("取消订单！");
                bawMessageCenterWxMapper.insertBawMessageCenterWx(bawMessageCenterWx);
            }

        }

    }
}
