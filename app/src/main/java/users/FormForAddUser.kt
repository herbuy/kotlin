package users

import android.content.Context
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import core.business_messages.ParamsForAddUser
import shared.Atom

class FormForAddUser(val context: Context){


    val view: View
        get() {
            return mForm
        }

    //the view am trying to return must exist else error will be thrown
    val mForm:LinearLayout

    init{
        //the view must also be initiazed/created so that it is not null
        mForm = LinearLayout(context)
        //we want items to flow downwards [to be stacked up]
        mForm.orientation = LinearLayout.VERTICAL

        //lets add a field for mobile number
        mForm.addView(title())
        mForm.addView(mobileNumber())
        mForm.addView(password())
        mForm.addView(submitButton())
    }

    private fun submitButton(): Button {
        return Atom.button(context,"Create Account", View.OnClickListener{
            val params : ParamsForAddUser = readParamsFromUI()
            EventBusForAddUser.createUser(params)
        })
    }

    private fun readParamsFromUI(): ParamsForAddUser {
        val params = ParamsForAddUser()
        params.mobileNumber = editMobileNumber?.text.toString()
        params.password = editPassword?.text.toString()
        return params
    }

    private fun title(): View {
        return Atom.textView(context,"Create account")
    }

    var editPassword: EditText? = null
    private fun password(): View {
        editPassword = Atom.editText(context,"Password")
        return editPassword as EditText
    }

    var editMobileNumber: EditText? = null
    private fun mobileNumber(): EditText {
        editMobileNumber = Atom.editText(context,"Your mobile")
        return editMobileNumber as EditText
    }

}