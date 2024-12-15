package edu.cibertec.i202222124.conca_chavarria_jheremy.api;

import edu.cibertec.i202222124.conca_chavarria_jheremy.dto.CarCreateDto;
import edu.cibertec.i202222124.conca_chavarria_jheremy.dto.CarDetailDto;
import edu.cibertec.i202222124.conca_chavarria_jheremy.dto.CarDto;
import edu.cibertec.i202222124.conca_chavarria_jheremy.response.*;
import edu.cibertec.i202222124.conca_chavarria_jheremy.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cars")
public class ManageUserApi {

    @Autowired
    ManageService manageService;

    @GetMapping("/all")
    public GetAllCarsResponse getAllUsers() {

        try {
            List<CarDto> users = manageService.getAllCars();
            if (!users.isEmpty())
                return new GetAllCarsResponse("01", null, users);
            else
                return new GetAllCarsResponse("02", "Cars not found", null);

        } catch (Exception e) {
            e.printStackTrace();
            return new GetAllCarsResponse("99", "An error occurred, please try again", null);

        }

    }

    @GetMapping("/detail")
        public GetDetailCarResponse getDetailUser(@RequestParam(value = "id", defaultValue = "0") String id) {

        try {
            Optional<CarDetailDto> optional = manageService.getDetailCar(Integer.parseInt(id));
            return optional.map(user ->
                    new GetDetailCarResponse("01", null, user)
            ).orElse(
                    new GetDetailCarResponse("02", "Car not found", null)
            );

        } catch (Exception e) {
            e.printStackTrace();
            return new GetDetailCarResponse("99", "An error occurred, please try again", null);

        }

    }

    @PutMapping("/update")
    public UpdateCarResponse updateUser(@RequestBody CarDto userDto) {

        try {
            if (manageService.updateCar(userDto))
                return new UpdateCarResponse("01", null);
            else
                return new UpdateCarResponse("02", "Update failed");

        } catch (Exception e) {
            e.printStackTrace();
            return new UpdateCarResponse("99", "An error occurred, please try again");

        }

    }

    @DeleteMapping("/delete/{id}")
    public DeleteCarResponse deleteCar(@PathVariable String id) {

        try {
            if (manageService.deleteCar(Integer.parseInt(id)))
                return new DeleteCarResponse("01", null);
            else
                return new DeleteCarResponse("02", "Delete failed");

        } catch (Exception e) {
            e.printStackTrace();
            return new DeleteCarResponse("99", "An error occurred, please try again");

        }

    }

    @PostMapping("/create")
    public CreateCarResponse createCar(@RequestBody CarCreateDto carCreateDto) {

        try {
            if (manageService.createCar(carCreateDto))
                return new CreateCarResponse("01", null);
            else
                return new CreateCarResponse("02", "Create failed");

        } catch (Exception e) {
            e.printStackTrace();
            return new CreateCarResponse("99", "An error occurred, please try again");

        }

    }


}
