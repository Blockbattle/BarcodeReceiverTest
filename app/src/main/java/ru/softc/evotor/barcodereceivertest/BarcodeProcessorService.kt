package ru.softc.evotor.barcodereceivertest

import android.widget.Toast
import ru.evotor.framework.inventory.ProductType
import ru.evotor.framework.receipt.Measure
import ru.evotor.framework.receipt.Position
import ru.evotor.framework.receipt.formation.event.ReturnPositionsForBarcodeRequestedEvent
import ru.evotor.framework.receipt.formation.event.handler.service.SellIntegrationService
import java.math.BigDecimal

class BarcodeProcessorService : SellIntegrationService() {

    override fun handleEvent(event: ReturnPositionsForBarcodeRequestedEvent): ReturnPositionsForBarcodeRequestedEvent.Result? {
        Toast.makeText(this, "Barcode: " + event.barcode, Toast.LENGTH_SHORT).show()

        val positions = mutableListOf<Position>()

        positions.add(
            Position(
                "abcd1",
                null, null,
                ProductType.NORMAL,
                "Тестовая позиция",
                Measure("шт", 1, 0),
                null,
                BigDecimal(100),
                BigDecimal(100),
                BigDecimal(5),
                event.barcode,
                null, null, null, null, null, null
            )
        )
        return ReturnPositionsForBarcodeRequestedEvent.Result(iCanCreateNewProduct = false, positions, listOf(positions))
    }
}
