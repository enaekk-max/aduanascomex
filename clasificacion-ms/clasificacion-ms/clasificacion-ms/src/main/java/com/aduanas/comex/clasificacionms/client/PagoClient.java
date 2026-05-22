package com.aduanas.comex.clasificacionms.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.math.BigDecimal;

@FeignClient(name = "pago-ms", url = "http://localhost:8084")
public interface PagoClient {

    @PostMapping("/api/v1/pagos/crear-orden") // ◄ Ruta estandarizada limpia
    void crearOrdenDePago(
            @RequestParam("cargaId") Long idCarga,
            @RequestParam("monto") BigDecimal monto // ◄ ✅ CORREGIDO: De 'montoAPagar' a 'monto' para evitar RequestParam Mismatch
    );
}