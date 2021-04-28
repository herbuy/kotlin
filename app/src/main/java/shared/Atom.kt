package shared

import android.content.Context
import android.text.InputType
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Atom{

    //we place static functions inside a companion object. how is this a more OOP friendly way to store static functions
     companion object{

         fun editText(context: Context, hint: String): EditText{
             val editText = EditText(context)
             editText.setHint(hint)
             editText.inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD
             return editText
         }

        fun textView(context: Context, text: String): View {
            val textView = TextView(context)
            textView.text = text
            return textView
        }

        fun button(context: Context, text: String, onClickListener: View.OnClickListener): Button {
            val btn = Button(context)
            btn.text = "text"
            btn.setOnClickListener(onClickListener)
            return btn
        }

    }
}