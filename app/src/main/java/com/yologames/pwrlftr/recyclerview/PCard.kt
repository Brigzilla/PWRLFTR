package com.yologames.pwrlftr.recyclerview
var PCardList = mutableListOf<PCard>()

class PCard(
    var title: String,
    var exercise: String,
    var sets: Int,
    var reps: Int,
    var weight: Int,
    var id: Int? = PCardList.size
) {
}