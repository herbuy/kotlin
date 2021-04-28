package users

import core.business_messages.ParamsForAddUser
import shared.Rest

class EventBusForAddUser{
    companion object{
        fun createUser(params: ParamsForAddUser) {
            Rest.api()

        }

    }
}