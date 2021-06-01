package ar.edu.unahur.obj2.tareas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class TareaTest : DescribeSpec({
  val empleado1 = Empleado(100.0)
  val empleado2 = Empleado(100.0)
  val responsable = Empleado(200.0)

  val tarea1 = Tarea(8, responsable, 3000.0)

  describe("Una tarea") {
    tarea1.empleados.addAll(listOf(empleado1,empleado2))

    it ("Horas necesarias") {
      tarea1.horasNecesarias().shouldBe(4)
    }

    it ("Nomina") {
      tarea1.nomina().shouldBe(listOf(empleado1,empleado2,responsable))
    }
  }
})
