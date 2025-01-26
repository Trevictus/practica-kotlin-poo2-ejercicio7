fun main(){
    val persona1 = Persona("12345678W")
    val cuenta1 = Cuenta(234567, 0.0)

    val cuenta2 = Cuenta(134568, 700.0)

    persona1.anadirCuenta(cuenta1)
    persona1.anadirCuenta(cuenta2)

    cuenta1.recibirAbono(1100.0)
    cuenta2.realizarPago(750.0)//true

    persona1.moroso()

    persona1.realizarTransferencia(0, 1, 500.0)

    println(persona1)




}