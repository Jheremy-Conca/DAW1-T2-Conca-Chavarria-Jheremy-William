package edu.cibertec.i202222124.conca_chavarria_jheremy.response;


import edu.cibertec.i202222124.conca_chavarria_jheremy.dto.CarDetailDto;

public record GetDetailCarResponse(String code,
                                   String error,
                                   CarDetailDto carDetailDto) {

}