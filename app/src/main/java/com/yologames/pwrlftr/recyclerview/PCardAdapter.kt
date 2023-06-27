import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yologames.pwrlftr.MainActivity
import com.yologames.pwrlftr._session_feedback_left
import com.yologames.pwrlftr.databinding.ProgramCardBinding
import com.yologames.pwrlftr.recyclerview.PCard
import com.yologames.pwrlftr.recyclerview.PCardViewHolder

private var listener: PCardAdapter.MyCallback? = null


class PCardAdapter(private val PCards: List<PCard>): RecyclerView.Adapter<PCardViewHolder>() {

    interface MyCallback {
        fun onItemClicked()
    }



    @SuppressLint("ResourceType")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PCardViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ProgramCardBinding.inflate(inflater, parent, false)
        val mainActivity = parent.context as? MainActivity
        val viewHolder = mainActivity?.let { PCardViewHolder(binding, it) }
        viewHolder?.setIsRecyclable(false) // Optional: Disable view recycling to maintain item states
        viewHolder?.let {
            it.itemView.setOnClickListener { _ ->
                listener?.onItemClicked()
            }
        }
        return viewHolder ?: throw IllegalStateException("MainActivity not found in the context")
    }



    override fun onBindViewHolder(holder: PCardViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            listener?.onItemClicked()
        }
        if (_session_feedback_left.size <= position) {
            _session_feedback_left.add(false)
        }
        holder.bindCards(PCards[position])
    }

    override fun getItemCount(): Int = PCards.size
}
