package mongodbpractice.package1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
@Service
public class TestService {

    @Autowired
    TestRepository testRepository;

    public Hotel createHotel(Hotel hotel) {
        return (Hotel) testRepository.save(hotel);
    }

    public List<Hotel> getAllHotels() {
        List<Hotel> hotels =  testRepository.findAll();
        return hotels;
    }
}
