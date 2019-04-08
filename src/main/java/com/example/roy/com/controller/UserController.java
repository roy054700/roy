package com.example.roy.com.controller;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.StringUtils;
import com.example.roy.com.common.ReturnMessage;
import com.example.roy.com.model.Goods;
import com.example.roy.com.model.Orders;
import com.example.roy.com.model.User;
import com.example.roy.com.service.GoodsService;
import com.example.roy.com.service.OrderService;
import com.example.roy.com.service.UserService;
import com.example.roy.com.util.Constants.RedisKeyPrefix;
import com.example.roy.com.util.jedis.JedisCluster;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private JedisCluster jedisCluster;
	//商品售完标记map，多线程操作不能用HashMap
	private static ConcurrentHashMap<String, Boolean> concurrentHashMap = new ConcurrentHashMap<>();
	
	public static ConcurrentHashMap getConcurrentHashMap() {
		return concurrentHashMap;
	}
	
	@PostConstruct
	public void init() {
		List<Goods> list =goodsService.selectList();
		for(Goods g:list) {
			jedisCluster.set(RedisKeyPrefix.PRODUCT_STOCK+"_"+g.getId(), g.getStock()+"");
		}
	}
	
	public ReturnMessage addOrder(String productId,String productNum) {
		if(StringUtils.isEmpty(productId)){
			return ReturnMessage.error("商品id参数为空");
		}
		//用内存里的商品库存校验可以大大提高性能，相比用redis里的库存来判断减少了与redis的交互次数
		if(concurrentHashMap.get(productId)== null) {
			return ReturnMessage.error("商品售完为空");
		}
		//是否存在订单
		if(jedisCluster.get(RedisKeyPrefix.MIAOSHA_ORDER+productId) != null) {
			return ReturnMessage.error("用户已经参与过该商品的秒杀活动，不能重复参与");
		}
		
		
		return confirmOrder( productId, productNum);
	}
	public ReturnMessage confirmOrder(String productId,String productNum){
		//封装订单信息
		Orders order = new Orders();
		try {
			
			orderService.insert(order);
		}catch(Exception e) {
			//创建订单失败
			return ReturnMessage.error("创建订单失败", e.getMessage());
		}
		
		return ReturnMessage.success(0);
	}
	
	/**
	 * 预减库存
	 * @return
	 */
	public ReturnMessage deductStockCache(String productId) {
		Long l =jedisCluster.decr(RedisKeyPrefix.PRODUCT_STOCK+"_"+productId);
		if(l<0) {
			jedisCluster.incr(RedisKeyPrefix.PRODUCT_STOCK+"_"+productId);
			concurrentHashMap.put(productId, true);
			
		}
		
		return ReturnMessage.success(0);
	}
	@RequestMapping("/hello")  
    public String index() {  
         return"Hello World";  
    } 
	 
	 /**
	  * 获取数据
	  * @param user
	  * @return
	  */
	 @RequestMapping("/get")  
	 @ResponseBody
    public String get(User user) {  
		String id = jedisCluster.get(user.getId());
		 if(id== null) {
			 User u=userService.getNameById(user);
			 jedisCluster.set(user.getId(), u.toString());
			
			 return u.toString();
		 }
        return id;     
    }
	 

	 /**
	  * 添加用户
	  * @param user
	  * @return
	  */
	 @RequestMapping("/add")  
	 @ResponseBody
    public Integer add(User user) {  
		 Integer u=userService.addUser(user);
		 
        return u;     
    }
}
