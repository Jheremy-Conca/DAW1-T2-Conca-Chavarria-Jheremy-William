package edu.cibertec.i202222124.conca_chavarria_jheremy.response;

import edu.cibertec.i202222124.conca_chavarria_jheremy.dto.CarDto;

import java.util.List;

public record GetAllCarsResponse(String code,
                                  String error,
                                  List<CarDto> cars) {

}