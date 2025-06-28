package by.dima.client.business;

import com.example.grpc.GreetingServiceOuterClass;

public interface GreetingProvider<T> {
    String greeting(T name);
}
