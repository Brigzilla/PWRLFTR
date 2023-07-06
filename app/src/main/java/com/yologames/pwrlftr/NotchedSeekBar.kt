import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.SeekBar
import androidx.appcompat.widget.AppCompatSeekBar
import com.yologames.pwrlftr.R

class NotchedSeekBar : androidx.appcompat.widget.AppCompatSeekBar {
    private val textPaint: Paint = Paint().apply {
        isAntiAlias = true
        textSize = resources.getDimensionPixelSize(R.dimen.seek_bar_notch_text_size).toFloat()
        textAlign = Paint.Align.CENTER
        color = resources.getColor(R.color.seek_bar_notch_text_color, null)
    }

    private var notchCount: Int = 0

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    fun setNotchCount(count: Int) {
        notchCount = count
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val width = measuredWidth - paddingLeft - paddingRight
        val notchWidth = width.toFloat() / notchCount

        for (i in 0..notchCount) {
            val x = paddingLeft + (notchWidth * i)
            val y = measuredHeight / 2f + textPaint.textSize / 2f

            canvas.drawText(i.toString(), x, y, textPaint)
        }
    }
}
