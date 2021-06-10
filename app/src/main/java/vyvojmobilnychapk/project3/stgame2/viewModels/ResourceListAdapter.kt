package vyvojmobilnychapk.project3.stgame2.viewModels

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

import androidx.recyclerview.widget.RecyclerView
import vyvojmobilnychapk.project3.stgame2.R
import vyvojmobilnychapk.project3.stgame2.entities.Resource

class ResourceListAdapter : ListAdapter<Resource,ResourceListAdapter.ResourceViewHolder>(ResourceComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResourceViewHolder {
        return ResourceViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ResourceViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.nameToDisplay)
    }


    class ResourceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val resourceItemView: TextView = itemView.findViewById(R.id.textView)

        fun bind(text: String?) {
            resourceItemView.text = text
        }

        companion object {
            fun create(parent: ViewGroup): ResourceViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recyclerview_item_resource, parent, false)
                return ResourceViewHolder(view)
            }
        }
    }

    class ResourceComparator : DiffUtil.ItemCallback<Resource>() {
        override fun areItemsTheSame(oldItem: Resource, newItem: Resource): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Resource, newItem: Resource): Boolean {
            return oldItem.name == newItem.name
        }
    }
}
