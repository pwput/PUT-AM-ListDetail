package pl.pw.listdetail.domain

import pl.pw.listdetail.R

data class Cocktail(val name: String, val ingredients: String, val method: String, val imgResId: Int)

object Cocktails {
    val list = listOf(
        Cocktail(
            "Mojito",
            "juice of 1 lime\n" +
                "1 tsp granulated sugar\n" +
                "small handful mint leaves, plus extra sprig to serve\n" +
                "60ml white rum\n" +
                "soda water, to taste",
            "STEP 1\n" +
                    "Muddle the lime juice, sugar and mint leaves in a small jug, crushing the mint as you go – you can use the end of a rolling pin for this. Pour into a tall glass and add a handful of ice.\n" +
                    "\n" +
                    "STEP 2\n" +
                    "Pour over the rum, stirring with a long-handled spoon. Top up with soda water, garnish with mint and serve.",
            R.drawable.mojito_cocktails

        ),

        Cocktail("Frozen strawberry margarita", "1 tsp sea salt flakes\n" +
                "400g frozen strawberries\n" +
                "120ml tequila\n" +
                "75ml triple sec\n" +
                "1 lime, juiced",
    "STEP 1\n" +
            "Tip the sea salt onto a saucer. Dampen the rims of two margarita glasses, then turn the glass upside down in the salt and twist to coat the rim.\n" +
            "\n" +
            "STEP 2\n" +
            "Add all remaining ingredients to a blender and blitz until smooth. Pour into glasses and serve immediately.",
    R.drawable.strawberry_marg),

        Cocktail("Sex on the beach", "ice\n" +
                "50ml vodka\n" +
                "25ml peach schnapps\n" +
                "2 oranges, juiced, plus 2 slices to garnish\n" +
                "50ml cranberry juice\n" +
                "glacé cherries, to garnish (optional)","STEP 1\n" +
                "Fill two tall glasses with ice cubes. Pour the vodka, peach schnapps and fruit juices into a large jug and stir.\n" +
                "\n" +
                "STEP 2\n" +
                "Divide the mixture between the two glasses and stir gently to combine. Garnish with the cocktail cherries and orange slices.",
        R.drawable.sex_on_the_beach),
        Cocktail("Espresso martini","100g golden caster sugar\n" +
                "For the cocktail\n" +
                "ice\n" +
                "100ml vodka\n" +
                "50ml freshly brewed espresso coffee\n" +
                "50ml coffee liqueur (we used Kahlua)\n" +
                "4 coffee beans (optional)","STEP 1\n" +
                "Start by making the sugar syrup. Put the caster sugar in a small pan over a medium heat and pour in 50ml water. Stir, and bring to the boil.\n" +
                "\n" +
                "STEP 2\n" +
                "Turn off the heat and allow the mixture to cool. Put 2 martini glasses in the fridge to chill.\n" +
                "\n" +
                "STEP 3\n" +
                "Once the sugar syrup is cold, pour 1 tbsp into a cocktail shaker along with a handful of ice, the vodka, espresso and coffee liqueur. Shake until the outside of the cocktail shaker feels icy cold.\n" +
                "\n" +
                "STEP 4\n" +
                "Strain into the chilled glasses. Garnish each one with coffee beans if you like", R.drawable.espresso_martini),
        Cocktail("Aperol spritz","ice\n" +
                "100ml Aperol\n" +
                "150ml prosecco\n" +
                "soda, to top up","STEP 1\n" +
                "Put a couple of cubes of ice into 2 glasses and add a 50 ml measure of Aperol to each. Divide the prosecco between the glasses and then top up with soda, if you like.", R.drawable.aperol_spritz),
        Cocktail("Easy sangria","2 oranges, chopped\n" +
                "2 pears, chopped\n" +
                "2 lemons, 1 chopped, 1 juiced\n" +
                "200g red berries, chopped (we used strawberries and cherries)\n" +
                "3 tbsp caster sugar\n" +
                "1 tsp cinnamon\n" +
                "ice\n" +
                "750ml bottle light red wine\n" +
                "100ml Spanish brandy\n" +
                "300ml sparkling water","STEP 1\n" +
                "Put the chopped fruit in a bowl and sprinkle over the sugar and cinnamon, then stir to coat. Cover and leave to macerate in the fridge for at least 1 hr, or ideally overnight.\n" +
                "\n" +
                "STEP 2\n" +
                "Fill a large jug with ice. Stir the macerated fruit mixture to ensure the sugar is dissolved, then tip into the jug with the wine and brandy. Stir, then top up with the sparkling water and serve.", R.drawable.sangria_new_crop),
        Cocktail("Singapore sling","25ml dry gin\n" +
                "25ml cherry brandy\n" +
                "25ml Benedictine\n" +
                "handful of ice, to serve\n" +
                "few drops Angostura bitters\n" +
                "50ml pineapple juice\n" +
                "25ml lime juice\n" +
                "sparkling water to top up\n" +
                "For the garnish\n" +
                "1 thin slice of fresh pineapple (optional)\n" +
                "cocktail cherry","STEP 1\n" +
                "Pour the gin, cherry brandy and Benedictine into a mixing glass or a jug. Add the ice and Angostura bitters. Stir well until the outside of the glass feels cold.\n" +
                "\n" +
                "STEP 2\n" +
                "Pour the mix into a tall glass, then add the pineapple juice and lime juice and stir gently. Top up with sparkling water and garnish.", R.drawable.mojito_cocktails),
        Cocktail("Vodka martini","60ml vodka\n" +
                "1 tbsp dry vermouth\n" +
                "olive or lemon peel, to garnish","STEP 1\n" +
                "Stir the vodka, dry vermouth and a little ice together or put them in a cocktail shaker to combine.\n" +
                "\n" +
                "STEP 2\n" +
                "Strain into a chilled martini glass. Serve with an olive on a cocktail stick or a twist of lemon peel.", R.drawable.vodka_martini),
        Cocktail("Mudslide","50g dark chocolate\n" +
                "ice\n" +
                "60ml coffee-flavoured liqueur\n" +
                "60ml vodka\n" +
                "60ml Irish cream liqueur\n" +
                "100ml double cream","STEP 1\n" +
                "Put two small tumblers in the fridge to chill overnight. Put 30g of the chocolate in a shallow bowl and melt in the microwave in short bursts. Dip the rim of the chilled glasses in the melted chocolate, then stand them upright so it gradually drips down the sides. Return to the fridge until you're ready to serve.\n" +
                "\n" +
                "STEP 2\n" +
                "Fill a cocktail shaker with ice, then pour in the coffee-flavoured liqueur, vodka, Irish cream liqueur and double cream. Shake until the outside of the shaker is very cold.\n" +
                "\n" +
                "STEP 3\n" +
                "Put a few ice cubes in the prepared glasses, then strain in the cocktail. Finely grate over the remaining chocolate and serve with a paper straw.", R.drawable.mudslide),
        Cocktail("Palomezcal","lime juice (optional)\n" +
                "50ml espadin mezcal\n" +
                "30ml fresh grapefruit juice\n" +
                "10ml agave syrup\n" +
                "ice\n" +
                "soda water","STEP 1\n" +
                "If you're choosing to salt the rim of your glass like a classic margarita, dip the rim in a saucer of lime juice, followed by a saucer of sea salt.\n" +
                "\n" +
                "STEP 2\n" +
                "Put all the ingredients except the soda water into a cocktail shaker, fill with ice and give it a good shake.\n" +
                "\n" +
                "STEP 3\n" +
                "Strain into a tall collins glass over fresh ice and top with soda water and a slice of grapefruit to garnish.", R.drawable.palomezcal),
        Cocktail("Hurricane ","50ml dark rum\n" +
                "50ml white rum\n" +
                "1 passion fruit\n" +
                "1 orange, juiced\n" +
                "1 lemon, juiced\n" +
                "50ml sugar syrup\n" +
                "2 tsp grenadine","STEP 1\n" +
                "Fill a cocktail shaker with ice then add the rums. Scoop the flesh and seeds from the passion fruit and add to the shaker along with the orange and lemon juices, sugar syrup and grenadine.\n" +
                "\n" +
                "STEP 2\n" +
                "Shake well until the outside of the cocktail shaker feels icy cold. Fill two hurricane glasses with fresh ice then double strain the drink into the prepared glasses.\n" +
                "\n" +
                "STEP 3\n" +
                "Garnish each one with an orange slice skewered onto a cocktail stick and a couple of cocktail cherries.", R.drawable.hurricane),
        Cocktail("Limoncello mojito","1 lemon, juiced\n" +
                "1 tbsp golden caster sugar\n" +
                "small handful of mint, leaves picked\n" +
                "100ml white rum\n" +
                "100ml limoncello\n" +
                "ice\n" +
                "300ml soda water","STEP 1\n" +
                "Put the lemon juice, sugar and half the mint leaves in a cocktail shaker. Bash with a cocktail muddler or the end of a rolling pin until the sugar has dissolved.\n" +
                "\n" +
                "STEP 2\n" +
                "Pour the rum and limoncello into the shaker and add a handful of ice. Cover with the lid and shake until the outside of\n" +
                "the shaker feels cold.\n" +
                "\n" +
                "STEP 3\n" +
                "Fill two tall glasses with ice, then strain in the cocktail and top up with the soda water. Garnish with the remaining mint leaves to serve.", R.drawable.limoncello_mojito),
        Cocktail("Pink negroni","35ml pink gin\n" +
                "25ml rose vermouth, or sweet white vermouth\n" +
                "15ml Aperol\n" +
                "ice\n" +
                "wedge of pink grapefruit and a basil leaf, to garnish","STEP 1\n" +
                "Combine the pink gin, vermouth and Aperol in a tumbler with a small handful of ice. Stir until the outside of the glass feels cold.\n" +
                "\n" +
                "STEP 2\n" +
                "Garnish with a wedge of pink grapefruit and a basil leaf.", R.drawable.classic_negroni),
    )
}
