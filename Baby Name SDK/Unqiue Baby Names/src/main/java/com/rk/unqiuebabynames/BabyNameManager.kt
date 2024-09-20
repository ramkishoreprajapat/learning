package com.rk.unqiuebabynames

class BabyNameManager {
    private val babyNames = mutableListOf( "Olivia", "Liam", "Emma", "Noah", "Ava", "Elijah", "Sophia", "Lucas", "Isabella", "Mason",
        "Mia", "James", "Amelia", "Benjamin", "Harper", "Ethan", "Evelyn", "Alexander", "Abigail", "Henry",
        "Ella", "Sebastian", "Scarlett", "Jackson", "Grace", "Logan", "Chloe", "Levi", "Zoey", "Daniel",
        "Lily", "Owen", "Aria", "Matthew", "Ellie", "Aiden", "Hazel", "Samuel", "Layla", "David",
        "Aurora", "Joseph", "Nora", "Carter", "Riley", "Wyatt", "Lillian", "John", "Paisley", "Jack",
        "Emilia", "Luke", "Penelope", "Julian", "Hannah", "Grayson", "Sofia", "Isaac", "Avery", "Gabriel",
        "Addison", "Anthony", "Aubrey", "Joshua", "Stella", "Andrew", "Natalie", "Christopher", "Savannah", "Thomas",
        "Violet", "Lincoln", "Brooklyn", "Charles", "Zoe", "Hudson", "Leah", "Ezra", "Mila", "Colton",
        "Madison", "Elias", "Elliana", "Aaron", "Victoria", "Adrian", "Bella", "Jonathan", "Lucy", "Nolan",
        "Aaliyah", "Hunter", "Audrey", "Christian", "Clara", "Isaiah", "Nova", "Adam", "Eliana", "Miles")

    /*It will provide a random name from the list of baby names.*/
    fun getRandomBabyName(): String {
        return babyNames.random()
    }

    /*It will provide a list of baby names.*/
    fun getBabyNames(): List<String> {
        return babyNames
    }

    /*It will add a new baby name to the list of baby names.*/
    fun addBabyName(name: String) {
        babyNames.add(name)
    }

    /*It will remove a baby name from the list of baby names.*/
    fun removeBabyName(name: String) {
        babyNames.remove(name)
    }

    /*It will clear the list of baby names.*/
    fun clearBabyNames() {
        babyNames.clear()
    }

    /*It will return the number of baby names in the list.*/
    fun getBabyNameCount(): Int {
        return babyNames.size
    }

    /*It will return the index of a baby name in the list.*/
    fun getBabyNameAtIndex(index: Int): String {
        return babyNames[index]
    }

    /*It will return the index of a baby name in the list.*/
    fun getBabyNameIndex(name: String): Int {
        return babyNames.indexOf(name)
    }

    /*It will return the index of a baby name in the list.*/
    fun getBabyNamesStartingWith(letter: Char): List<String> {
        return babyNames.filter { it.startsWith(letter, ignoreCase = true) }
    }

    /*It will return the index of a baby name in the list.*/
    fun getBabyNamesEndingWith(letter: Char): List<String> {
        return babyNames.filter { it.endsWith(letter, ignoreCase = true) }
    }

    /*It will return the index of a baby name in the list.*/
    fun getBabyNamesContaining(substring: String): List<String> {
        return babyNames.filter { it.contains(substring, ignoreCase = true) }
    }

    /*It will provide list of baby names sorted by length.*/
    fun getBabyNamesSortedByLength(): List<String> {
        return babyNames.sortedBy { it.length }
    }

    /*It will provide list of baby names sorted by alphabetical order.*/
    fun getBabyNamesSortedByAlphabeticalOrder(): List<String> {
        return babyNames.sorted()
    }

    /*It will provide list of baby names sorted by reverse alphabetical order.*/
    fun getBabyNamesSortedByReverseAlphabeticalOrder(): List<String> {
        return babyNames.sortedByDescending { it }
    }

    /*It will provide list of baby names sorted by count.*/
    fun getBabyNamesSortedByCount(): List<String> {
        return babyNames.sortedByDescending { it.length }
    }

    /*It will provide list of baby names sorted by reverse count.*/
    fun getBabyNamesSortedByReverseCount(): List<String> {
        return babyNames.sortedBy { it.length }
    }
}