package ar.edu.unahur.obj2.tareas


import java.time.LocalTime

class Tarea(val horasEstimadas: Int, val responsable: Empleado, val costoDeInfrastructura: Double) {
    val empleados = mutableListOf<Empleado>()

    fun horasNecesarias() = horasEstimadas / empleados.size

    fun costoDeEmpleados() = empleados.sumByDouble { it.cobroPorHora * horasNecesarias() }
    fun costoDeResponsable() = responsable.cobroPorHora * horasNecesarias()
    fun costoTotal() = costoDeEmpleados() + costoDeResponsable() + costoDeInfrastructura

    fun nomina() = empleados + responsable//toSet()

}

class TareaDeIntegracion(val responsable: Empleado){
    val subTareas = mutableListOf<Tarea>()

    fun horasNecesarias() = totalHorasDeSubTareas() + horaPorCada8Horas()

    fun horaPorCada8Horas() = (totalHorasDeSubTareas() / 8).toInt()

    fun totalHorasDeSubTareas() = subTareas.sumBy { it.horasNecesarias() }

    fun costoTotal() = costoTotalDeSubtareas() + bonusDelResponsable()

    fun costoTotalDeSubtareas() = subTareas.sumByDouble { it.costoTotal() }

    fun bonusDelResponsable() = costoTotalDeSubtareas() * 0.03

    fun nomina() = nominasDeSubTareas() + responsable//.toSet()

    fun nominasDeSubTareas() = subTareas.map { it.nomina() }
}

class Empleado(val cobroPorHora: Double) {

}
