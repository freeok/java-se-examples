package org.pcdd.javase.tutorial.chapter17_反射机制;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Car {
    void driver(String driverName, String carName);
}

/**
 * JDK动态代理
 *
 * @author pcdd
 * date 2021/6/17 16:07
 */
public class CodeTest {
    public static void main(String[] args) {
        Car car = (Car) Proxy.newProxyInstance(Car.class.getClassLoader()
                , new Class<?>[]{Car.class}
                , new CarHandler(new MyCar()));
        car.driver("pcdd", "凯迪拉克");

        System.out.println(car.getClass().getName());
    }
}

class MyCar implements Car {
    @Override
    public void driver(String driverName, String carName) {
        System.out.println("MyCar is driving... " + "driverName: " + driverName +
                ", carName:" + carName);
    }
}

class CarHandler implements InvocationHandler {
    private Car car;

    public CarHandler(Car car) {
        this.car = car;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("driver before");
        Object invoke = method.invoke(car, args);
        System.out.println("driver after");
        return invoke;
    }


}



