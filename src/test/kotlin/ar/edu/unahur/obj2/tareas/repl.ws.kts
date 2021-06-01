import ar.edu.unahur.obj2.tareas.Empleado
import ar.edu.unahur.obj2.tareas.Tarea

val empleado1 = Empleado(200.0)
val responsable = Empleado(300.0)

val tarea1 = Tarea(8, responsable, 3000.0)
tarea1.empleados.add(empleado1)
tarea1.nomina()
tarea1.costoTotal()
tarea1.costoDeEmpleados()