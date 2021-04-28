package shared

import core.business_messages.ParamsForAddUser
import core.businessobjects.User
import retrofit2.Call

interface Api {
    fun addUser(params: ParamsForAddUser):Call<User>

}