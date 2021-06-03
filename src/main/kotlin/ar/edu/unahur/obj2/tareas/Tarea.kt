package ar.edu.unahur.obj2.tareas


import java.time.LocalTime

open class Tarea(val horasEstimadas: Int, val responsable: Empleado, val costoDeInfrastructura: Double) {
    val empleados = mutableListOf<Empleado>()

    open fun horasNecesarias() = horasEstimadas / empleados.size

    open fun costoDeEmpleados() = empleados.sumByDouble { it.cobroPorHora * horasNecesarias() }
    open fun costoDeResponsable() = responsable.cobroPorHora * horasNecesarias()
    open fun costoTotal() = costoDeEmpleados() + costoDeResponsable() + costoDeInfrastructura


    open fun empleados() = empleados
    open fun nomina() = empleados() + responsable

}

class TareaDeIntegracion(responsable: Empleado):Tarea(0, responsable, 0.0){
    val subTareas = mutableListOf<Tarea>()

    override fun horasNecesarias() = totalHorasDeSubTareas() + horaPorCada8Horas()

    fun horaPorCada8Horas() = (totalHorasDeSubTareas() / 8).toInt()

    fun totalHorasDeSubTareas() = subTareas.sumBy { it.horasNecesarias() }

    override fun costoDeEmpleados() = subTareas.sumByDouble { it.costoTotal() }

    override fun costoDeResponsable() = costoDeEmpleados() * 0.03

    //override fun empleados() = subTareas.map { it.nomina() }.flatten()
}

class Empleado(val cobroPorHora: Double) {

}
