package ar.edu.unahur.obj2.tareas


import java.time.LocalTime

class Tarea(val horasEstimadas: Int, val responsable: Empleado, val costoDeInfrastructura: Double) {
    val empleados = mutableListOf<Empleado>()

    fun horasNecesarias() = horasEstimadas / empleados.size

    fun costoDeEmpleados() = empleados.sumByDouble { it.cobroPorHora * horasNecesarias() }
    fun costoDeResponsable() = responsable.cobroPorHora * horasNecesarias()
    fun costoTotal() = costoDeInfrastructura + costoDeEmpleados() + costoDeResponsable()

    fun nomina() = empleados + responsable
}

class Empleado(val cobroPorHora: Double) {

}
