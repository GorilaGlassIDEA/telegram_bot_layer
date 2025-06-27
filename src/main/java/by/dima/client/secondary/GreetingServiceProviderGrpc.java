package by.dima.client.secondary;

import by.dima.client.business.GreetingProvider;
import com.example.grpc.GreetingServiceGrpc;
import com.example.grpc.GreetingServiceOuterClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GreetingServiceProviderGrpc implements GreetingProvider {

    private final GreetingServiceGrpc.GreetingServiceBlockingStub stub;

    @Autowired
    public GreetingServiceProviderGrpc(GreetingServiceGrpc.GreetingServiceBlockingStub stub) {
        this.stub = stub;

    }

    @Override
    public String greeting(String name) {
        GreetingServiceOuterClass.HelloRequest helloRequest = GreetingServiceOuterClass.HelloRequest.newBuilder()
                .setName(name)
                .build();
        return stub.greeting(helloRequest).getGreeting();
    }
}
