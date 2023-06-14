package com.yologames.pwrlftr.recyclerview
var PCardList = mutableListOf<PCard>()

class PCard(
    var title: String,
    var exercise: String,
    var aspect0: String,
    var aspect1: String,
    var aspect2: String,
    var aspect3: String,
    var aspect4: String,
    var aspect5: String,
    var aspect6: String,
    var aspect7: String,
    var aspect8: String,
    var aspect9: String,
    var id: Int? = PCardList.size
) {
}