class Cuenta(private val numeroCuenta: Int, var saldoDisponible: Double) {

    fun consultarSaldo() = saldoDisponible

    fun recibirAbono(cantidad: Double): String {
        saldoDisponible += cantidad
        return "Actualizado el saldo disponible. Quedan: $saldoDisponible€ en la cuenta $numeroCuenta."
    }

    fun realizarPago(cantidad: Double): Boolean {
        if (saldoDisponible >= cantidad){
            saldoDisponible -= cantidad
            println("Actualizado el saldo disponible. Quedan: $saldoDisponible€ en la cuenta $numeroCuenta.")
            return true
        }else {
            println("No puedes realizar el pago. $saldoDisponible€ es lo disponible en la cuenta $numeroCuenta.")
            return false
        }
    }
}