/**
 * Dado un radio, muestra perimetro, area, superficie y volumen
 * @author Juan Jose Sanz
 * @version 1
 */

const val PI = 3.14159F

fun main() {
    // Entrada del radio
    println("Por favor, introduzca un radio: ")
    var radio = readln().toFloat()

    // Calculos del circulo
    var circumference = 2*PI*radio
    var area = PI*(radio*radio)
    var surface = 4*PI*(radio*radio)
    var volume = (4/3)*PI*(radio*radio*radio)

    // Mostrar resultados
    println("""|Dado el radio: $radio
        |Perimetro: $circumference,
        |Area: $area,
        |Superficie: $surface,
        |Volumen: $volume.
    """.trimMargin())

}