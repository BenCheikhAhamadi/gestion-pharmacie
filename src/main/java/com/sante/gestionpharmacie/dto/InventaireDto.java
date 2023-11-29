package com.sante.gestionpharmacie.dto;

public record InventaireDto(Long id,String prix_vente,Integer stock_detail,Integer stock_initial,Integer stock_restant) {
}
