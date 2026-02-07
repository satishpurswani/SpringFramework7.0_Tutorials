package learn.gog.newspring.versioned.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionedController {

    @GetMapping(value = "/versioning")
    public String tryVersioning(){
        return "version 0";
    }

    @GetMapping(value = "/versioning", version = "1")
    public String tryVersioningWithVersionOne(){
        return "version 1";
    }

    @GetMapping(value = "/versioning", version = "2.1.1")
    public String tryVersioningWithVersionTwo(){
        return "version 2";
    }

}
