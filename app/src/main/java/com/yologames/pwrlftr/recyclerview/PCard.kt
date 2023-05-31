package com.yologames.pwrlftr.recyclerview
var PCardList = mutableListOf<PCard>()

class PCard(
    var title: String,
    var exercise: String,
    var sets: String,
    var reps: String,
    var id: Int? = PCardList.size
) {
}