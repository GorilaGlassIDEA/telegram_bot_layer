package by.dima.client.x.config;


import com.example.grpc.GreetingServiceGrpc;
import com.example.grpc.TelegramBotServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@ComponentScan(basePackages = "by.dima.client")
@PropertySource("classpath:application.properties")
public class SpringConfig {
    @Value("${remote.server.port}")
    private String target;

    @Bean
    @Autowired
    GreetingServiceGrpc.GreetingServiceBlockingStub getStubGreetingService(ManagedChannel channel) {
        return GreetingServiceGrpc.newBlockingStub(channel);
    }

    @Bean
    @Autowired
    TelegramBotServiceGrpc.TelegramBotServiceBlockingStub getStubTelegramBotExchangeMessageService(ManagedChannel channel) {
        return TelegramBotServiceGrpc.newBlockingStub(channel);
    }


    @Bean(destroyMethod = "shutdown")
    ManagedChannel getManagedChannel() {
        return ManagedChannelBuilder.forTarget(target)
                .usePlaintext()
                .build();
        //TODO: сделать порт в файле конфигурации
    }


}
