import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ec12.Pelicula
import com.example.ec12.R

class CustomAdapter(private val dataSet: List<Pelicula>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    private lateinit var mListener2: onItemClickListener
    interface onItemClickListener{
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(listener: onItemClickListener){
        mListener2=listener
    }

    class ViewHolder(view: View, listener: onItemClickListener) : RecyclerView.ViewHolder(view) {
        val textView: View =view.findViewById(R.id.pelicula)
        init {
            view.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context).inflate(
            R.layout.view_pelicula,
            viewGroup,
            false)
        return ViewHolder(view,mListener2)
    }
    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element

        val nombre_pelicula= viewHolder.textView.findViewById<TextView>(R.id.nombre_pelicula)
        val horario_pelicula= viewHolder.textView.findViewById<TextView>(R.id.horario_pelicula)
        nombre_pelicula.text= dataSet[position].nombre
        horario_pelicula.text = dataSet[position].hora


    }
    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size
}