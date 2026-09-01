package com.kai.redenvelope.controller;

import com.kai.redenvelope.entity.dto.RedpacketDto;
import com.kai.redenvelope.entity.vo.ResponseVO;
import com.kai.redenvelope.enums.StatusCode;
import com.kai.redenvelope.service.IRedPacketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author kai
 * @version 1.0
 * @date 2024/10/14
 * @Description
 */
@RestController
public class RedpacketController {

    public static final Logger log = LoggerFactory.getLogger(RedpacketController.class);

    private static final String prefix = "red/packet";

    @Resource
    private IRedPacketService redPacketService;

    //发红包

    /**
     * BindingResult 用于存放验证 RedpacketDto 对象时产生的所有验证结果，包括：
     * 验证是否成功。
     * 如果验证失败，会包含所有的验证错误信息。
     *
     * @param redpacketDto
     * @param result
     * @return
     */
    @PostMapping(value = prefix + "/hand/out", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseVO handout(@Validated @RequestBody RedpacketDto redpacketDto, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("---------------------");
            return new ResponseVO(StatusCode.InvalidParams);
        }
        ResponseVO responseVO = new ResponseVO(StatusCode.Success);

        try {
            //核心业务逻辑处理服务-最终返回红包全局唯一标识串
            // TODO:全局唯一标识是 list = "red/packet"+userId+":"+时间戳   值为划分后的红包数组 存入redis列表
            // TODO:同时 total = list + ".total" 值为红包总数 存入redis的String
            // TODO：向redis左插入
            String redId = redPacketService.handOut(redpacketDto);

            responseVO.setData(redId);

        } catch (Exception e) {
            log.info("发红包异常：dto={}", redpacketDto, e.fillInStackTrace());
            responseVO = new ResponseVO(StatusCode.Fail.getCode(), e.getMessage());
        }
        return responseVO;

    }

    @GetMapping(value = prefix + "/rob")
    public ResponseVO rob(@RequestParam Integer userId, @RequestParam String redId) {
        ResponseVO responseVO = new ResponseVO(StatusCode.Success);
        try {
            //单位为元，直接传回前端，避免二次处理
            BigDecimal result = redPacketService.rob(userId, redId);
            //判断返回的值是否为空，不为空则抢到了，否则就是抢完了
            if (result != null) {
                responseVO.setData(result);
            } else {
                responseVO = new ResponseVO(StatusCode.Fail.getCode(), "红包已抢完");
            }
        } catch (Exception e) {
            log.error("抢红包发生异常：userId={},redId={}", userId, redId, e.fillInStackTrace());
            responseVO = new ResponseVO(StatusCode.Fail.getCode(), e.getMessage());
        }
        return responseVO;
    }
}
