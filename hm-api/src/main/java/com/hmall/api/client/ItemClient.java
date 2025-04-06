package com.hmall.api.client;

/**
 * @author luochao
 * @date 2025/4/6 1:08
 */

import com.hmall.api.dto.ItemDTO;
import com.hmall.api.dto.OrderDetailDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

//现在，任何微服务要调用item-service中的接口，
//只需要引入hm-api模块依赖即可，无需自己编写Feign客户端了。

@FeignClient("item-service")
public interface ItemClient {

    @GetMapping("/items")
    List<ItemDTO> queryItemByIds(@RequestParam("ids") Collection<Long> ids);


    @PutMapping("/items/stock/deduct")
    void deductStock(@RequestBody List<OrderDetailDTO> items);
}
