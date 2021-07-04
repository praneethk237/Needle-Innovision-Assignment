package com.innovision.Assignment.controller;

import com.innovision.Assignment.entity.Show;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class MainController {
    @RequestMapping(value="/search",method= RequestMethod.GET)
    //@RequestBody HashMap<String,String> hashMap
    List<Show> getShows()
    {
      return null;
    }


}
