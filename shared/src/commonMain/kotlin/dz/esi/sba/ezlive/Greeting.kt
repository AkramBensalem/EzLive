package dz.esi.sba.ezlive

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}