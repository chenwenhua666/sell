package com.plm.converter;

import com.plm.dataobject.OrderMaster;
import com.plm.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * chenwenhua
 * 2018\10\20 0020
 * 10:41
 */
public class OrderMasterToOrderDTOConverter {

    public static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){
       return orderMasterList.stream().map(e -> convert(e)).collect(Collectors.toList());
    }

}
