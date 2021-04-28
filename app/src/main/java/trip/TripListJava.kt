package trip

import android.content.Context
import android.view.View
import android.widget.Button
import android.widget.LinearLayout

class TripListJava(private val context: Context) {
    private val layout: LinearLayout
    private fun child(): View {
        val btn = Button(context)
        btn.text = "Hey"
        return btn
    }

    val view: View
        get() = layout

    init {
        layout = LinearLayout(context)
        layout.addView(child())
    }
}