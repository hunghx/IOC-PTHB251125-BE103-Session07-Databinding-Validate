package re.api;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import re.api.service.MailService;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class DataBindingValidateApplication {
    // Scheduling : lịch trình (đồng bộ)
    // Async : bất đồng bộ
    public static void main(String[] args) {
        SpringApplication.run(DataBindingValidateApplication.class, args);
    }

    @Value("${cloud-name}")
    private String cloudName;
    @Value("${api-key}")
    private String apiKey;
    @Value("${api-secret}")
    private String apiSecret;

    // Bean upload
    @Bean
    public Cloudinary cloudinary(){
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name",cloudName,
                "api_key",apiKey,
                "api_secret",apiSecret,
                "secure", true
        ));
    }

    @Bean
    public CommandLineRunner runner(MailService mailService){
        // chạy đúng lần
        return args -> {
            mailService.sendEmailNormal("hung18061999hung@gmail.com", "Test Mail","Hehehe");
        };
    }
}
