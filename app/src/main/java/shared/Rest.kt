package shared


class Rest{
    companion object{
        fun api(): Api{
            return LocalAPI()
        }
    }
}