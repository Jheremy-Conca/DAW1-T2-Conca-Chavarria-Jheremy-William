package edu.cibertec.i202222124.conca_chavarria_jheremy.service;

import edu.cibertec.i202222124.conca_chavarria_jheremy.dto.CarCreateDto;
import edu.cibertec.i202222124.conca_chavarria_jheremy.dto.CarDetailDto;
import edu.cibertec.i202222124.conca_chavarria_jheremy.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface ManageService {

    List<CarDto> getAllCars() throws Exception;

    Optional<CarDetailDto> getDetailCar(int id) throws Exception;

    boolean updateCar(CarDto carDto) throws Exception;

    boolean deleteCar(int id) throws Exception;

    boolean createCar(CarCreateDto carCreateDto) throws Exception;

}
