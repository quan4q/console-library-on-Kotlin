
fun main() {
    var choice: String? = ""
    val library = Library()

    while(true){
        println("Выберите действие:")
        println("1. Добавить книгу")
        println("2. Добавить читателя")
        println("3. Найти книгу по названию")
        println("4. Найти книги по автору")
        println("5. Выдать книгу")
        println("6. Вернуть книгу")
        println("7. Показать все книги")
        println("8. Выход")
        choice = readLine()

        when(choice?.toInt() ?: 8){
            1 -> library.addBook()
            2 -> library.addACustomer()
            3 -> library.findBookByName()
            4 -> library.findBookByAuthor()
            5 -> library.giveABookToReader()
            6 -> library.returnTheBook()
            7 -> library.showAllBooks()
            8 -> break
            else -> break
        }
    }
}