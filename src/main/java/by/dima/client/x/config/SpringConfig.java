package by.dima.client.x.config;


import com.example.grpc.GreetingServiceGrpc;
import com.example.grpc.TelegramBotServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = "by.dima.client")
public class SpringConfig {


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
        return ManagedChannelBuilder.forTarget("localhost:8080")
                .usePlaintext()
                .build();
        //TODO: сделать порт в файле конфигурации
    }


}
