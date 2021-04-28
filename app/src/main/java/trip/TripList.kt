package trip

import android.content.Context
import android.view.View
import android.widget.Button
import com.skyvolt.kotlin.R

class TripList(context: Context){

    private val layout:Button

    val view: Button
        get() = layout

    init{
        layout = Button(context)
        layout.text = context.getString(R.string.button_text)
    }



}