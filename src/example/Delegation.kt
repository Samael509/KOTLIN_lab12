package example
import kotlin.properties.Delegates


interface Base {
    fun someFun()
}
class BaseImpl() : Base{
    override fun someFun() {}
}
class Derived(SomeBase: Base) : Base by SomeBase

interface Messenger{
    fun sendTextMessage()
    fun sendVideoMessage()
}
class InstantMessenger(val programName: String) : Messenger{
    override fun sendTextMessage() = println("send text message")
    override fun sendVideoMessage() = println("send video message")
}
class SmartPhone(val name: String, m: Messenger): Messenger by m{
    override fun sendTextMessage() = println("send sms")
}

interface PhotoDevice{
    fun takePhoto()
}
class PhotoCamera: PhotoDevice{
    override fun takePhoto() = println("take a photo")
}

var counter: Int by Delegates.observable(0) { _, old, new ->
    println("счётчик изменился: $old -> $new")
}

fun main(){
    val telega = InstantMessenger("Telegram")
    val photoCamera = PhotoCamera()
    val yotaPhone = SmartPhone("YotaPhone", telega)
    yotaPhone.sendTextMessage()
    yotaPhone.sendVideoMessage()
    counter = 1
    counter = 5
}