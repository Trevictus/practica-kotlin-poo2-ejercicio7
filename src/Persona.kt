class Persona(val dni: String) {

    val cuentas = arrayOfNulls<Cuenta>(3)
    var cont = 0

//    init {
//        require(cuenta <= 3){"La persona no puede tener mas de tres cucentas."}
//    }

    fun anadirCuenta(cuenta: Cuenta): Boolean {
        if (cont < 3){
            cuentas[cont] = cuenta
            cont ++
            println("Cuenta añadida.")
            return true
        }else{
            println("ERROR. No puede superar las tres cuentas.")
            return false
        }
    }

    fun moroso(): Boolean {
        if(cuentas.any { (it?.consultarSaldo() ?: 0.0) < 0 }){
            println("La persona con DNI $dni tiene deudas pendientes.")
            return true
        }else{
            println("La persona con DNI $dni está excenta de deudas.")
            return false
        }
    }

    fun realizarTransferencia(cuentaOrigen: Int, cuentaDesino: Int, cantidad: Double): Boolean {
        val origen = cuentas[cuentaOrigen]
        val destino = cuentas[cuentaDesino]

        if (origen == null || destino == null){
            println("ERROR.")
            return false
        }
        if (origen.consultarSaldo() < cantidad){
            println("No hay suficiente saldo en $origen.")
            return false
        }
        origen.realizarPago(cantidad)
        destino.recibirAbono(cantidad)
        println("Se han transferido $cantidad€ de la cuenta $cuentaOrigen a la cuenta $cuentaDesino")
        return true

    }

    override fun toString(): String {
        return "Persona con DNI $dni. Moroso: ${moroso()}"
    }
}