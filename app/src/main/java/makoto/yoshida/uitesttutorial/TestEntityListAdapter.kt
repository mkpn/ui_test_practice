package makoto.yoshida.uitesttutorial

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import makoto.yoshida.uitesttutorial.TestEntityListAdapter.TestDataClassViewHolder
import makoto.yoshida.uitesttutorial.databinding.TestEntityListCellBinding
import makoto.yoshida.uitesttutorial.domain.TestDataClass

class TestEntityListAdapter : ListAdapter<TestDataClass, TestDataClassViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TestDataClass>() {
            override fun areItemsTheSame(oldItem: TestDataClass, newItem: TestDataClass): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TestDataClass, newItem: TestDataClass): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestDataClassViewHolder {
        val binding = DataBindingUtil.inflate<TestEntityListCellBinding>(
            LayoutInflater.from(parent.context),
            R.layout.test_entity_list_cell,
            parent,
            false
        )
        return TestDataClassViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TestDataClassViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class TestDataClassViewHolder(private val binding: TestEntityListCellBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: TestDataClass) {
            binding.text.text = "${item.id} : ${item.name}"
        }
    }
}