package makoto.yoshida.uitesttutorial

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import makoto.yoshida.uitesttutorial.TestEntityListAdapter.TestEntityViewHolder
import makoto.yoshida.uitesttutorial.databinding.TestEntityListCellBinding
import makoto.yoshida.uitesttutorial.domain.TestEntity

class TestEntityListAdapter : ListAdapter<TestEntity, TestEntityViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TestEntity>() {
            override fun areItemsTheSame(oldItem: TestEntity, newItem: TestEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TestEntity, newItem: TestEntity): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestEntityViewHolder {
        val binding = DataBindingUtil.inflate<TestEntityListCellBinding>(
            LayoutInflater.from(parent.context),
            R.layout.test_entity_list_cell,
            parent,
            false
        )
        return TestEntityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TestEntityViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class TestEntityViewHolder(private val binding: TestEntityListCellBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: TestEntity) {
            binding.text.text = "${item.id} : ${item.name}"
        }
    }
}