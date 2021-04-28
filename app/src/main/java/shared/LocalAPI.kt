package shared

import android.os.Handler
import core.business_messages.ParamsForAddUser
import core.businessobjects.User
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//TODO: NEXT TASK: generalize herbuyapi, implement storing user to database
//TODO: LATER tasks: open a project or repo on github under herbuy [one for creating local database based on shared preferences] so others can contribute and in preparation for kotlin
class LocalAPI : Api {
    override fun addUser(params: ParamsForAddUser): Call<User> {
        return object: HerbuyCall(){
            override fun body(): User? {
                return User()
            }

        }
    }

    //==============
    private abstract class HerbuyCall : Call<User>{
        override fun enqueue(callback: Callback<User>?) {
            Handler().postDelayed(Runnable {
                try {
                    callback?.onResponse(this@HerbuyCall,Response.success(body()))
                }
                catch (t: Throwable){
                    callback?.onFailure(this@HerbuyCall,t)
                }
            },1000)
        }

        abstract open fun body(): User?

        override fun isExecuted(): Boolean {
            return false
        }

        override fun clone(): Call<User> {
            return Object() as Call<User>
        }

        override fun isCanceled(): Boolean {
            return false
        }

        override fun cancel() {

        }

        override fun execute(): Response<User> {
            return Object() as Response<User>
        }

        override fun request(): Request {
            return Object() as Request
        }

    }

}