package com.example.proxy;

import java.lang.reflect.Proxy;

public class ClientMain {
    public static void main(String[] args) {
        IBlindDate blindDate = new BlindDate();
        DateAgency<BlindDate> dateAgency = new DateAgency(blindDate);
        IBlindDate proxy = (IBlindDate) Proxy.newProxyInstance(BlindDate.class.getClassLoader(), BlindDate.class.getInterfaces(), dateAgency);
        proxy.doDate();
    }
}
