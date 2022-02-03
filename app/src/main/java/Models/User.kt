package Models

class User {
    var name = ""
    var number = ""


    constructor()
    constructor(name: String, number: String) {
        this.name = name
        this.number = number
    }
}