package pl.pw.listdetail.domain

data class Cocktail(val name: String, val recipe: String)

object Coctails {
    val list = arrayOf(
        Cocktail(
            "Bloody Mary",
            "Składniki: \n 40 ml wódki \n 10 ml soku z cytryny \n 120 ml soku pomidorowego \n sos worchestershire \n sól \n pieprz \n tabasco \n gałązka selera naciowego \n\n Sposób przygotowania: n Wszystkie składniki            wymieszać w szklance z lodem i ozdobić selerem naciowym.",
        ),
        Cocktail("nazwa2", "przepis2"),
        Cocktail("nazwa3", "przepis3"),
    )
}
