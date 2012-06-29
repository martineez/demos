package demo;

import javax.ejb.Stateless;

@Stateless
public class GreetingServiceBean {
    public String sayHello(String name) {
        return "Hello " + name + "!";
    }
}