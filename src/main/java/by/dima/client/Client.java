package by.dima.client;

import com.example.grpc.GreetingServiceGrpc;
import com.example.grpc.GreetingServiceOuterClass;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


public class Client {
    public static void main(String[] args) {

        ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8080")
                .usePlaintext()
                .build();
        GreetingServiceGrpc.GreetingServiceBlockingStub stub = GreetingServiceGrpc.newBlockingStub(channel);

        GreetingServiceOuterClass.HelloRequest helloRequest = GreetingServiceOuterClass.HelloRequest.newBuilder()
                .setName("Dimka")
                .build();

        GreetingServiceOuterClass.HelloResponse helloResponse = stub.greeting(helloRequest);
        System.out.println(helloResponse);

        channel.shutdownNow();
    }
}
