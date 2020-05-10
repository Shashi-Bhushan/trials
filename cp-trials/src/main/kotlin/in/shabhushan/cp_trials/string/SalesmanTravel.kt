package `in`.shabhushan.cp_trials.string

object SalesmanTravel {
    fun travel(
        r: String,
        zipcode: String
    ): String = r.split(",").filter {
        it.substring(it.length - 8) == zipcode
    }.let {
        val addressList = mutableListOf<String>()
        val houseNumberList = mutableListOf<String>()

        it.forEach {
            val address = it.substring(0, it.length - 9)

            houseNumberList.add(address.takeWhile { it != ' ' })
            addressList.add(address.dropWhile { it != ' ' }.trim())
        }

        "$zipcode:${addressList.joinToString(",")}/${houseNumberList.joinToString(",")}"
    }

    fun travel2(r:String, zipcode:String):String {
        if(zipcode.isEmpty()){
            return ":/"
        }
        var matches = r.split(",").filter{it.endsWith(zipcode)}.map { it.replace(" $zipcode", "") }

        val numbers = matches.map { it.substringBefore(" ") }.joinToString(",")
        val streets = matches.map { it.substringAfter(" ") }.joinToString(",")

        return "$zipcode:$streets/$numbers"
    }
}
