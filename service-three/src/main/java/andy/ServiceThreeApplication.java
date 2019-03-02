package andy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: andyfu
 * @Date: 2019/1/1 15:27
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class ServiceThreeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceThreeApplication.class, args);
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("/three")
    public String home(@RequestParam(value = "name", defaultValue = "andy") String name) {
        return "hi " + name + " ,i am from application service-three and port:" + port;
    }

}
