import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ec12.Pelicula
import com.example.ec12.R

class CustomAdapter(private val dataSet: List<Pelicula>,
    private val mOnItemClickListener: (pelicula : Pelicula)-> Unit)
    : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ViewPlaneta: View =view.findViewById(R.id.pelicula)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate( R.layout.view_pelicula, parent,false)
        return ViewHolder(view)
    }
    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val nombre_pelicula= viewHolder.ViewPlaneta.findViewById<TextView>(R.id.nombre_pelicula)
        val horario_pelicula= viewHolder.ViewPlaneta.findViewById<TextView>(R.id.horario_pelicula)
        nombre_pelicula.text= dataSet[position].nombre
        horario_pelicula.text = dataSet[position].hora

        viewHolder.itemView.setOnClickListener{
            mOnItemClickListener(dataSet[position])
        }

    }
    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size
}