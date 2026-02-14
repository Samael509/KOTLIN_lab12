package example
import kotlin.properties.Delegates

class UserProfile(initialName: String, initialEmail: String){
    var name: String by Delegates.observable(initialName){
            _, old, new ->
        println("имя изменено: '$old' -> '$new'")
    }
    var email: String by Delegates.observable(initialEmail){
            _, old, new ->
        println("email обновлён: '$old' -> '$new'")
    }
    val avatar: String by lazy {
        println("загружаем аватар для $name....")
        "avatar_of_$name.png"
    }
}

fun main(){
    println("создаём профиль пользователя...")
    val user = UserProfile("alisa", "alice@example.com")

    println("\nимя: ${user.name}")
    println("email: ${user.email}")

    println("\nобращаемся к аватару впервые:")
    println("файл аватара: ${user.avatar}")

    println("\nобращаемся к аватару снова:")
    println("файл аватара: ${user.avatar}")

    println("\nменяем email:")
    user.email = "alice_new@example.org"

    println("\nменяем имя:")
    user.name = "алиса к."

}