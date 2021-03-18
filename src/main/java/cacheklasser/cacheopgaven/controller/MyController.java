package cacheklasser.cacheopgaven.controller;

import cacheklasser.cacheopgaven.model.Cache;
import cacheklasser.cacheopgaven.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController
{
    Cache userCache = new Cache();

    @GetMapping("/")
    public String test()
    {
        userCache.has(7);
        return "index";
    }

    @GetMapping("/get-user-data")
    @ResponseBody
    public String getUserData(@RequestParam("id") int key) throws InterruptedException
    {
        User user = new User(key);
        boolean keyExistsInMap = userCache.has(key);
        if(keyExistsInMap)
        {
            return userCache.get(key);
        }

        userCache.set(key, user.getDataSlow());
        return userCache.get(key);
    }
}

/*
// Det som kommer efter spørgsmålstegnet er en RequestParameter
// localhost:8080/getUser?name=vibe
@GetMapping("/getUser")
public User getUserFromName(@RequestParam("name") String navn){
    System.out.println(navn);
}
*/