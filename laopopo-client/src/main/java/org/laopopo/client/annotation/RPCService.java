package org.laopopo.client.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author BazingaLyn
 * @description 服务提供端提供服务的Annotation
 * @time 2016年8月19日
 * @modifytime
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
@Documented
public @interface RPCService {

    /*服务的权重，这个是很必要的，应该每个系统的线上实例肯定不止一台，而每一台实例的性能也不一样，
     有些服务器的性能好一点，内存大一点，可以设置大一点，最大100，最小1，这样在服务端调用该实例的时候，
     默认是使用加权随机负载均衡的算法，去随机访问服务提供端的*/
    public int weight() default 50;							//负载访问权重
	public String serviceName() default "";					//服务名
	public String responsibilityName() default "system";	//负责人名
	public int connCount() default 1;						//单实例连接数，注册中心该参数有效，直连无效
	public boolean isVIPService() default false;			//是否是VIP服务
	public boolean isSupportDegradeService() default false; //是否支持降级
	public String degradeServicePath() default "";			//如果支持降级，降级服务的路径
	public String degradeServiceDesc() default "";			//降级服务的描述
	public boolean isFlowController() default true;		    //是否单位时间限流
	public long maxCallCountInMinute() default 100000;		//单位时间的最大调用量
	
}
