class Library {
    private var availableBooks: MutableList<Book> = mutableListOf()
    private var busyBooks: MutableList<Book> = mutableListOf()
    private var customers: MutableList<String?> = mutableListOf()

    fun addBook(){
        println("Введите название книги")
        val name = readLine()
        println("Введите автора книги")
        val author = readLine()

        val newBook = Book(name, author)
        availableBooks.add(newBook)
        println("Книга добавлена!")
        println()
    }

    fun addACustomer(){
        println("Введите имя читателя: ")
        val customerName = readLine()
        customers.add(customerName)
        println("Читатель $customerName успешно добавлен!")
    }

    fun findBookByName(){
        if(availableBooks.size == 0){
            println("Нет доступных книг")
            return
        }
        println("Введите название книги:")
        val bookName: String? = readLine()
        if(bookName.isNullOrBlank()){
            println("Некоректный ввод")
            return
        }
        for(book in availableBooks){
            if(book.name?.contains(bookName, ignoreCase = true) == true){
                println("Книга ${book.name}")
                println("Автор ${book.author}")
                println()
            }
        }
    }

    fun findBookByAuthor(){
        if(availableBooks.size == 0){
            println("Нет доступных книг")
            return
        }
        println("Введите автора книги:")
        val author: String? = readLine()
        if(author.isNullOrBlank()){
            println("Некоректный ввод")
            return
        }
        for(book in availableBooks){
            if(book.author?.contains(author, ignoreCase = true) == true){
                println("Книга ${book.name}")
                println("Автор ${book.author}")
                println()
            }
        }
    }

    fun giveABookToReader(){
        if(availableBooks.size == 0){
            println("Нет доступных книг")
            return
        }
        if(customers.size == 0){
            println("Нет доступных читателей")
            return
        }
        for(i in 0..<availableBooks.size){
            var currentBook: Book = availableBooks[i]
            println("${i+1}. ${currentBook.name}")
            println("${currentBook.author}")
        }
        println("Выберите книгу (ее номер)")

        var bookIndex: Int = (readLine()?.toInt() ?: -1) - 1

        if(bookIndex < 0 || bookIndex > availableBooks.size){
            println("Введено некорректное число, самоуничтожаюсь")
            return;
        }

        for(i in 0..<customers.size){
            println("${i+1}. ${customers[i]}")
        }
        println("Выберите читателя (его номер)")

        var customerIndex: Int = (readLine()?.toInt() ?: -1) - 1

        if(customerIndex < 0 || customerIndex > availableBooks.size){
            println("Введено некорректное число, самоуничтожаюсь")
            return;
        }

        var book: Book = availableBooks[bookIndex]
        var customer: String? = customers[customerIndex]
        availableBooks.removeAt(bookIndex)
        book.reader = customer
        busyBooks.add(book)

        println("Книга ${book.name} успешна выдана читателю ${customer}")
    }

    fun returnTheBook(){
        if(busyBooks.size == 0){
            println("Нет доступных для возвращения книг")
            return
        }
        for(i in 0..<busyBooks.size){
            var currentBook: Book = busyBooks[i]
            println("${i+1}. ${currentBook.name}")
            println("${currentBook.author}")
            println("Читатель: ${currentBook.reader}")
        }
        println("Выберите книгу (ее номер)")

        var bookIndex: Int = (readLine()?.toInt() ?: -1) -1

        if(bookIndex < 0 || bookIndex > busyBooks.size){
            println("Введено некорректное число, самоуничтожаюсь")
            return;
        }
        var book: Book = busyBooks[bookIndex]
        book.reader = "Нет"
        busyBooks.removeAt(bookIndex)
        availableBooks.add(book)

        println("Книга успешно возвращена!")
    }

    fun showAllBooks(){
        for(i in 0..<availableBooks.size){
            var currentBook: Book = availableBooks[i]
            println("${i+1}. ${currentBook.name}")
            println("${currentBook.author}")
            println("Читатель: ${currentBook.reader}")
        }
        var count: Int = availableBooks.size

        for(i in 0..<busyBooks.size){
            var currentBook: Book = busyBooks[i]
            println("${count+1}. ${currentBook.name}")
            println("${currentBook.author}")
            println("Читатель: ${currentBook.reader}")
            count++
        }
    }
}