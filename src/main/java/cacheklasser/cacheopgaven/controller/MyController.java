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
    User user = new User(userId);
    Cache userCache = new Cache();
    int i = 0;


    @GetMapping("/")
    public String test()
    {
        userCache.has(7);
        return "index";
    }

    @GetMapping("/get-user-data")
    @ResponseBody
    public String getUserData(@RequestParam("id") int key)
    {

        boolean keyExistsInMap = userCache.has(key);
        if(keyExistsInMap)
        {
            return userCache.get(key);
        }

        i++;
        userCache.set(key,user.getDataSlow);

        return userCache.get(key);

    }
    /*
    // Det som kommer efter spørgsmålstegnet er en RequestParameter
    // localhost:8080/getUser?name=vibe
    @GetMapping("/getUser")
    public User getUserFromName(@RequestParam("name") String navn){
        System.out.println(navn);
    }

     */

}
