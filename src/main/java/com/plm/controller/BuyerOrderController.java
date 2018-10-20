package com.plm.controller;

import com.plm.converter.OrderFormToOrderDTOConverter;
import com.plm.dto.OrderDTO;
import com.plm.enums.ResultEnum;
import com.plm.exception.SellException;
import com.plm.form.OrderForm;
import com.plm.service.BuyerService;
import com.plm.service.OrderService;
import com.plm.utils.ResultVOUtil;
import com.plm.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * chenwenhua
 * 2018\10\20 0020
 * 12:14
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {
    @Resource
    private OrderService orderService;

    @Resource
    private BuyerService buyerService;

    /**
     * 创建订单
     * @param orderForm 表单传值
     * @param bindingResult
     * @return
     */
    @PostMapping("/create")
    public ResultVO<Map<String,String>> create(@Valid OrderForm orderForm,
                                               BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("[创建订单]参数不正确，orderForm={}",orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = OrderFormToOrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("[创建定单]购物车不能为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        OrderDTO createResult = orderService.create(orderDTO);
        Map<String,String> map = new HashMap<>();
        map.put("orderId",createResult.getOrderId());
        return ResultVOUtil.success(map);

    }

    /**
     * 订单列表
     * @param openid
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/list")
    public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                         @RequestParam(value = "page", defaultValue = "0") Integer page,
                                         @RequestParam(value = "size", defaultValue = "10") Integer size) {
        if (StringUtils.isEmpty(openid)) {
            log.error("【查询订单列表】openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        PageRequest request = PageRequest.of(page, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openid, request);

        return ResultVOUtil.success(orderDTOPage.getContent());
    }

    /**
     * 订单详情
     * @param openid
     * @param orderId
     * @return
     */
    @GetMapping("/detail")
    public ResultVO<OrderDTO> detail(@RequestParam String openid,
                                     @RequestParam String orderId){
        OrderDTO orderDTO = buyerService.findOrderOne(openid, orderId);
        return ResultVOUtil.success(orderDTO);
    }

    /**
     * 取消订单
     * @param openid
     * @param orderId
     * @return
     */
    @GetMapping("/cancel")
    public ResultVO<OrderDTO> cancel(@RequestParam String openid,
                                     @RequestParam String orderId){
        buyerService.cancelOrder(openid, orderId);
        return ResultVOUtil.success();
    }


}
