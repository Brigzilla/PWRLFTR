import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yologames.pwrlftr._session_feedback_left
import com.yologames.pwrlftr.databinding.ProgramCardBinding
import com.yologames.pwrlftr.recyclerview.PCard
import com.yologames.pwrlftr.recyclerview.PCardViewHolder



class PCardAdapter(
    private val PCards: List<PCard>,
    private val callback: MyCallback
) : RecyclerView.Adapter<PCardViewHolder>() {
    // ...


    interface MyCallback {
        fun onItemClicked()
    }

    interface ButtonClickListener {
        fun onButtonClicked()
    }


    @SuppressLint("ResourceType")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PCardViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ProgramCardBinding.inflate(inflater, parent, false)
        return PCardViewHolder(binding, callback)
    }



    override fun onBindViewHolder(holder: PCardViewHolder, position: Int) {

        if (_session_feedback_left.size <= position) {
            _session_feedback_left.add(false)
        }
        holder.bindCards(PCards[position])
    }

    override fun getItemCount(): Int = PCards.size
}
