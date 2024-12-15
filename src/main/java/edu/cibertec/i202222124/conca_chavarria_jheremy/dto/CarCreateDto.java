package edu.cibertec.i202222124.conca_chavarria_jheremy.dto;

import java.util.Date;

public record CarCreateDto( String make,
                            String model,
                            Integer year,
                            String vin,
                            String licensePlate,
                            String ownerName,
                            String ownerContact,
                            Date purchaseDate,
                            Integer mileage,
                            String engineType,
                            String color,
                            String insuranceCompany,
                            String insurancePolicyNumber,
                            Date registrationExpirationDate,
                            Date serviceDueDate) {
}
