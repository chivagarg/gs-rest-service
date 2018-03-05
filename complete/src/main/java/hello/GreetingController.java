package hello;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

    @RequestMapping("/properties")
    public Properties properties(@RequestParam(value="name", defaultValue="World") String name) {
        List<String> list =  new ArrayList<String>();
        list.add("2 Townsend st, San Francisco");
        list.add("2410 East Lynn st, Seattle");

        return new Properties(counter.incrementAndGet(), list);
    }
}
