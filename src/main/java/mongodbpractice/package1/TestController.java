package mongodbpractice.package1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
@RestController
@RequestMapping("/hotel")
public class TestController {

    @Autowired
    TestService testService;

    @PostMapping
    public Hotel createHotel(@RequestBody Hotel hotel) {
        return testService.createHotel(hotel);
    }

    @GetMapping
    public List<Hotel> getAllHotels() {
        return testService.getAllHotels();
    }
}
