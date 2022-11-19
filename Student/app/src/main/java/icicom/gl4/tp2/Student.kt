package icicom.gl4.tp2

class Student (name :String, lastName:String, gender:String,presences: List<Presence>) {
    val name: String = name
    val lastName:String = lastName
    val gender:String = gender
    val presences = presences;
}

class Presence(matiere:String,presence:Boolean){
     val matiere = matiere;
     val presence = presence;
}