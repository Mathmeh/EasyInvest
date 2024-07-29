import androidx.recyclerview.widget.DiffUtil
import com.example.easyinvest.Domain.Entity.Asset

class AssetDiffCallback : DiffUtil.ItemCallback<Asset>() {
    override fun areItemsTheSame(oldItem: Asset, newItem: Asset): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Asset, newItem: Asset): Boolean {
        return oldItem == newItem
    }
}
