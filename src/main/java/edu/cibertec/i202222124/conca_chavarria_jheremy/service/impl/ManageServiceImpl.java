package edu.cibertec.i202222124.conca_chavarria_jheremy.service.impl;

import edu.cibertec.i202222124.conca_chavarria_jheremy.dto.CarCreateDto;
import edu.cibertec.i202222124.conca_chavarria_jheremy.dto.CarDetailDto;
import edu.cibertec.i202222124.conca_chavarria_jheremy.dto.CarDto;
import edu.cibertec.i202222124.conca_chavarria_jheremy.entity.Car;
import edu.cibertec.i202222124.conca_chavarria_jheremy.repository.CarRepository;
import edu.cibertec.i202222124.conca_chavarria_jheremy.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    CarRepository carRepository;



    @Override
    public List<CarDto> getAllCars() throws Exception {

        List<CarDto> cars = new ArrayList<CarDto>();
        Iterable<Car> iterable = carRepository.findAll();
        iterable.forEach(car -> {
            cars.add(new CarDto(car.getCarId(),
                    car.getOwnerName(),
                    car.getOwnerContact(),
                    car.getColor(),
                    car.getMileage(),
                    car.getInsuranceCompany(),
                    car.getInsurancePolicyNumber()));
        });
        return cars;

    }

    @Override
    public Optional<CarDetailDto> getDetailCar(int id) throws Exception {

        Optional<Car> optional = carRepository.findById(id);
        return optional.map(car -> new CarDetailDto(car.getCarId(),
                car.getMake(),
                car.getModel(),
                car.getYear(),
                car.getVin(),
                car.getLicensePlate(),
                car.getOwnerName(),
                car.getOwnerContact(),
                car.getPurchaseDate(),
                car.getMileage(),
                car.getEngineType(),
                car.getColor(),
                car.getInsuranceCompany(),
                car.getInsurancePolicyNumber(),
                car.getRegistrationExpirationDate(),
                car.getServiceDueDate()));

    }

    @Override
    public boolean updateCar(CarDto carDto) throws Exception {
        Optional<Car> optional = carRepository.findById(carDto.carId());
        return optional.map(car -> {
            car.setOwnerName(carDto.ownerName());
            car.setOwnerContact(carDto.ownerContact());
            car.setColor(carDto.color());
            car.setMileage(carDto.mileage());
            car.setInsuranceCompany(carDto.insuranceCompany());
            car.setInsurancePolicyNumber(carDto.insurancePolicyNumber());
            carRepository.save(car);
            return true;
        }).orElse(false);

    }

    @Override
    public boolean deleteCar(int id) throws Exception {
        Optional<Car> optional = carRepository.findById(id);
        return optional.map(car -> {
            carRepository.delete(car);
            return true;
        }).orElse(false);

    }

    @Override
    public boolean createCar(CarCreateDto carCreateDto) throws Exception {
        Car user = new Car();
        user.setMake(carCreateDto.make());
        user.setModel(carCreateDto.model());
        user.setYear(carCreateDto.year());
        user.setVin(carCreateDto.vin());
        user.setLicensePlate(carCreateDto.licensePlate());
        user.setOwnerName(carCreateDto.ownerName());
        user.setOwnerContact(carCreateDto.ownerContact());
        user.setPurchaseDate(new Date());
        user.setMileage(carCreateDto.mileage());
        user.setEngineType(carCreateDto.engineType());
        user.setColor(carCreateDto.color());
        user.setInsuranceCompany(carCreateDto.insuranceCompany());
        user.setInsurancePolicyNumber(carCreateDto.insurancePolicyNumber());
        user.setRegistrationExpirationDate(new Date());
        user.setServiceDueDate(new Date());
        carRepository.save(user);
        return true;

    }
}
