package com.tenyitamas.customviews

data class ColorObject(
    val name: String,
    val hex: String,
    val contrastHex: String
) {
    companion object {
        private val blackHex = "000000"
        private val whiteHex = "FFFFFF"

        val basicColors = listOf<ColorObject>(
            ColorObject("Black", blackHex, whiteHex),
            ColorObject("Silver", "C0C0C0", blackHex),
            ColorObject("Gray", "808080", whiteHex),
            ColorObject("Maroon", "800000", whiteHex),
            ColorObject("Red", "FF0000", whiteHex),
            ColorObject("Fuchsia", "FF00FF", whiteHex),
            ColorObject("Green", "008000", whiteHex),
            ColorObject("Lime", "00FF00", blackHex),
            ColorObject("Olive", "808000", whiteHex),
            ColorObject("Yellow", "FFFF00", blackHex),
            ColorObject("Navy", "000080", whiteHex),
            ColorObject("Blue", "0000FF", whiteHex),
            ColorObject("Teal", "008080", whiteHex),
            ColorObject("Aqua", "00FFFF", blackHex)
        )

        val defaultColor: ColorObject = basicColors[0]

        fun colorPosition(colorObject: ColorObject): Int
        {
            for (i in basicColors.indices)
            {
                if(colorObject == basicColors[i])
                    return i
            }
            return 0
        }
    }


    val hexHash = "#$hex"
    val contrastHexHash = "#$contrastHex"
}
