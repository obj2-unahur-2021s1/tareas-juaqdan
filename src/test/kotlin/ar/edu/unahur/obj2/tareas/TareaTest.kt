package ar.edu.unahur.obj2.tareas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class TareaTest : DescribeSpec({
  val empleado1 = Empleado(100.0)
  val empleado2 = Empleado(100.0)
  val empleado3 = Empleado(250.0)
  val empleado4 = Empleado(406.0)

  val responsable = Empleado(200.0)
  val responsable2 = Empleado(800.00)

  val tarea1 = Tarea(8, responsable, 3000.0)
  val tarea2 = Tarea( 20, responsable2, 70000.0)

  tarea1.empleados.addAll(listOf(empleado1,empleado2))
  tarea2.empleados.addAll(listOf(empleado1, empleado2, empleado3, empleado4))

  describe("Una tarea") {

    it ("Horas necesarias") {
      tarea1.horasNecesarias().shouldBe(4)
      tarea2.horasNecesarias().shouldBe(5)
    }

    it ("Nomina") {
      tarea1.nomina().shouldBe(listOf(empleado1,empleado2,responsable))
      tarea2.nomina().shouldBe(listOf(empleado1,empleado2,empleado3,empleado4,responsable2))
    }
    it("costo total"){
      tarea1.costoTotal().shouldBe(4600)
      tarea2.costoTotal().shouldBe(78280)
    }
  }
  describe("una tarea de integracion"){


    val tareaIntegracion = TareaDeIntegracion(responsable2)

    tareaIntegracion.subTareas.addAll(listOf(tarea1, tarea2))

    it("horas necesarias"){
      tareaIntegracion.horasNecesarias().shouldBe(10)
    }
    it("costo total"){
      tareaIntegracion.costoTotal().shouldBe(85366.4)
    }
    it("nomina"){
      tarea2.nomina().shouldBe(listOf(empleado1,empleado2,empleado3,empleado4,responsable2))
    }
  }
})
