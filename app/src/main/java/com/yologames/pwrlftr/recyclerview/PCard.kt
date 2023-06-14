package com.yologames.pwrlftr.recyclerview
var PCardList = mutableListOf<PCard>()

class PCard(
    var title: String,
    var exercise: String,
    var aspect0: Int,
    var aspect1: Int,
    var aspect2: Int,
    var aspect3: Int,
    var aspect4: Int,
    var aspect5: Int,
    var aspect6: Int,
    var aspect7: Int,
    var aspect8: Int,
    var aspect9: Int,
    var id: Int? = PCardList.size
) {
}