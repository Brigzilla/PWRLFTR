import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yologames.pwrlftr.MainActivity
import com.yologames.pwrlftr._session_feedback_left
import com.yologames.pwrlftr.databinding.ProgramCardBinding
import com.yologames.pwrlftr.recyclerview.PCard
import com.yologames.pwrlftr.recyclerview.PCardViewHolder

class PCardAdapter(private val PCards: List<PCard>): RecyclerView.Adapter<PCardViewHolder>() {

    @SuppressLint("ResourceType")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PCardViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = ProgramCardBinding.inflate(from, parent, false)
        val mainActivity = parent.context as? MainActivity
        return mainActivity?.let { PCardViewHolder(binding, it) }
            ?: throw IllegalStateException("MainActivity not found in the context")
    }

    override fun onBindViewHolder(holder: PCardViewHolder, position: Int) {
        if (_session_feedback_left.size <= position) {
            _session_feedback_left.add(false)
        }
        holder.bindCards(PCards[position])
    }

    override fun getItemCount(): Int = PCards.size
}
