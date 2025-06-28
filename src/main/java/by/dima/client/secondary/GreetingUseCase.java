package by.dima.client.secondary;

import by.dima.client.business.GreetingProvider;
import com.example.grpc.GreetingServiceGrpc;
import com.example.grpc.GreetingServiceOuterClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GreetingUseCase implements GreetingProvider<GreetingServiceOuterClass.HelloRequest> {

    private final GreetingServiceGrpc.GreetingServiceBlockingStub stub;

    @Autowired
    public GreetingUseCase(GreetingServiceGrpc.GreetingServiceBlockingStub stub) {
        this.stub = stub;

    }

    @Override
    public String greeting(GreetingServiceOuterClass.HelloRequest helloRequest) {
        return stub.greeting(helloRequest).getGreeting();
    }
}
