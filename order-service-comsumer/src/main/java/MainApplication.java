import com.wuyu.dubbo.service.OrderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;


public class MainApplication {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		System.out.println("UserService------------"+1);
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("consumer.xml");
		
		OrderService orderService = applicationContext.getBean(OrderService.class);
		
		orderService.initOrder("1");
		System.out.println("调用完成....");
		System.in.read();
	}

}
