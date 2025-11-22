package config;

import org.springframework.stereotype.Component;

@Component // marks this class as a component so that spring can managed it
public class ManagedComponent {
    public void doManage() {
    	System.out.println("managing the component");
    }
}
