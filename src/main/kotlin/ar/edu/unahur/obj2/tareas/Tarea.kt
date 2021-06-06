package ar.edu.unahur.obj2.tareas


abstract class Tareas(val responsable: Empleado) {
    abstract fun nomina() : List<Empleado>
    abstract fun horasNecesarias() : Int
    abstract fun costoTotal() : Double
}

class Tarea(val horasEstimadas: Int, val costoDeInfrastructura: Double, responsable: Empleado): Tareas(responsable) {
    val empleados = mutableListOf<Empleado>()

    override fun horasNecesarias() = horasEstimadas / empleados.size

    fun costoDeEmpleados() = empleados.sumByDouble { it.cobroPorHora * horasNecesarias() }
    fun costoDeResponsable() = responsable.cobroPorHora * horasNecesarias()
    override fun costoTotal() = costoDeEmpleados() + costoDeResponsable() + costoDeInfrastructura
    override fun nomina(): List<Empleado> = empleados + responsable

}


class TareaDeIntegracion(responsable: Empleado) : Tareas(responsable) {
    val subTareas = mutableListOf<Tareas>()

    override fun horasNecesarias() = horasTotales() + (horasTotales() / 8)
    fun horasTotales() = subTareas.sumBy { it.horasNecesarias() }

    override fun costoTotal() = costoDeSubTareas() + bonoDeResponsable()
    fun costoDeSubTareas() = subTareas.sumByDouble { it.costoTotal() }
    fun bonoDeResponsable() = costoDeSubTareas() * 0.03

    override fun nomina(): List<Empleado> = subTareas.map { it.nomina() }.flatten()  + responsable
}


class Empleado(val cobroPorHora: Double) {

}
