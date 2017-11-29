package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScaleController {

    String cfInstanceIndex;

    public ScaleController(@Value("${CF_INSTANCE_INDEX:NOT SET}") String cfInstanceIndex) {
        this.cfInstanceIndex = cfInstanceIndex;
    }

    @GetMapping("/kill")
    public void kill() {
        System.exit(0);
    }

    @GetMapping("/delay/{seconds}")
    public String delay(@PathVariable int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Done [ Instance : " + cfInstanceIndex + "]";
    }

}
